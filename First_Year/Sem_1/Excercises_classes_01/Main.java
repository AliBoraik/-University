package Excercises_classes_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rectangle[] rectangles =new Rectangle[3];
        for (int i = 0; i < rectangles.length ; i++) {
            System.out.print("Enter the width and height for  the "+(i+1)+"th Rectangle : ");
           rectangles[i]=new Rectangle(input.nextDouble(), input.nextDouble());
        }
        for (int i = 0; i < rectangles.length ; i++) {
            System.out.println("The Area for the "+(i+1)+", is = "+rectangles[i].getArea());
        }
    }
}
