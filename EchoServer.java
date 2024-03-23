import java.io.*;
import java.net.*;

public class EchoServer {
    private final ServerSocket server;

    public EchoServer(int portnum) throws IOException {
        server = new ServerSocket(portnum);
    }

    public void serve() {
        try {
            while (true) {
                Socket client = server.accept();
                try (BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter w = new PrintWriter(client.getOutputStream(), true)) {
                    w.println("Welcome to the Java EchoServer. Type 'bye' to close.");
                    String line;
                    while ((line = r.readLine()) != null && !line.trim().equals("bye")) {
                        w.println("Got: " + line);
                        System.out.println(line);
                    }
                }
                client.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        EchoServer s = new EchoServer(10007);
        s.serve();
    }
}
