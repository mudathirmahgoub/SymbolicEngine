package  smtparser;

import smtparser.antlr.SmtBaseVisitor;
import smtparser.antlr.SmtParser;

import java.util.HashMap;
import java.util.Map;

public class SmtVisitor extends SmtBaseVisitor<Map<String, String>>
{
    private Map<String, String> model = new HashMap<>();

    @Override
    public Map<String, String> visitModel(SmtParser.ModelContext ctx)
    {
        for (SmtParser.DefinitionsContext context: ctx.definitions())
        {
            this.visitDefinitions(context);
        }
        return model;
    }

    @Override
    public Map<String, String> visitDefinitions(SmtParser.DefinitionsContext ctx)
    {
        String variable = ctx.variable().getText();
        SmtParser.ValueContext context = ctx.value();

        int value = Integer.parseInt(context.Integer().getText());
        if(context.children.size() > 1)
        {
            value = -value;
        }
        model.put(variable, "" + value);
        return model;
    }
}