package parser.syntaxtree;

import java.util.ArrayList;
import java.util.List;

public class Block extends CNode
{
    public List<Statement> statements = new ArrayList<>();

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;

        for(int i = 0 ; i < statements.size(); i++)
        {
            if(i == 0)
            {
                statements.get(i).execute(function, this);
            }
            else
            {
                statements.get(i).execute(function, statements.get(i-1));
            }
        }
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }

    @Override
    protected List<String> getFormulas()
    {
        List<String> formulas = new ArrayList<>();
        for (Statement statement : statements)
        {
            List<String> statementFormulas =  statement.getFormulas();
            formulas.addAll(statementFormulas);
        }
        return formulas;
    }
}
