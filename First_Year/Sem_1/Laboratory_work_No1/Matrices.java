package Exercises.Laboratory_work_No1;
/*
 *   Борейк Али Акиль Али.
 *  Группа номер : 11-013.
 *
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Matrices {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.print("Enter the number of Rows : ");
        int n = S.nextInt();
        System.out.print("Enter the number of columns : ");
        int m = S.nextInt();
        double[][] matrix = new double[n][m + 1];
        int[] numbers;
        for (int i = 0, j = 1; i < n; i++, j++) {
            System.out.print("Enter the " + j + "th" + " column : ");
            String element = S.next();
            numbers = amt(element, m);
            for (int k = 0; k < m + 1; k++) {
                matrix[i][k] = numbers[k];
            }
        }
        double[] theBigger = new double[m + 1];
        //// order of the largest.
        for (int i = 1, j = 0; i < n; i++) {
            if (matrix[0][0] < matrix[i][j]) {
                for (int k = 0; k < m + 1; k++) {
                    theBigger[k] = matrix[i][k];
                    matrix[i][k] = matrix[0][k];
                    matrix[0][k] = theBigger[k];
                }
            }
        }
        //// zero matrix elements.
        double number;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == j) {
                    for (int k = i; k < n; k++) {
                        number = matrix[k][j];
                        for (int l = 0; l < m + 1; l++) {
                            matrix[k][l] /= number;
                        }
                    }
                    for (int h = i + 1; h < n; h++) {
                        for (int k = 0; k < m + 1; k++) {
                            matrix[h][k] -= matrix[i][k];
                        }
                    }
                }
            }
        }
        double[] value= new double[m];

        if (m==2){
            value[0]=matrix[1][2];
            value[1]=matrix[0][2]-(matrix[0][1]*value[0]);
        }else
            if (m==3){
                value[0]=matrix[2][3];
                value[1]=matrix[1][3]-(matrix[1][2]*value[0]);
                value[2]=matrix[0][3]-((matrix[0][2]*value[0])+matrix[0][1]*value[1]);
            }else
                if (m==4) {
                    value[0] = matrix[3][4];
                    value[1] = matrix[2][4] - (matrix[2][3] * value[0]);
                    value[2] = matrix[1][4] - ((matrix[1][3] * value[0]) + (matrix[1][2] * value[1]));
                    value[3] = matrix[0][4] - ((matrix[0][3] * value[0]) + (matrix[0][2] * value[1]) + (matrix[0][1] * value[2]));
                }

        System.out.println();
        for (int i = value.length-1,h=1; i >=0 ; i--) {
            System.out.println("The value of "+h+"x = "+value[i]);
            h++;
        }
    }
    //// This method for convert text to an array.
    public static int[] amt(String element, int m) {

        String regular = "^([-]?\\d+)?([-|+]\\d+)?([-|+]\\d+)?([-|+]\\d+)?([-|+]\\d+)?([-|+]\\d+)?([-|+]\\d+)?([-|+]\\d+)?([-|+]\\d+)?=([-]?\\d+)$";
        Pattern pattern = Pattern.compile(regular, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(element);
        int[] numbers = new int[m + 1];
        while (matcher.find()) {
            for (int i = 0, j = 1; i < m; i++) {
                numbers[i] = Integer.parseInt(matcher.group(j));
                j++;
            }
            numbers[m] = Integer.parseInt(matcher.group(10));
        }
        return numbers;
    }
}