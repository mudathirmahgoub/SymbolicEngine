package parser.syntaxtree;

public class Function extends CNode
{
    public String type;
    public String name;
    public Block block;
    public Function(String type, String name, Block block)
    {
        this.type = type;
        this.name = name;
        this.block = block;
    }
}
