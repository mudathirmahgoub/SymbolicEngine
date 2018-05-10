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
    public static boolean debug = false;
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

    public Result verify() throws IOException
    {
        program.execute(null, null);

        Result result = new Result();
        result.isValid = Answer.Yes;
        for (Function function: program.functions)
        {
            for (Assertion assertion :function.assertions)
            {
                Answer areAllFormulasValid = Answer.Yes;
                for(AssertionFormula assertionFormula : assertion.assertionFormulas)
                {
                    verifyFormula(function, assertionFormula);
                    if(assertionFormula.isValid == Answer.No)
                    {
                        areAllFormulasValid = Answer.No;
                    }
                    else if(assertionFormula.isValid == Answer.Unknown &&
                            areAllFormulasValid == Answer.Yes)
                    {
                        areAllFormulasValid = Answer.Unknown;
                    }
                }

                if(areAllFormulasValid == Answer.No)
                {
                    result.isValid = Answer.No;
                }
                else if(areAllFormulasValid == Answer.Unknown &&
                        result.isValid == Answer.Yes)
                {
                    result.isValid = Answer.Unknown;
                }
            }
            result.assertions.addAll(function.assertions);
        }
        return result;
    }

    private void verifyFormula(Function function, AssertionFormula assertionFormula)
            throws IOException
    {
        String smtCommand = declareVariables();
        smtCommand += assertionFormula.formula + "\n(check-sat)";

        if(debug)
        {
            System.out.println("\n******************************\n");
            System.out.println(smtCommand);
        }

        //ToDO: clear the previous formula
        SMTClient client = new SMTClient();
        try
        {
            client.connect();
            client.sendCommand(smtCommand);
            String smtResult = client.getOutput();
            if(smtResult.equals("unsat"))
            {
                assertionFormula.isValid = Answer.Yes;
                return;
            }
            else if(smtResult.equals("sat"))
            {
                assertionFormula.isValid = Answer.No;
                // get a model
                client.sendCommand("\n(get-model)");
                String modelString = client.getOutput();

                if(debug)
                {
                    System.out.println(modelString);
                }

                Map<String, String> model = getSmtModel(modelString);

                Map<String, String> counterExample = new HashMap<>();

                if(model.size() > 0)
                {
                    for (Map.Entry<String, String> entry :
                            function.startStates.get(0).symbolTable.entrySet())
                    {
                        String variableName = entry.getKey();
                        String symbolicValue = entry.getValue();
                        String value = model.get(symbolicValue);
                        counterExample.put(variableName, value);
                    }
                }
                assertionFormula.counterExample = counterExample;
            }
            else
            {
                if(debug)
                {
                    System.out.println(smtResult);
                }
                assertionFormula.isValid = Answer.Unknown;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw e;
        }
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
