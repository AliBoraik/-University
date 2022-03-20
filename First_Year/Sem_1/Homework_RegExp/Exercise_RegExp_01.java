package Exercises.Homework_RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_RegExp_01 {
    public static void main(String[] args) {
        String data = "02/20/1978 20:00";
        String Format = "(\\d{2})/(\\d{2})/(\\d{4})\\s(\\d{2}):(\\d{2})";
        Pattern pattern = Pattern.compile(Format, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.toString());
            int day = Integer.parseInt(matcher.group(2));
            int month = Integer.parseInt(matcher.group(1));
            int year = Integer.parseInt(matcher.group(3));
            int hours = Integer.parseInt(matcher.group(4));
            int mint = Integer.parseInt(matcher.group(5));
            if    (year > 1234 && year < 1978 ||
                    year == 1978 && month <= 2 && day <= 27 && hours <= 21 && mint <= 35 ||
                    year == 1234 && month >= 3 && day >= 6  && hours >= 11 && mint >= 59)
                    System.out.println("даты и времени в промежутке с 6 марта 1237 12:00 по 27 февраля 1978 21:35");

            else System.out.println("не в промежутке с 6 марта 1237 12:00 по 27 февраля 1978 21:35");

        }
    }
}