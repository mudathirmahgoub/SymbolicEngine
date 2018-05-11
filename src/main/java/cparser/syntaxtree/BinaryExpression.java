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
        if(this.binaryOperator.equals("/"))
        {
            // make sure the denominator is not zero
            BinaryExpression expression = new BinaryExpression("!=", right,
                    new IntegerConstant(0));
            Assertion assertion = new Assertion(expression);
            // get the start state
            CNode parentStatement = parent;
            while(!(parentStatement instanceof Statement))
            {
                parentStatement = parentStatement.parent;
            }
            assertion.startStates = parentStatement.startStates;
            assertion.execute(function, this);
        }
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

    @Override
    public String toString()
    {
        return "BinaryExpression(" + left + " " + binaryOperator +" " + right + ")";
    }
}
