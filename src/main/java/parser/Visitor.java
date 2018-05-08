package parser;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.antlr.CBaseVisitor;
import parser.antlr.CParser;
import parser.antlr.CVisitor;
import parser.syntaxtree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Visitor  extends CBaseVisitor<CNode>
{
    @Override
    public CNode visitPostfixExpression(CParser.PostfixExpressionContext ctx)
    {
        // determine the type of the expression
        if(ctx.children.size() <= 1)
        {
            //ToDo: remove this line
            System.out.println(ctx.getText());
            return super.visitPostfixExpression(ctx);
        }

        // get the second child
        ParseTree secondChild =  ctx.children.get(1);
        // check if the expression is a function call
        if(secondChild instanceof  TerminalNode && secondChild.getText().equals("("))
        {
            // get the name of the function

            String functionName = ctx.children.get(0).getText();
            if(functionName.equals("assert"))
            {
                LogicalExpression expression = (LogicalExpression)
                        this.visitArgumentExpressionList(ctx.argumentExpressionList());
                return new Assert(expression);
            }
            throw new UnsupportedOperationException();
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public CNode visitChildren(RuleNode ruleNode) {

        int n = ruleNode.getChildCount();

        if(n == 1)
        {
            ParseTree c = ruleNode.getChild(0);
            CNode childResult = c.accept(this);
            return childResult;
        }

        return super.visitChildren(ruleNode);
    }
}
