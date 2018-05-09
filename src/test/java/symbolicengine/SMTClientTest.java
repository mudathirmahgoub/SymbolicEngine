package symbolicengine;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SMTClientTest {

    @Test
    void connect() throws IOException
    {
        SMTClient client = new SMTClient();
        client.connect();
    }

    @Test
    void sendCommand() throws IOException
    {
        SMTClient client = new SMTClient();
        client.connect();
        client.sendCommand("(echo \"starting Z3...\")");
    }

    @Test
    void getOutput() throws IOException
    {
        SMTClient client = new SMTClient();
        client.connect();
        client.sendCommand("(echo \"starting Z3...\")");
        String output = client.getOutput();
        assertEquals("starting Z3...", output);
    }

    @Test
    void disconnect() throws IOException {
        SMTClient client = new SMTClient();
        client.connect();
        client.sendCommand("(echo \"starting Z3...\")");
        client.disconnect();
    }

    @Test
    void simple() throws IOException
    {
        SMTClient client = new SMTClient();
        client.connect();
        client.sendCommand("(assert true)");
        client.sendCommand("(verify-sat)");
        String output = client.getOutput();
        assertEquals("sat", output);
    }
}