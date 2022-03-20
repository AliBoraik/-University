package Exercise_methods;

import java.util.Scanner;

public class E2 {
    //find the primer numbers between tow numbers/
    public static void main(String[] args) {
        System.out.print("inter the numbers : ");
        Scanner inout =new Scanner(System.in);
        prime(inout.nextInt(),inout.nextInt());
    }
    public static void prime(int N1,int N2){
        for (int i = N1; i <=N2 ; i++) {
            if (i%2==1)
                System.out.print(i+" ");
        }
    }
}
