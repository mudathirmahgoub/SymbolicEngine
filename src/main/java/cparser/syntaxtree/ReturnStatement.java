package cparser.syntaxtree;

import java.util.ArrayList;

public class ReturnStatement extends Statement
{
    // can be null
    public Expression expression;

    public ReturnStatement() {}
    public ReturnStatement(Expression expression)
    {
        this.expression = expression;
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;

        //ToDo: review the end states of return (possibly empty)
        this.endStates = new ArrayList<>();
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }
}
