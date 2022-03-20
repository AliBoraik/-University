package Exercises_in_loop;

public class E14 {
    public static void main(String[] args) {
        int n=10;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (i==1||i==n) {
                    System.out.print("*");
                    continue;
                }
                if (j==1||j==n)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
