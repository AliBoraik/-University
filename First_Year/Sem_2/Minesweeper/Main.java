package Minesweeper;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s=showTheMassages();
        int length;
        int width;
        if (s.equals("1")){
            length=6;
            width=12;
        }else
            if (s.equals("2")){
                length=8;
                width=16;
            }else {
                // if the input is "3"
                length=10;
                width=28;
            }
        Game minesweeper = new Game(length,width);
        minesweeper.hard=difficultyLevel();
        minesweeper.showTheBoard();
        while (!minesweeper.gameOver) {
            System.out.print("Enter the numbers of the location you want to play in, for example (0 5) : ");
            String location=checkTheLocation(length,width);
            String[] locations=location.split(" ");
            int l= Integer.parseInt(locations[0]);
            int w= Integer.parseInt(locations[1]);
            minesweeper.play(l,w);
        }
    }

    private static int difficultyLevel() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter difficulty level from 1 to 8");
        String s=input.nextLine();
        while (!s.matches("^(?:[1-8])$")){
            System.out.println("The entry is not correct..\nenter difficulty level from 1 to 8 :");
            s=input.nextLine();
        }
        return Integer.parseInt(s);
    }

    public static String showTheMassages(){
        Scanner input = new Scanner(System.in);
        System.out.print("Choose the size of the game by entering the appropriate number " +
                "\n 1. Small." +
                "\n 2. Medium." +
                "\n 3. Big.");
        System.out.println();
        String s = input.nextLine();
        while (!s.matches("^(?:[1-3])$")) {
            System.out.print("The entry is not correct..\nchoose the size of the game by entering the appropriate number " +
                    "\n 1. Small." +
                    "\n 2. Medium." +
                    "\n 3. Big" +
                    "\n for example: 1 \n");
            s = input.nextLine();
        }
        return s;
    }
    public static String checkTheLocation(int length,int width){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] sMat=s.split(" ");
       while (!s.matches("^(?:\\d+ \\d+)$")||Integer.parseInt(sMat[0])>length||Integer.parseInt(sMat[1])>width){
           System.out.print("The entry is not correct..\nEnter the numbers of the location you want to play in, for example (0 5) : ");
           s = input.nextLine();
       }
        return s;
    }
}
