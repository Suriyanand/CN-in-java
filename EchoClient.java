import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        String serverHostname = (args.length > 0) ? args[0] : "127.0.0.1";
        System.out.println("Attempting to connect to host " + serverHostname + " on port 10007.");
        try (Socket echoSocket = new Socket(serverHostname, 10007);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;
            System.out.print("input: ");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                if (userInput.equals("bye"))
                    break;
                System.out.println("echo: " + in.readLine());
                System.out.print("input: ");
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverHostname);
            System.exit(1);
        }
    }
}
