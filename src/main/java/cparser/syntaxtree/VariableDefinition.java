package cparser.syntaxtree;

import symbolicengine.StatePath;

public class VariableDefinition extends Statement
{
    public String type;
    public Variable variable;
    public Expression expression;

    public VariableDefinition(String type, Variable variable)
    {
        this.type = type;
        this.variable = variable;
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
        if(expression != null)
        {
            this.expression.execute(function, this);
        }

        // variable definition adds a new variable to the state
        this.endStates = StatePath.copy(this.startStates);

        for (StatePath statePath : this.endStates)
        {
            // check if the variable already defined in the current state
            if(statePath.symbolTable.containsKey(variable.name))
            {
                // the variable needs to be renamed
                throw new UnsupportedOperationException();
            }

            if(this.expression == null)
            {
                String symbolicValue = CNode.getNewSymbolicValue();
                statePath.symbolTable.put(variable.name, symbolicValue);
            }
            else
            {
                // evaluate the expression
                String expressionValue = this.expression.evaluate(statePath);

                // update the state
                statePath.symbolTable.put(this.variable.name, expressionValue);
            }
        }
    }

    @Override
    protected String getType(String variableName)
    {
        if(variable.name.equals(variableName))
        {
            return this.type;
        }
        return parent.getType(variableName);
    }

    @Override
    public String toString()
    {
        return "VariableDefinition: " + type +" "+ variable.name;
    }
}
