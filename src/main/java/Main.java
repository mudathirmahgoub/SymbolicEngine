import org.apache.commons.cli.*;
import symbolicengine.Result;
import symbolicengine.SymbolicEngine;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;

public class Main
{

    public static void main(String[] args)
    {
        Options options = new Options();

        options.addOption(Option.builder("i").longOpt("input").hasArg().required().build());

        options.addOption(Option.builder("o").longOpt("output").hasArg().build());

        CommandLineParser commandLineParser = new DefaultParser();
        try
        {
            CommandLine command = commandLineParser.parse(options, args);
            if (command.hasOption("i"))
            {
                String inputFile  = command.getOptionValue("i");
                File file = new File(inputFile);
                SymbolicEngine symbolicEngine = new SymbolicEngine(file);
                Result result = symbolicEngine.verify();

                System.out.println(result);

                if(command.hasOption("o"))
                {
                    File outputFile = new File(command.getOptionValue("o"));
                    Formatter formatter = new Formatter(outputFile);
                    formatter.format("%s", result.toString());
                    formatter.close();
                }
            }
            else
            {
                throw new ParseException("");
            }
        }
        catch (ParseException exception)
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "java -jar SymbolicEngine.jar ", options );
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
