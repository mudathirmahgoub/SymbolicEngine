package symbolicengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatePath
{
    public  Map<String, String> symbolTable = new HashMap<>();
    public String constraint;

    public StatePath() {}

    public StatePath(StatePath statePath)
    {
        for (Map.Entry<String, String> entry: statePath.symbolTable.entrySet())
        {
                symbolTable.put(entry.getKey(), entry.getValue());
        }
        constraint = statePath.constraint;
    }

    public static List<StatePath> copy(List<StatePath> statePaths)
    {
        List<StatePath> paths = new ArrayList<>();
        for (StatePath statePath : statePaths)
        {
            StatePath newStatePath = new StatePath(statePath);
            paths.add(newStatePath);
        }
        return paths;
    }
}
