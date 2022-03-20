package Exercises_Arrays_Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class E1 {
    public static void main(String[] args) {
        ArrayList<Integer> Arr =new ArrayList<>();
        Arr.add(100);Arr.add(200);
        Arr.add(300);Arr.add(400);
        System.out.println(Arr);
        System.out.println(Arr.get(3));
        Arr.remove(3);
        System.out.println(Arr);
        System.out.println(Arr.size());
        int [] arr ={4,5,6,7};
        int i=0;
        for (int number: arr){
            System.out.println(number+" "+i++);
        }
    }
}
