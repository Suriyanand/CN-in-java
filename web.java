import java.io.*;
import java.net.*;

class MyDownload {
    public void download() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the URL : ");
            String webpage = br.readLine();
            URL url = new URL(webpage);
            System.out.print("Enter filename to store : ");
            String myPage = br.readLine();
            try (InputStream in = url.openStream();
                 FileOutputStream fos = new FileOutputStream(new File(myPage))) {
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                System.out.println("Download complete. File saved as: " + new File(myPage).getAbsolutePath());
            }
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
    }
}

public class web {
    public static void main(String[] args) throws IOException {
        MyDownload myDownload = new MyDownload();
        myDownload.download();
        System.out.println("View the file");
    }
}
