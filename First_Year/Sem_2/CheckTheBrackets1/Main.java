package CheckTheBrackets1;

public class Main {
    public static void main(String[] args) {
        String a1 = "(2+3)*(2-4)";
        System.out.println("without Stack = " + check(a1));
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
