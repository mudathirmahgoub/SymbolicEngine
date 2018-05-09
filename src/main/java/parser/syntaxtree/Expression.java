package parser.syntaxtree;

public abstract class Expression extends CNode
{

    public abstract boolean isBoolean();
    public abstract String evaluate();
}
