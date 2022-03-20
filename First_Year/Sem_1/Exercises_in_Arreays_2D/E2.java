package Exercises_in_Arreays_2D;

import java.util.Arrays;

public class E2 {
    public static void main(String[] args) {
        // mix fo the Row
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                arr[i][j] = (int) (Math.random()*50);
        }
        System.out.println(Arrays.deepToString(arr));
        int max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (max < arr[i][j])
                    max = arr[i][j];
            }
            System.out.println("sum of Row 1 = " + max);
            max = 0;
        }
        // anther solution
        System.out.println();
        for (int i = 0,h=1; i < 3; i++) {
            System.out.println("sum of Row "+h +" = "+ getMax(arr[i]));
            h++;
        }

    }

    private static int getMax(int[] ints) {
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, ints[i]);
        }
        return max;
    }
}
