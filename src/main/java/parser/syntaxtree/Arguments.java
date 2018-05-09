package parser.syntaxtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    protected List<String> getFormulas() {
        return new ArrayList<>();
    }
}
