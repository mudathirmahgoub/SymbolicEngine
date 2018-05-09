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
    public void execute(Function function)
    {
        // Nothing to be done here
    }

    @Override
    protected List<String> getFormulas()
    {
        return Arrays.asList("" + value);
    }

    @Override
    public boolean isBoolean()
    {
        return false;
    }
}
