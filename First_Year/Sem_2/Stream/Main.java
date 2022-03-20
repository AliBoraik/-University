package Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        create();
        copyFile(new File("src/Stream/file1.txt"),new File("src/Stream/file2.txt"));
    }

    private static void copyFile(File file, File file1) throws IOException {
        FileInputStream input=new FileInputStream(file);
        FileOutputStream output = new FileOutputStream(file1);
        int c;
        while ((c=input.read())!=-1){
            output.write(c);
        }
        input.close();
        output.close();

    }

    private static void create() throws IOException {
        String path="src/Stream/";
        File f=new File(path+"file1.txt");
        FileOutputStream input=new FileOutputStream(f);
        Random r=new Random();
        for (int i = 0; i <20 ; i++) {
            int random=r.nextInt(128);
            input.write(random);
        }
        input.close();
    }
}
