package cparser.syntaxtree;

import symbolicengine.StatePath;

public class PlusPlusStatement extends Statement
{
    public Variable variable;
    private Expression expression;
    public PlusPlusStatement(Variable variable)
    {
        this.variable = variable;
        this.expression = new BinaryExpression("+",
                variable, new IntegerConstant(1));
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
        this.expression.execute(function, this);

        // assignment changes the state of one variable
        this.endStates = StatePath.copy(this.startStates);



        for (StatePath statePath : this.endStates)
        {
            // evaluate the expression
            String expressionValue = this.expression.evaluate(statePath);

            // update the state
            statePath.symbolTable.put(this.variable.name, expressionValue);
        }
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }

    @Override
    public String toString()
    {
        return "PlusPlusStatement(" + variable + "++)";
    }
}
