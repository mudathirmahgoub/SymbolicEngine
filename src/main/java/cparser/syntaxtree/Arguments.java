package cparser.syntaxtree;

import java.util.HashMap;
import java.util.Map;

public class Arguments extends  CNode
{
    public Map<String, String> arguments = new HashMap<>();
    @Override
    public void execute(Function function, CNode parent)
    {
        // no action is required
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getType(String variableName)
    {
        throw new UnsupportedOperationException();
    }

}
