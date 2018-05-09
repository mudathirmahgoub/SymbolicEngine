package parser.syntaxtree;

import symbolicengine.Formula;
import symbolicengine.State;

import java.util.ArrayList;
import java.util.List;

abstract public class CNode
{
    public List<State> endStates = new ArrayList<>();
    public CNode parent;
    public abstract void execute(Function function);
    public static int symbolicIndex = 0;

    public static String getSymbolValue()
    {
        symbolicIndex ++;
        return "_x" + symbolicIndex;
    }

    protected abstract List<String> getFormulas();
}
