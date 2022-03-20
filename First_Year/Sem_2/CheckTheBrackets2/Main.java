package CheckTheBrackets2;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String a2 = "if (x>y){x=(z-y)*x} a[1]=(x+y)*z";
        System.out.println("With stack = "+checkWithStack(a2));
    }
    //       ******* with Stack *********
    private static boolean checkWithStack(String c){
        Stack<Character> a=new Stack<>();
        for (int i = 0; i < c.length(); i++) {
            if (isOpen(c.charAt(i))){
                a.push(c.charAt(i));
            }else {
                if (isClose(c.charAt(i))){
                    if (a.isEmpty()){
                        return false;
                    }else {
                        char open=a.peek();
                        char close=c.charAt(i);
                        if (isMatch(open,close)) {
                            a.pop();
                        }else {
                            return false;
                        }
                    }
                }
            }
        }
        return a.isEmpty();
    }

    private static boolean isMatch(char open, char close) {
        if (open=='('){
            return open+1==close;
        }else
            return open+2==close;
    }
    public static boolean isOpen(char s){
        String open = "({[";
        for (int i = 0; i <open.length() ; i++) {
            if (open.charAt(i)==s){
                return true;
            }
        }
        return false;
    }
    public static boolean isClose(char s){
        String close = "]})";
        for (int i = 0; i <close.length() ; i++) {
            if (close.charAt(i)==s){
                return true;
            }
        }
        return false;
    }
}
