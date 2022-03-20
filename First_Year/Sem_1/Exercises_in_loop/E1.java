package Exercises_in_loop;

public class E1 {
    public static void main(String[] args) {
        //even numbers
        for (int i = 100; i >=1 ; i--) {
            if (i%2==0)
                System.out.print(i+" ");
        }
        System.out.println();
        //odd numbers
        for (int i = 99; i >=1 ; i-=2) {
                System.out.print(i+" ");
        }
    }
}
