package parser.syntaxtree;

import symbolicengine.StatePath;

public abstract class Expression extends CNode
{

    public abstract boolean isBoolean();
    public abstract String evaluate(StatePath statePath);
}
