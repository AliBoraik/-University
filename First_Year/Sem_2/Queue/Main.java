package Queue;

public class Main {
    public static void main(String[] args) {
        int n = 100000;
        long c1 = System.nanoTime();
        Task1.find235numbers(n);
        long c2 = System.nanoTime();
        Task2.find235numbersWithQueue(n);
        long c3 = System.nanoTime();
        System.out.println();
        System.out.println(c2 - c1);
        System.out.println(c3 - c2);
    }

}
