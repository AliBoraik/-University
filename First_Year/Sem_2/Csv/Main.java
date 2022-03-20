package Csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader("src/Csv/file.csv"));
        List<User> users=new ArrayList<>();

        String[] nextLine;
        reader.readNext();
        while ((nextLine=reader.readNext())!=null){
            users.add(new User(nextLine[5],Integer.parseInt(nextLine[11])));
        }
        int males=0;
        int females=0;
        int brand=0;
        int allUsers=0;
        long average=0;
        for (User user : users) {
            allUsers++;
            String gender = user.getGender();
            int fav_number = user.getFav_number();
            if (gender.equals("male")) {
                average += fav_number;
                males++;
            } else {
                if (gender.equals("female")) {
                    average += fav_number;
                    females++;
                } else
                    brand++;
            }
        }
        System.out.println("Males= "+males+"\n"+"Females= "+females+"\n"
                          +"brand= "+brand+"\n"+"Average= "+(average/allUsers));
    }
}
