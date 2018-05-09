package parser.syntaxtree;

import java.util.Arrays;
import java.util.List;

public class Assertion extends Statement
{
    public Expression expression;
    public Assertion(Expression expression)
    {
        this.expression = expression;
    }

    @Override
    public void execute(Function function, CNode parent)
    {
        this.parent = parent;
        this.expression.execute(function, this);
        function.assertions.add(this);
    }

    @Override
    protected String getType(String variableName)
    {
        return parent.getType(variableName);
    }

    public List<String> evaluate()
    {
        String assertionFormula = "";
        // the expression should not be empty
        if(expression.isBoolean())
        {
            assertionFormula = expression.evaluate();
        }
        else
        {
            assertionFormula = "(> " + expression.evaluate() + " 0 )";
        }

        //ToDo:  if the assertion is the first statement in a block

//        List<String> parentFormulas = parent.evaluate();
//
//        if(parentFormulas.size() > 0)
//        {
//            List<String> assertionFormulas = new ArrayList<>();
//
//            for (String formula : parentFormulas) {
//                String newFormula = "assert (not (and " +
//                        assertionFormula + " " + formula + "))";
//                assertionFormulas.add(newFormula);
//            }
//            return assertionFormulas;
//        }
//        else
        {
            return Arrays.asList("(assert (not " + assertionFormula + "))");
        }
    }
}
