package parser;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.antlr.CBaseVisitor;
import parser.antlr.CLexer;
import parser.antlr.CParser;
import parser.antlr.CVisitor;
import parser.syntaxtree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Visitor  extends CBaseVisitor<CNode>
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
        Block block = (Block) this.visitBlock(ctx.block());
        return new Function(type, name, block);
    }

    @Override
    public CNode visitBlock(CParser.BlockContext ctx)
    {
        Block block = new Block();
        for (CParser.StatementContext context: ctx.statement())
        {
            Statement statement = (Statement) this.visitStatement(context);
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
        if (ctx.BooleanConstant() != null)
        {
            boolean value = ctx.getText().equals("true");
            return new BooleanConstant(value);
        }

        if(ctx.functionCall() != null)
        {
            // determine if it is an assertion
            return this.visitFunctionCall(ctx.functionCall());
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
            return new Assert(expression);
        }

        throw new UnsupportedOperationException();
    }

}
