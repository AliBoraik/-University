package Exercise_02;

import java.util.Scanner;

public class while_loop {
    public static void main(String[] args) {
        System.out.print("Inter the number between 1 and 20 : ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n< 1 || n > 20) {
            System.out.print(n +" is not between 1 and 20 tray again : ");
            n= s.nextInt();
        }
        System.out.println(n+" is between 1 aad 20");
    }
}