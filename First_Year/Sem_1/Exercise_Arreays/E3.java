package Exercise_Arreays;

import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        int[] Arya={1,3,1,7,1,9};
        Scanner input= new Scanner(System.in);
        System.out.print("Inter the number : ");
        int number= input.nextInt();
        int time=0;
        for (int j : Arya) {
            if (j == number)
                time++;
        }
        System.out.println(number+" occurs "+time+" time");
    }
}
