package parser.syntaxtree;

import java.util.ArrayList;
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
    public void execute(Function function)
    {
        function.assertions.add(this);
    }



    public List<String> getFormulas()
    {
        // the expression should not be empty
        String assertionFormula = expression.getFormulas().get(0);

        //ToDo:  if the assertion is the first statement in a block

//        List<String> parentFormulas = parent.getFormulas();
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
