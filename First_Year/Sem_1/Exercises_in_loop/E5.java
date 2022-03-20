package Exercises_in_loop;

import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("inter one positive number : ");
        int pn = input.nextInt();
        while (pn <= 0) {
            System.out.print(pn + " is not a positive number try aging : ");
            pn = input.nextInt();
        }
        if (pn%2!=1)
            System.out.print(pn+" is not a prime number");
        else
            System.out.print(pn+" is a prime number");
    }
}