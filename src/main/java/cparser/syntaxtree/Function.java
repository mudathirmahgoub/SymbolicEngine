package cparser.syntaxtree;

import symbolicengine.StatePath;

import java.util.ArrayList;
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
        StatePath statePath = new StatePath();
        for (Map.Entry<String, String> entry: function.arguments.arguments.entrySet())
        {
            String variableName = entry.getKey();
            String symbolicValue = CNode.getNewSymbolicValue();
            statePath.symbolTable.put(variableName, symbolicValue);
        }
        statePath.constraint = "";
        this.startStates.add(statePath);

        block.execute(this, this);
    }
}
