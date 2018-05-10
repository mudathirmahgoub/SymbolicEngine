package cparser.syntaxtree;

public class FunctionCall extends Statement
{
    @Override
    public void execute(Function function, CNode parent)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getType(String variableName)
    {
        throw new UnsupportedOperationException();
    }

}
