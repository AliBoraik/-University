package Exercise_02;

import java.util.Scanner;

public class if_statement {


    public static void main(String[] args) {
        System.out.print("Inter the  numbers :");
        Scanner input = new Scanner(System.in);
        double n1= input.nextDouble();
        char op = input.next().charAt(0);
        double n2 = input.nextDouble();

        if ( op == '+' )
            System.out.println((int)(n1 + n2));
        else if ( op == '-' )
            System.out.println("the solution = " + (int)(n1 - n2));
        else
            System.out.println("   =");
    }
}