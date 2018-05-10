package symbolicengine;

import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class SMTClient
{
    private Process process;
    private Scanner scanner;
    boolean firstRead = true;

    public void connect() throws IOException
    {

        String command = "src/resources/z3.exe -in";

        Runtime runtime = Runtime.getRuntime();
        process = runtime.exec(command);
        scanner = new Scanner(process.getInputStream());
    }

    public void sendCommand(String command) throws IOException
    {
        byte [] commandBytes = command.getBytes();
        process.getOutputStream().write(commandBytes);
        process.getOutputStream().flush();

    }

    public String getOutput() throws IOException
    {
        this.sendCommand("(echo \" \")");
        String line = "";
        if(firstRead)
        {
            line = scanner.nextLine();
            firstRead = false;
        }
        else
        {
            this.sendCommand("(echo \" \")");
            this.sendCommand("(echo \" \")");
            String output = "";
            line = scanner.nextLine();
            while(scanner.hasNextLine())
            {
                line = scanner.nextLine();
                if(line.equals(" "))
                {
                    return output;
                }
                output += line;
            }
        }
        return line;
    }


    public void disconnect()
    {
        process.destroyForcibly();
    }
}
