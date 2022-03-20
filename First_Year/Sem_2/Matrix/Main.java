package ru.kpfu.classwork.Matrix;



public class Main {
    public static void main(String[] args) {
        double[][] mat = new double[3][3];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;
        mat[1][0] = 4;
        mat[1][1] = 5;
        mat[1][2] = 6;
        mat[2][0] = 7;
        mat[2][1] = 8;
        mat[2][2] = 9;


        System.out.printf("\nThe determinant = " +"%.0f", determinantMatrix(mat));

    }

    public static double determinantMatrix(double[][] matrix) {
        // print all elements in matrix
        for (double[] element : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(element[j]);
                if (j != matrix.length - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
        double[] de =new double[matrix.length-1];
        double det=1;
        int index=0;
        int length = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            if (length != 1) {
//                boolean hasZeroColumn = true;
                for (int j = i; j < matrix.length; j++) {
                    if (matrix[j][j] == 0) {
//                        hasZeroColumn = true;
                        for (int k = j + 1; k < matrix.length; k++) {
                            if (matrix[k][j] != 0) {
//                                hasZeroColumn = false;
                                double el;
                                for (int l = 0; l < matrix.length; l++) {
                                    el = matrix[k][l];
                                    matrix[k][l] = matrix[j][l];
                                    matrix[j][l] = el;
                                }
                                det *= -1;
                                break;
                            }
                        }
                    }
                    if (j == i) {
                        double s = matrix[i][j];
                        de[index] = s;
                        index++;
                        for (int l = i; l < matrix.length; l++) {
                            matrix[j][l] /= s;
                        }
                    } else {
                        double s = matrix[j][i];
                        for (int k = i, l = i; k < matrix.length; k++, l++) {
                            matrix[j][k] = matrix[j][k] - (s * matrix[i][k]);
                        }
                    }
                }
                length--;
            } else {
                det *= matrix[matrix.length - 1][matrix.length - 1];
                if (det!=0) {
                    for (double v : de) {
                        det *= v;
                    }
                }
                break;
            }
        }
        return det;
    }
}