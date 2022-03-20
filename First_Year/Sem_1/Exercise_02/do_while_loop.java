package Exercise_02;

import java.util.Scanner;

public class do_while_loop {
    public static void main(String[] args) {
        System.out.print("Inter the number between 1 and 20 : ");
        Scanner s = new Scanner(System.in);
        int n;
        do {
            System.out.print("Inter the number between 1 and 20 : ");
           n= s.nextInt();
        } while (n < 1 || n > 20);
    }
}
