package symbolicengine;

import java.util.HashMap;
import java.util.Map;

public class AssertionFormula
{
    public String formula;
    public Answer isValid;
    public Map<String, String> counterExample = new HashMap<>();
    public AssertionFormula(String formula)
    {
        this.formula = formula;
    }

    @Override
    public String toString()
    {
        String string = "AssertionFormula: " + formula + "\n" + "Answer: " + isValid.toString();
        if(counterExample.size() > 0)
        {
            string += "\nCounter example: " + counterExample;
        }
        return string;
    }
}
