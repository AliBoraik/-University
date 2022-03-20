package Exercises_in_loop;

import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {
        System.out.print("Inter the number : ");
        Scanner N = new Scanner(System.in);
        int number = N.nextInt();
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
