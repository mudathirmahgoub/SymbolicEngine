package parser.syntaxtree;

import symbolicengine.StatePath;

import java.util.Arrays;
import java.util.List;

public class IntegerConstant extends Constant
{
    int value;
    public IntegerConstant(int value)
    {
        this.value = value;
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
    }

    @Override
    public String evaluate(StatePath statePath)
    {
        return "" + value;
    }

    @Override
    protected String getType(String variableName)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isBoolean()
    {
        return false;
    }
}
