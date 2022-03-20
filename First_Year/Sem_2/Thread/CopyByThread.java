package Thread;

import java.io.*;

public class CopyByThread extends Thread {
   private String path;
   private String nameFile;
    public CopyByThread(String from,String nameFile){
     this.path=from;
     this.nameFile=nameFile;
    }
    @Override
    public void run() {
     try {
      BufferedReader read=new BufferedReader(new FileReader(path));
      BufferedWriter writer=new BufferedWriter(new FileWriter(nameFile));
      String line;
      while ((line=read.readLine())!=null){
       writer.write(line);
       writer.newLine();
      }
      read.close();
      writer.close();
     } catch (IOException e) {
      e.printStackTrace();
     }
    }
}
