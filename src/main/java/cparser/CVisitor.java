package cparser;

import cparser.antlr.CBaseVisitor;
import cparser.antlr.CLexer;
import cparser.antlr.CParser;
import cparser.syntaxtree.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.Token;

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

        // ++
        if(ctx.PlusPlus() != null)
        {
            Variable variable = new Variable(ctx.Identifier().getText());
            return new PlusPlusStatement(variable);
        }

        // assignment statement
        if(ctx.Identifier() != null && ctx.expression()!= null)
        {
            Variable variable =  new Variable(ctx.Identifier().getText());
            Expression expression = (Expression) this.visitExpression(ctx.expression());
            return new Assignment(variable, expression);
        }

        if(ctx.variableDefinition() != null)
        {
            return this.visitVariableDefinition(ctx.variableDefinition());
        }
        if(ctx.functionCall() != null)
        {
            return this.visitFunctionCall(ctx.functionCall());
        }

        if(ctx.getChild(0) instanceof TerminalNode)
        {
            Token symbol = ((TerminalNode) ctx.getChild(0)).getSymbol();
            // if statement
            if(symbol.getType() == CLexer.If)
            {
                return getIfStatement(ctx);
            }
            if(symbol.getType() == CLexer.Return)
            {
                if(ctx.expression() != null)
                {
                    Expression expression = (Expression)
                            visitExpression(ctx.expression());
                    return  new ReturnStatement(expression);
                }
                return new ReturnStatement();
            }

        }
        throw new UnsupportedOperationException();
    }

    private CNode getIfStatement(CParser.StatementContext ctx)
    {
        Expression condition = (Expression) visitExpression(ctx.expression());
        Statement trueStatement = (Statement) visitStatement(ctx.statement(0));
        IfStatement ifStatement = new IfStatement(condition, trueStatement);
        // else statement
        if(ctx.statement().size() > 1)
        {
            Statement falseStatement = (Statement)
                    visitStatement(ctx.statement(0));
            ifStatement.falseStatement = falseStatement;
        }
        else
        {
            ifStatement.falseStatement = new NoOperation();
        }
        return ifStatement;
    }

    @Override
    public CNode visitVariableDefinition(CParser.VariableDefinitionContext ctx)
    {
        String type = ctx.type().getText();
        Variable variable = new Variable(ctx.Identifier().getText());
        VariableDefinition definition = new VariableDefinition(type, variable);
        if(ctx.expression() != null)
        {
            Expression expression = (Expression) visitExpression(ctx.expression());
            definition.expression = expression;
        }
        return definition;
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
                String operator = ctx.getChild(0).getText();
                Expression expression = (Expression) this.visitExpression(ctx.expression(0));
                return new UnaryExpression(operator, expression);
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
