import org.apache.commons.cli.*;
import symbolicengine.Result;
import symbolicengine.SymbolicEngine;

import java.io.File;

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
                Result result = symbolicEngine.check();

                System.out.println(result);

                if(command.hasOption("o"))
                {
                    throw new UnsupportedOperationException();
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
