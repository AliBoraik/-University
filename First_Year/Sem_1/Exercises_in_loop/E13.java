package Exercises_in_loop;

import java.util.Scanner;

public class E13 {
    public static void main(String[] args) {
        Scanner N = new Scanner(System.in);
        System.out.print("Inter the number : ");
        int number = N.nextInt();
        for (int i = 1; i <= number; i++) {

            for (int j = 1; j <= (number - i); j++)
                System.out.print(" ");

            for (int j = 1; j <= 2*i - 1; j++)
                if (i == number)
                    System.out.print("*");
                else
                    if (j==1 || j==2*i-1)
                        System.out.print("*");
                    else
                        System.out.print(" ");

            System.out.println();
        }
    }
}