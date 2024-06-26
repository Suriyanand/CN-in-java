import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String args[]) throws Exception {
        try (ServerSocket ss = new ServerSocket(2000);
             Socket sk = ss.accept();
             BufferedReader cin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
             PrintStream cout = new PrintStream(sk.getOutputStream());
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {

            String s;
            while (true) {
                s = cin.readLine();
                if (s.equalsIgnoreCase("END")) {
                    cout.println("BYE");
                    break;
                }
                System.out.println("Client: " + s);
                System.out.print("Server: ");
                s = stdin.readLine();
                cout.println(s);
            }
        }
    }
}
