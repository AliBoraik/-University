package Exercises_in_loop;

import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("inter the numbers : ");
        int n = input.nextInt();
        int max = n;
        int min = n;
//        while (true) {
//            System.out.print("inter the numbers : ");
//            n= input.nextInt();
//            if (n < 0)
//                break;
//            if (n > max)
//                max = n;
//            if (n < min)
//                min = n;
//        }


        //anther solution
        while (true) {
            System.out.print("Inter the number : ");
            n= input.nextInt();
            max= n>max ? n:max;
            min=n<min? n:min;
            if (n<0)
                break;
        }
        System.out.println("the max is " + max + " the min is " + min);
        System.out.println();
    }
}









//        if (n >= m) {
//           m=n;
//        }
//        else if (n<=i){
//            i=n;
//        }
//        System.out.println("Max = "+m+" Min = "+i);