package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // working
        find235numbersWithQueue(n);
    }

    public static void find235numbersWithQueue(int n) {

        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();

        q2.offer(2);
        q3.offer(3);
        q5.offer(5);

        int num = 1;

        do {
            int oldNum = num;
            num = minOfQueuesHeads(q2, q3, q5);
            if (oldNum != num) {
                //System.out.print(num + " ");
                q2.offer(2 * num);
                q3.offer(3 * num);
                q5.offer(5 * num);
            }
        }
        while (num < n);

    }

    private static int minOfQueuesHeads(Queue<Integer> q2,
                                        Queue<Integer> q3,
                                        Queue<Integer> q5) {
        // find minimum
        // don't forget to remove minimum
        int a2 = q2.peek();
        int a3 = q3.peek();
        int a5 = q5.peek();
        int whois ;
        int min;
        if (a2 < a3) {
            whois = 2;
            min = a2;
        } else {
            whois = 3;
            min = a3;
        }
        if (a5 < min) {
            whois = 5;
            min = a5;
        }
        switch (whois) {
            case 2: q2.remove(); break;
            case 3: q3.remove(); break;
            case 5: q5.remove(); break;
        }
        return min;
    }
}
