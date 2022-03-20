package Exercises_Arrays_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the 5 numbers please : ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int te=input.nextInt();
            if (!numbers.contains(te))
                numbers.add(input.nextInt());
        }
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
