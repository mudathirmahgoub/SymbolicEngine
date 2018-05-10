package cparser.syntaxtree;

import symbolicengine.StatePath;

public class Assignment extends Statement
{
    public Variable variable;
    public Expression expression;

    public Assignment(Variable variable, Expression expression)
    {
        this.variable = variable;
        this.expression = expression;
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
        return "Assignment: " + variable + " = "+ expression.toString() + ";";
    }
}
