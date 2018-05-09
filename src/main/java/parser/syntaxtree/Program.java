package parser.syntaxtree;

import symbolicengine.Formula;

import java.util.ArrayList;
import java.util.List;

public class Program extends  CNode
{
    public List<Function> functions = new ArrayList<>();

    @Override
    public void execute(Function f, CNode parent)
    {
        // symbolically execute each function
        for (Function function : functions)
        {
            function.execute(function, null);
        }
    }

    @Override
    protected String getType(String variableName)
    {
        throw new UnsupportedOperationException();
    }

}
