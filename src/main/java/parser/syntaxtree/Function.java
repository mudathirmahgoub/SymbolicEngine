package parser.syntaxtree;

import symbolicengine.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Function extends CNode
{
    public String type;

    public String name;

    public Block block;

    public Arguments arguments;

    public List<Assertion> assertions = new ArrayList<>();

    public Function(String type, String name, Arguments arguments, Block block)
    {
        this.type = type;
        this.name = name;
        this.arguments = arguments;
        this.block = block;
    }

    @Override
    protected String getType(String variableName)
    {
        if(arguments.arguments.containsKey(variableName))
        {
            return arguments.arguments.get(variableName);
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
        State state  = new State();
        for (Map.Entry<String, String> entry: function.arguments.arguments.entrySet())
        {
            String variableName = entry.getKey();
            String symbolicValue = CNode.getSymbolValue();
            state.symbolTable.put(variableName, symbolicValue);
        }
        this.states.add(state);

        block.execute(this, this);
    }

    @Override
    protected List<String> getFormulas()
    {
        throw new UnsupportedOperationException();
    }
}
