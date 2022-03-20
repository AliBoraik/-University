package Exercises_in_loop;

import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        System.out.print("Inter the text : ");
        Scanner s = new Scanner(System.in);
        String All = s.nextLine();
        boolean typeString = true;
        for (int i = 0, j = All.length() - 1; i < All.length(); i++, j--) {
            if (All.charAt(i) == All.charAt(j)) {
                continue;
            }
            typeString = false;
            break;
        }
        System.out.println(typeString ? "palindrome String" : "not a palindrome String");
    }
}
