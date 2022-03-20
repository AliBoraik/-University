package Backtricking;

import java.util.Arrays;
import java.util.LinkedList;

public class GetWords {
    public static void main(String[] args) {

        String word = "abc";
        for (int i = 0; i < word.length(); i++) {
            BT(String.valueOf(word.charAt(i)));

        }
    }

    private static void BT(String w) {
        if (w.length()>5){
            return;
        }
        if (w.length()==5){
            System.out.println("[ "+w+" ]");
        }else {
            String a="abc";
            for (int i = 0; i <a.length() ; i++) {
                if (correct(w, String.valueOf(a.charAt(i)))) {
                    String result = w + a.charAt(i);
                    BT(result);
                }
            }
        }
    }


    private static boolean correct(String w, String charAt) {
        w=w+charAt;
        for (int i = 0; i <w.length()-1 ; i++) {
            if (w.charAt(i)==w.charAt(i+1)){
                return false;
            }
           if (w.charAt(i)=='b'||w.charAt(i)=='c'){
               if (w.charAt(i+1)!='a'){
                   return false;
               }
           }
        }
        return true;
    }
}
