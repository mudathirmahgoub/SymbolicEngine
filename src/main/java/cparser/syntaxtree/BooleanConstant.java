package cparser.syntaxtree;

import symbolicengine.StatePath;

public class BooleanConstant extends  Constant
{
    boolean value;
    public BooleanConstant(boolean value)
    {
        this.value = value;
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
        // Nothing to be done here
    }

    @Override
    protected String getType(String variableName)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String evaluate(StatePath statePath)
    {
        return "" + value;
    }

    @Override
    public boolean isBoolean()
    {
        return true;
    }

    @Override
    public String toString()
    {
        return "BooleanConstant(" + this.value + ")";
    }
}
