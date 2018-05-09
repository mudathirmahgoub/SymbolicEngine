package symbolicengine;

import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class SMTClient
{
    private Process process;
    private Scanner scanner;
    private Formatter formatter;

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
        this.sendCommand("assert(true)");
        String line = scanner.nextLine();
        return line;
    }


    public void disconnect()
    {
        process.destroyForcibly();
    }
}
