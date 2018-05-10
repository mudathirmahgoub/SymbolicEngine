package parser.syntaxtree;

import symbolicengine.StatePath;

import java.util.List;

public class Variable extends Expression
{
    public String name;

    public Variable( String name)
    {
        this.name = name;
    }

    @Override
    public boolean isBoolean()
    {
        String type = parent.getType(this.name);
        return type.equals("bool");
    }

    @Override
    public String evaluate(StatePath statePath)
    {
        // get the current symbolic of this variable
        String value = statePath.symbolTable.get(this.name);
        return value;
    }

    @Override
    protected String getType(String variableName)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
    }
}
