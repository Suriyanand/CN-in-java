import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ssock = new ServerSocket(5000);
             Socket socket = ssock.accept();
             BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e:\\Bookmarks.html"));
             OutputStream os = socket.getOutputStream()) {

            byte[] contents = new byte[10000];
            int bytesRead;
            while ((bytesRead = bis.read(contents)) != -1) {
                os.write(contents, 0, bytesRead);
            }
            System.out.println("File sent successfully!");
        }
    }
}
