import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class JavaDownloader {
    public static void main(String[] args) throws Exception {
      if (args.length != 2) {
        System.out.println("Usage: java JavaDownloader <URL> <output path>");
        return;
      }
      String url = args[0];
      String outPath = args[1];
      downloadFile(url, outPath);
    }
    
    /**
     * Downloads file from the given url and saves it to the given output path
     * @param url   url of file to be downloaded
     * @param outPath output path of downloaded file
     */
    public static void downloadFile(String url, String outPath) {
        try {
          URLConnection yc = (new URL(url)).openConnection();
            BufferedInputStream in = new BufferedInputStream (yc.getInputStream());
            
            File outfile = new File(outPath);
            if (!outfile.exists()) { outfile.createNewFile(); }
            FileOutputStream fos = new FileOutputStream(outfile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int inputChar;
            while ((inputChar = in.read()) != -1) { bos.write(inputChar); }
            in.close();
            bos.close();        
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}