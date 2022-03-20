package Exercises_in_loop;

import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Inter the number : ");
        int n= s.nextInt();
        int n1=1;
        int n2=1;
        int sum;
        for (int i = 1; i <=n-2 ; i++) {
            sum=n1+n2;
            n1=n2;
            n2=sum;
        }
        System.out.println("The number is = "+n2);

    }
}
