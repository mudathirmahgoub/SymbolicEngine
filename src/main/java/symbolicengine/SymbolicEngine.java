package symbolicengine;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.Visitor;
import parser.antlr.CLexer;
import parser.antlr.CParser;
import parser.syntaxtree.Assertion;
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

    public Result verify()
    {
        program.execute(null);

        String smtLib = "";

        for (Function function: program.functions)
        {
            for (Assertion assertion :function.assertions)
            {
                List<String> formulas = assertion.getFormulas();
                smtLib = String.join("\n", formulas);
            }
        }

        smtLib += "\n(check-sat)";

        SMTClient client = new SMTClient();
        try
        {
            client.connect();
            client.sendCommand(smtLib);
            String isSatisfiable = client.getOutput();
            if(isSatisfiable.equals("unsat"))
            {
                Result result = new Result();
                result.answer = Answer.Yes;
                return result;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException();
    }
}
