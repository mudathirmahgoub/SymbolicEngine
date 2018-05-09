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
    public void execute(Function function)
    {
        // Nothing to be done here
    }

    @Override
    protected List<String> getFormulas()
    {
        return Arrays.asList("" + value);
    }
}
