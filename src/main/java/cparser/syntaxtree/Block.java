package cparser.syntaxtree;

import java.util.ArrayList;
import java.util.List;

public class Block extends Statement
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
                Statement statement =  statements.get(i);
                statement.startStates = this.startStates;
                statement.execute(function, this);
            }
            else
            {
                Statement statement =  statements.get(i);
                statement.startStates = statements.get(i-1).endStates;
                statement.execute(function, statements.get(i-1));
            }
        }
        // copy the end states for the last statement
        if(statements.size() > 0)
        {
            this.endStates = statements.get(statements.size() - 1).endStates;
        }
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Block: ");
        for (Statement statement: this.statements)
        {
            builder.append(statement.toString() + "\n");
        }
        return builder.toString();
    }
}
