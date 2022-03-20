package Exercise_01;

import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inter your full name : ");
        String name = input.nextLine();
        System.out.print("Inter the your number phone : ");
        long number = input.nextLong();
        System.out.println("Your Name is : " + name.toUpperCase());
        System.out.println("And your number is : " + number);
    }
}
