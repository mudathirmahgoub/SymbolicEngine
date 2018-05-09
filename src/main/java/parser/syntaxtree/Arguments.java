package parser.syntaxtree;

import java.util.ArrayList;
import java.util.List;

public class Arguments extends  CNode
{
    @Override
    public void execute(Function function)
    {
        // no action is required
        throw new UnsupportedOperationException();
    }

    @Override
    protected List<String> getFormulas() {
        return new ArrayList<>();
    }
}
