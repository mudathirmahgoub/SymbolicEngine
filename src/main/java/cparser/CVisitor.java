package cparser;

import cparser.antlr.CBaseVisitor;
import cparser.antlr.CParser;
import cparser.syntaxtree.*;

public class CVisitor extends CBaseVisitor<CNode>
{
    @Override
    public CNode visitProgram(CParser.ProgramContext ctx)
    {
        Program program = new Program();

        for (CParser.FunctionDefinitionContext context:   ctx.functionDefinition())
        {
            Function function = (Function) this.visitFunctionDefinition(context);
            program.functions.add(function);
        }

        for (CParser.VariableDefinitionContext context:   ctx.variableDefinition())
        {
            throw new UnsupportedOperationException();
        }

        return program;
    }

    @Override
    public CNode visitFunctionDefinition(CParser.FunctionDefinitionContext ctx)
    {
        String type = ctx.type().getText();
        String name = ctx.Identifier().getText();
        Arguments arguments = (Arguments) this.visitArguments(ctx.arguments());
        Block block = (Block) this.visitBlock(ctx.block());

        Function function = new Function(type, name, arguments, block);
        block.parent = function;
        return function;
    }

    @Override
    public CNode visitArguments(CParser.ArgumentsContext ctx)
    {
        Arguments arguments = new Arguments();
        if(ctx != null)
        {
            for (CParser.ArgumentContext context : ctx.argument())
            {
                arguments.arguments.put(context.Identifier().getText(),
                        context.type().getText());
            }
        }
        return arguments;
    }

    @Override
    public CNode visitBlock(CParser.BlockContext ctx)
    {
        Block block = new Block();
        for (int i = 0; i < ctx.statement().size(); i++)
        {
            Statement statement = (Statement) this.visitStatement(ctx.statement(i));
            if(i == 0)
            {
                // the parent of the previous statement is the
                statement.parent = block;
            }
            else
            {
                // the parent of each statement is the previous statement
                statement.parent = block.statements.get(i - 1);
            }
            block.statements.add(statement);
        }
        return block;
    }

    @Override
    public CNode visitStatement(CParser.StatementContext ctx)
    {
        if (ctx.block() != null)
        {
            return this.visitBlock(ctx.block());
        }
        if(ctx.variableDefinition() != null)
        {
            throw new UnsupportedOperationException();
        }
        if(ctx.functionCall() != null)
        {
            return this.visitFunctionCall(ctx.functionCall());
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public CNode visitExpression(CParser.ExpressionContext ctx)
    {

        if(ctx.Identifier() != null)
        {
            return new Variable(ctx.Identifier().getText());
        }

        if (ctx.BooleanConstant() != null)
        {
            boolean value = ctx.getText().equals("true");
            return new BooleanConstant(value);
        }

        if (ctx.Integer() != null)
        {
            int value = Integer.parseInt(ctx.Integer().getText());
            return new IntegerConstant(value);
        }

        if(ctx.functionCall() != null)
        {
            // determine if it is an assertion
            return this.visitFunctionCall(ctx.functionCall());
        }

        if(ctx.expression().size() > 0)
        {
            //unary expression
            if(ctx.expression().size() == 1)
            {
                throw new UnsupportedOperationException();
            }

            String operator = ctx.getChild(1).getText();
            Expression left = (Expression) this.visitExpression(ctx.expression(0));
            Expression right = (Expression) this.visitExpression(ctx.expression(1));
            return new BinaryExpression(operator, left, right);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public CNode visitFunctionCall(CParser.FunctionCallContext ctx)
    {
        // determine if is an assertion
        String functionName = ctx.Identifier().getText();
        if(functionName.equals("assert"))
        {
            // there should be exactly one expression
            Expression expression = (Expression) this.visitExpression(ctx.expression(0));
            return new Assertion(expression);
        }

        throw new UnsupportedOperationException();
    }

}
