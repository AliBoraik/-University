package Thread;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public class DownloadWithThread extends Thread {
    List<String> list;
    int filename;
    String path="src/Thread";
    String extension;

    public DownloadWithThread(List<String> list,int filename,String extension) {
        this.list=list;
        this.filename=filename;
        this.extension=extension;
    }


    @Override
    public void run() {
        for (String s:list) {
            try {
                BufferedInputStream is = new BufferedInputStream((new URL(s).openStream()));
                String name= path+filename + "." + extension;
                FileOutputStream fos = new FileOutputStream(name);
                int x = is.read();
                while (x != -1) {
                    fos.write(is.read());
                    x = is.read();
                }
                fos.close();

            } catch (IOException e) {
               continue;
            }
            filename++;
        }
    }
}
