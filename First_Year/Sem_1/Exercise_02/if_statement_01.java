package Exercise_02;

import java.util.Scanner;

public class if_statement_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the numbers : ");
        int N = input.nextInt();
        if (!(N > 999 && N < 10000)) {
            System.out.println("is not a forth digit number");
        } else {
            int n4 = N % 10;
            int n3 = (N / 10) % 10;
            int n2 = (N / 100) % 10;
            int n1 = (N / 1000) % 10;
            if ((n1 + n2) == (n3 + n4))
                System.out.println("Lucky number ");
            else
                System.out.println("not a lucky number");
        }
    }
}
