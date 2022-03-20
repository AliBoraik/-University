package Exercise_01;

import java.util.Scanner;

public class Exercise_01 {
    public static void main(String[] args) {
        System.out.print("inter the numbers : ");
        Scanner s = new Scanner(System.in);
        double n1 = s.nextDouble();
        char op = s.next().charAt(0);
        double n2 = s.nextDouble();
        if (op == '*')
            System.out.println(n1 * n2);
        else if (op == '+')
            System.out.println(n1+n2);

    }
}