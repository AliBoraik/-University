package Exercises_in_loop;

import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Inter the text : ");
        String A=s.nextLine();
        for (int i = 0; i <A.length()-1 ; i++) {
            System.out.print((A.toUpperCase().charAt(i))+" ");
        }
    }
}
