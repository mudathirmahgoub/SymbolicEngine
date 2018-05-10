package parser.syntaxtree;

import symbolicengine.StatePath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class CNode
{
    public List<StatePath> startStates = new ArrayList<>();
    public List<StatePath> endStates = new ArrayList<>();
    public CNode parent;
    public abstract void execute(Function function, CNode parent);
    public static int symbolicIndex = 0;

    public static List<String> symbolicValues = new ArrayList<>();

    public static String getSymbolValue()
    {
        symbolicIndex ++;
        String symbolicValue =  "_x" + symbolicIndex;
        symbolicValues.add(symbolicValue);
        return symbolicValue;
    }

    protected abstract String getType(String variableName);
}
