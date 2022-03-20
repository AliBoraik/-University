package Exercise_Arreays;

import java.util.Arrays;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inter the number between 1 and 20 : ");
        int number = input.nextInt();
        fill(number);
    }

    public static void fill(int number) {
        Scanner input = new Scanner(System.in);
        while (!(number > 1 && number < 20)) {
            System.out.print("Inter the number/point between 1 and 20 : ");
            number = input.nextInt();
        }
        int[] numbers = new int[number];
        Arrays.fill(numbers, number);
        System.out.println(Arrays.toString(numbers));

    }
}
