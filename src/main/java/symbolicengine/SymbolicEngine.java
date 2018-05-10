package symbolicengine;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.Visitor;
import parser.antlr.CLexer;
import parser.antlr.CParser;
import parser.syntaxtree.Assertion;
import parser.syntaxtree.CNode;
import parser.syntaxtree.Function;
import parser.syntaxtree.Program;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

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
        Visitor visitor = new Visitor();
        this.program = (Program) visitor.visit(tree);
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
                            return new Result(Answer.No);
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
