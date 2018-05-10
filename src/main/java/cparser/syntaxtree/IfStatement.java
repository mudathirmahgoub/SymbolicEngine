package cparser.syntaxtree;

import symbolicengine.StatePath;


public class IfStatement extends Statement
{
    public Expression condition;
    public Statement trueStatement;
    public Statement falseStatement;

    public IfStatement(Expression condition, Statement trueStatement)
    {
        this.condition = condition;
        this.trueStatement = trueStatement;
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;

        this.condition.execute(function, this);

        trueStatement.startStates = StatePath.copy(this.startStates);
        // add the condition to the constraints
        for (StatePath statePath : trueStatement.startStates)
        {
            String conditionTrue = condition.evaluate(statePath);
            statePath.constraint += "(assert " + conditionTrue + ")";
        }

        this.trueStatement.execute(function, this);
        this.endStates = StatePath.copy(trueStatement.endStates);

        falseStatement.startStates = StatePath.copy(this.startStates);
        // add the condition to the constraints
        for (StatePath statePath : falseStatement.startStates)
        {
            String conditionTrue = condition.evaluate(statePath);
            statePath.constraint += "(assert (not " + conditionTrue + "))";
        }
        this.falseStatement.execute(function, this);
        this.endStates.addAll(StatePath.copy(falseStatement.endStates));
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }
}
