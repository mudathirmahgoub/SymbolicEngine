package parser.syntaxtree;

import java.util.Arrays;
import java.util.List;

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
    protected List<String> getFormulas()
    {
        return Arrays.asList("" + value);
    }

    @Override
    public boolean isBoolean()
    {
        return true;
    }
}
