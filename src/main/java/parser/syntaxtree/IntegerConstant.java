package parser.syntaxtree;

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
    public String evaluate()
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
