package cparser.syntaxtree;

import symbolicengine.StatePath;

public class NoOperation extends Statement
{
    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
        // no change in states
        this.endStates = StatePath.copy(this.startStates);
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }

    @Override
    public String toString()
    {
        return "NoOperation";
    }
}
