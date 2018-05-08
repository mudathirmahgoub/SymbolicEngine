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
            LogicalExpression expression = (LogicalExpression) this.visitArgumentExpressions(ctx.argumentExpressions());
            return new Assert(expression);
        }

        throw new UnsupportedOperationException();
    }
}
