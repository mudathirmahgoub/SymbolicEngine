package parser.syntaxtree;

import symbolicengine.StatePath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class CNode
{
    public List<StatePath> statePaths = new ArrayList<>();
    public CNode parent;
    public abstract void execute(Function function, CNode parent);
    public static int symbolicIndex = 0;

    public static String getSymbolValue()
    {
        symbolicIndex ++;
        return "_x" + symbolicIndex;
    }

    protected abstract String getType(String variableName);
}
