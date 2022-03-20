package Exercises_in_loop;

import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {
        System.out.print("Inter the text : ");
        Scanner s = new Scanner(System.in);
        String A=s.nextLine();
        for (int i =A.length()-1; i >=0 ; i--) {
            System.out.print(A.toUpperCase().charAt(i));

        }
    }
}
