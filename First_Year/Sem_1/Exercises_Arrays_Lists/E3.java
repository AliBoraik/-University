package Exercises_Arrays_Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = getChose();
        while (n != 4) {
            if (n == 1) {
                System.out.print("Enter the number = ");
                arr.add(input.nextInt());
                n = getChose();
            } else if (n == 2) {
                System.out.print("Enter the number = ");
                arr.remove(Integer.valueOf(input.nextInt()));
                n= getChose();
            } else if (n == 3) {
                System.out.println(arr);
                n= getChose();
            }
        }
    }
    public static int getChose(){
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Your choice : ");
            n = input.nextInt();
        } while (n <= 0 || n >= 5);
        return n;
    }
}
