package cparser.syntaxtree;

import symbolicengine.StatePath;

public class BinaryExpression extends Expression
{

    public String binaryOperator;

    public Expression left;

    public Expression right;

    public BinaryExpression(String binaryOperator, Expression left, Expression right)
    {
        this.binaryOperator = binaryOperator;
        this.left = left;
        this.right = right;
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }

    @Override
    public boolean isBoolean()
    {
        switch (binaryOperator)
        {
            case "*":
            case "/":
            case "+":
            case "-":
            case "%":
                return false;

            case ">":
            case ">=":
            case "<":
            case "<=":
            case "!=":
            case "==":
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
        String leftFormula = left.evaluate(statePath);
        String rightFormula = right.evaluate(statePath);

        switch (binaryOperator)
        {
            case "==":
                formula = "(= " + leftFormula + " " + rightFormula + ")";
                break;
            case "!=":
                formula = "(not (= " + leftFormula + " " + rightFormula + "))";
                break;
            case "%":
                formula = "(mod " + leftFormula + " " + rightFormula + ")";
                break;
            default:
                formula = "(" + binaryOperator + " " + leftFormula + " " + rightFormula + ")";
        }
        return formula;
    }
}
