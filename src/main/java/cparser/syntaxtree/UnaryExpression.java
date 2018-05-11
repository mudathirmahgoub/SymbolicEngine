package cparser.syntaxtree;

import symbolicengine.StatePath;

public class UnaryExpression extends Expression
{

    public String unaryOperator;

    public Expression expression;

    public UnaryExpression(String unaryOperator, Expression expression)
    {
        this.unaryOperator = unaryOperator;
        this.expression = expression;
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }

    @Override
    public boolean isBoolean()
    {
        switch (unaryOperator)
        {
            case "-":
                return false;
            case "!":
                return true;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
    }

    @Override
    public String evaluate(StatePath statePath)
    {
        String formula;
        String expressionFormula = expression.evaluate(statePath);

        switch (unaryOperator)
        {
            case "-":
                formula = "(- " + expressionFormula + ")";
                break;
            case "!":
                formula = "(not " + expressionFormula + ")";
                break;

            default:
                throw new UnsupportedOperationException();
        }
        return formula;
    }

    @Override
    public String toString()
    {
        return "UnaryExpression(" + unaryOperator +"(" + expression + "))";
    }
}
