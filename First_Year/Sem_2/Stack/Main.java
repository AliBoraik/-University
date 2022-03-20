package Stack;

public class Main {
    public static void main(String[] args) {
        String a1 = "(22+3)*(2+3)";
        System.out.println(check(a1)); // output true
        String a2="(2-4*(3+2)";
        System.out.println(check(a2)); // output false
    }
    //       ******* without Stack *********
    private static boolean check(String a) {
        int open=0;
        int close=0;
        for (int i = 0; i <a.length() ; i++) {
            if (a.charAt(i)=='('){
                open++;
            }
            if (a.charAt(i)==')'){
                close++;
            }
        }
        return open==close;
    }
}
