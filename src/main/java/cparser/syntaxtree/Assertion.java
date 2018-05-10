package cparser.syntaxtree;

import symbolicengine.StatePath;

import java.util.ArrayList;
import java.util.List;

public class Assertion extends Statement
{
    public Expression expression;
    public List<String> assertionFormulas = new ArrayList<>();

    public Assertion(Expression expression)
    {
        this.expression = expression;
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
        // the assertion statement add a formula to the path
        this.endStates = StatePath.copy(this.startStates);

        this.expression.execute(function, this);

        boolean isBooleanExpression = expression.isBoolean();

        for (StatePath statePath : this.endStates)
        {
            String expressionValue = this.expression.evaluate(statePath);
            String formula ;
            if(isBooleanExpression)
            {
                formula= statePath.constraint + "\n(assert (not "  +
                        expressionValue + "))";
            }
            else
            {
                formula= statePath.constraint + "\n(assert (<= "  +
                        expressionValue + " 0 ))";
            }
            this.assertionFormulas.add(formula);
        }
        // add assertion to the assertions list of the current function
        function.assertions.add(this);
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }

}
