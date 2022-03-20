package Exercises_in_loop;

import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inter twe numbers : ");
        int N = input.nextInt();
        int N2=N%10;
        int N1=(N/10)%10;
        int N3=(N/10);
        System.out.println(N2);
    }
}
