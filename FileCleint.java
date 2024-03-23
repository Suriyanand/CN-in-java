import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);
             InputStream is = socket.getInputStream();
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e:\\Bookmarks1.html"))) {

            byte[] contents = new byte[10000];
            int bytesRead;
            while ((bytesRead = is.read(contents)) != -1) {
                bos.write(contents, 0, bytesRead);
            }
            System.out.println("File saved successfully!");
        }
    }
}

