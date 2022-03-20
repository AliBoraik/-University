package Files;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Files {


    public static void main(String[] args) {
        File myFile = new File("C:\\Users\\Ali\\Desktop\\New folder");
        if (myFile.exists()) {
            System.out.println("Y");
        } else
            System.out.println("N");
        for (String A : Objects.requireNonNull(myFile.list())) {
            System.out.println(A);
        }
        System.out.println("method");
        txt();
    }

    public static void txt() {
        String filename="src/main/java/Files/text.txt";
        File file = new File(filename);
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // anther way
        System.out.println("anther way");
        try (FileReader fileReader = new FileReader("src/main/java/Files/text.txt")) {
            int b;
            while ((b = fileReader.read()) != -1) {
                System.out.print((char) b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // for write
        try{
            FileWriter fileWriter=new FileWriter("src/main/java/Files/text2.txt");
            fileWriter.write("Ali the best one in the world\n");
            fileWriter.write("hello world i am Ali\n");
            fileWriter.append("A");
            fileWriter.close();
        } catch (IOException ignored) {
        }
        try{
            String image="C:\\Users\\Ali\\Desktop\\New folder\\website.jpg";
            String newImage="src/main/java/Files/image2.jpg";
            FileInputStream fr= new FileInputStream(image);
            FileOutputStream fw= new FileOutputStream(newImage);
            int n;
            while ((n= fr.read())!=-1){
                fw.write(n);
            }
            fr.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}