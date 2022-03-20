package Queue;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // working
        find235numbers(n);

    }

    public static void find235numbers(int n) {
        for (int i = 2; i <= n; i++) {
            if (is235number(i)) {
                System.out.print(i + " ");
            }
        }
    }
    private static int divideWhileCan(int x, int d) {
        while (x % d == 0) {
            x = x / d;
        }
        return x;
    }
    private static boolean is235number(int x) {
        // check if x = 2^i * 3^j * 5^k
        // divide x on 2 while it is possible
        x = divideWhileCan(x, 2);
        // divide x on 3 while it is possible
        x = divideWhileCan(x, 3);
        // divide x on 5 while it is possible
        x = divideWhileCan(x, 5);
        return x == 1;
    }
}
