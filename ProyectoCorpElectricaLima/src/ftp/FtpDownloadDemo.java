package ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
 
public class FtpDownloadDemo {
	
    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        FileOutputStream fosi = null;
 
        try {
        	
        	client.connect("ftp.electrocornejo.com");
            client.login("electroc", "7AX_]~MMV;vX");
            
        	File originFile = new File("/tmp/FaceProv.log");
            File destinationFile = new File("c:\\file1.txt");
            if (!originFile.exists() || destinationFile.exists()) {
              return;
            }
            try {
              byte[] readData = new byte[1024];
              FileInputStream fis = new FileInputStream(originFile);
              fosi = new FileOutputStream(destinationFile);
              int i = fis.read(readData);

              while (i != -1) {
                fosi.write(readData, 0, i);
                i = fis.read(readData);
              }
              client.retrieveFile("/tmp/FaceProv.log", fosi);
              fis.close();
              fosi.close();
            } catch (IOException e) {
              System.out.println(e);
            }
            //client.connect("ftp.electrocornejo.com");
            //client.login("electroc", "7AX_]~MMV;vX");
 
            //
            // The remote filename to be downloaded.
            //
            //String filename = "FaceProv.log";
            //fos = new FileOutputStream(filename);
 
            //
            // Download file from FTP server
            //
            
            //client.deleteFile("/tmp/FaceProv.log");
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fosi != null) {
                    fosi.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
    }
}
