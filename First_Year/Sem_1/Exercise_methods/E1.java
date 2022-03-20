package Exercise_methods;

import java.util.Scanner;

public class E1 {
    public static String Name(){
        System.out.print("Inter the your name : ");
        return new Scanner(System.in).nextLine();
    }
    public static int number() {
        System.out.print("Inter the your number : ");
        return new Scanner(System.in).nextInt();
    }

    public static void main(String[] args) {
        System.out.println("Your name is "+ Name().toUpperCase()+" and your number is "+number());
    }
}
