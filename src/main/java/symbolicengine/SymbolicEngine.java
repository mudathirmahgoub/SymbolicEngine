package symbolicengine;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import cparser.CVisitor;
import cparser.antlr.CLexer;
import cparser.antlr.CParser;
import cparser.syntaxtree.Assertion;
import cparser.syntaxtree.CNode;
import cparser.syntaxtree.Function;
import cparser.syntaxtree.Program;
import smtparser.SmtVisitor;
import smtparser.antlr.SmtLexer;
import smtparser.antlr.SmtParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class SymbolicEngine
{
    private Program program;
    public SymbolicEngine(File file) throws IOException
    {
        CharStream charStream = CharStreams.fromFileName(file.getAbsolutePath(),
                Charset.forName("UTF-8"));
        parseProgram(charStream);
    }

    public SymbolicEngine(String program)
    {
        CharStream charStream = CharStreams.fromString(program);
        parseProgram(charStream);
    }

    private void parseProgram(CharStream charStream)
    {
        CLexer lexer = new CLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CParser parser = new CParser(tokenStream);

        ParseTree tree =  parser.program();
        CVisitor CVisitor = new CVisitor();
        this.program = (Program) CVisitor.visit(tree);
    }

    public Result verify() throws IOException {
        program.execute(null, null);

        for (Function function: program.functions)
        {
            for (Assertion assertion :function.assertions)
            {
                for(String formula : assertion.assertionFormulas)
                {
                    String smtCommand = declareVariables();
                    smtCommand += formula + "\n(check-sat)";

                    //ToDO: clear the previous formula
                    SMTClient client = new SMTClient();
                    try
                    {
                        client.connect();
                        client.sendCommand(smtCommand);
                        String smtResult = client.getOutput();
                        if(smtResult.equals("unsat"))
                        {
                            continue;
                        }
                        else if(smtResult.equals("sat"))
                        {
                            // get a model
                            client.sendCommand("\n(get-model)");
                            String modelString = client.getOutput();

                            System.out.println(modelString);

                            Result result = new Result(Answer.No);

                            Map<String, String>  model = getSmtModel(modelString);

                            Map<String, String> counterExample = new HashMap<>();

                            for (Map.Entry<String, String> entry :
                                    function.startStates.get(0).symbolTable.entrySet())
                            {
                                String variableName = entry.getKey();
                                String symbolicValue = entry.getValue();
                                String value = model.get(symbolicValue);
                                counterExample.put(variableName, value);
                            }
                            result.counterExample = counterExample;
                            return result;
                        }
                        else
                        {
                            System.out.println(smtCommand);
                            System.out.println(smtResult);
                            return new Result(Answer.Unknown);
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }

        }
        return new Result(Answer.Yes);
    }

    private Map<String, String> getSmtModel(String model)
    {
        CharStream charStream = CharStreams.fromString(model);
        SmtLexer lexer = new SmtLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SmtParser parser = new SmtParser(tokenStream);

        ParseTree tree =  parser.model();
        SmtVisitor SmtVisitor = new SmtVisitor();

        return SmtVisitor.visit(tree);
    }

    private String declareVariables()
    {
        String declarations = "";
        for (String symbolicValue : CNode.symbolicValues)
        {
            declarations +=  "(declare-fun " + symbolicValue + "() Int)\n" ;
        }
        return  declarations;
    }
}
