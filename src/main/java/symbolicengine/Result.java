package symbolicengine;

import cparser.syntaxtree.Assertion;

import java.util.ArrayList;
import java.util.List;

public class Result
{
    public Answer isValid;
    public List<Assertion> assertions = new ArrayList<>();

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("------------------\n");
        builder.append("Overall Answer: " + isValid.toString() + "\n");

        for (Assertion assertion : assertions)
        {
            builder.append("------------------\n");
            builder.append(assertion.toString() + "\n");
            for (AssertionFormula formula: assertion.assertionFormulas)
            {
                builder.append(formula.toString()+"\n");
                builder.append("----------------------------\n");
            }
        }
        return  builder.toString();
    }
}
