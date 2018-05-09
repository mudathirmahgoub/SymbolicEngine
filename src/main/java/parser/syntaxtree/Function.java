package parser.syntaxtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Function extends CNode
{
    public String type;

    public String name;

    public Block block;

    public List<Assertion> assertions = new ArrayList<>();

    public Function(String type, String name, Block block)
    {
        this.type = type;
        this.name = name;
        this.block = block;
    }

    @Override
    public void execute(Function function)
    {
        //ToDo: assign a new symbolic value for each argument

        block.execute(this);
    }

    @Override
    protected List<String> getFormulas()
    {
        throw new UnsupportedOperationException();
    }
}
