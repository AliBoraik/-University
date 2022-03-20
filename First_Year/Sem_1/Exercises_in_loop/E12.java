package Exercises_in_loop;

import java.util.Scanner;

public class E12 {
    public static void main(String[] args) {
        Scanner N = new Scanner(System.in);
        System.out.print("Inter the number : ");
        int number = N.nextInt();
        for (int i = 1; i <=number ; i++) {
            for (int j =0; j <(number-i) ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <i*2-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
