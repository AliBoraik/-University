package Exercises_in_loop;

public class E3 {
    public static void main(String[] args) {
        int N1 = 9, N2 = 2;
        for (int i = N2; i <= N1; i++) {
            System.out.print("," + i);
        }
        System.out.println();
        N1 = 2;
        N2 = 9;
        int sum = 0;
        for (int i = N1; i <= N2; i++) {
            sum += (i * i);
        }
        System.out.println(sum);
    }
}