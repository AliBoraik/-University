package ru.kpfu.classwork.Exercises;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A=new int[20];
        for (int i = 0; i <A.length ; i++) {
            A[i]=(int)(Math.random()*100);
        }
        int[] B=new int[10];
        for (int i = 0; i <B.length ; i++) {
            B[i]=(int)(Math.random()*100);
        }
        int[] C=new int[4];
        for (int i = 0; i <C.length ; i++) {
            C[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(A)+"\n"+Arrays.toString(B)+"\n"+Arrays.toString(C));
        MinElem(A);
        MinElem(B);
        MinElem(C);
        char simple='A';
        System.out.println(simple+"\n"+"his number = "+ (int) simple);
        String word="hello";
        String word2="hello";
        String word3=word+word2;
        for (String aa:word3.split("")) {
            System.out.print(aa+" , ");
        }

    }
    public static void MinElem(int[] A){
        int Min1 =A[0];
        int Min2=A[1];
        for (int i = 2; i <A.length ; i++) {
           if (Min1>A[i]){
               Min2=Min1;
               Min1=A[i];
           }
        }
        System.out.println("The Min1 of Area = "+Min1);
        System.out.println("The Min2 of Area = "+Min2);
    }
}
