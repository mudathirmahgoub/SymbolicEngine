package symbolicengine;

import java.util.HashMap;
import java.util.Map;

public class Result
{
    public Answer isValid;
    public Map<String, String> counterExample = new HashMap<>();
    public Result(Answer answer)
    {
        this.isValid = answer;
    }

    @Override
    public String toString()
    {
        return isValid.toString() + "\n" + counterExample.toString();
    }
}
