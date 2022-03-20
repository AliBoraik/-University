package ru.kpfu.classwork.String;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        XO game=new XO();

        while (!game.gameOver){
            System.out.println("Enter number row and column of x");
                game.setX(s.nextInt(),s.nextInt());
            if (!game.gameOver){
                System.out.println("Enter number row and column of o");
                game.setY(s.nextInt(),s.nextInt());
            }
        }
    }
}