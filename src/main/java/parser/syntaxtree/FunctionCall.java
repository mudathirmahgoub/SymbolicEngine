package parser.syntaxtree;

import java.util.List;

public class FunctionCall extends Statement
{
    @Override
    public void execute(Function function)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected List<String> getFormulas()
    {
        throw new UnsupportedOperationException();
    }
}