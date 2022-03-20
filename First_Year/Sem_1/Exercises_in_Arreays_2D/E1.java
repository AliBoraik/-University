package Exercises_in_Arreays_2D;

import java.util.Arrays;

public class E1 {
    public static void main(String[] args) {

        //// sum of Roms and columns
        int [][] arr=new int[3][3];
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
                arr[i][j]= (int) (Math.random()*40);
            }
        }
        System.out.println(Arrays.deepToString(arr));
        int sum1=0;
        int sum2=0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
                sum1+=arr[i][j];
                sum2+=arr[j][i];
            }
            System.out.print("Sum of Rom  1 = "+sum1);
            System.out.print(" Sum of column 1 = "+sum2);
            System.out.println();
            sum1=0;
            sum2=0;
        }
    }
}
