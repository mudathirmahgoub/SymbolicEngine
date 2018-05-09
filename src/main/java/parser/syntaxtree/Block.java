package parser.syntaxtree;

import java.util.ArrayList;
import java.util.List;

public class Block extends CNode
{
    public List<Statement> statements = new ArrayList<>();

    @Override
    public void execute(Function function)
    {
        for (Statement statement : statements)
        {
            statement.execute(function);
        }
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
