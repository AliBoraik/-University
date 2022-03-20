package PreessionTree;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Node root = new Node("+");
        root.left=new Node("3");
        root.right=new Node("*");
        root.right.left=new Node("5");
        root.right.right=new Node("2");
        int re=eval(root);
//
        resultByStack(root);
    }

    public static void resultByStack(Node root){
        if (root.right==null){
            System.out.println(root.value);
        }else {
            resultByStack(root.right);
            if (root.left==null){
                System.out.println(root.value);
            }else {
                resultByStack(root.left);
                System.out.println(root.value);
            }
        }
    }




    public static int eval(Node root) {
        if (root!=null) {
            if (!isOperation(root.value)) {
                return Integer.parseInt(root.value);
            } else {
                    int num1 = eval(root.left);
                    int num2 = eval(root.right);
                return result(num1,root.value,num2);
            }
        }
            return 0;
    }

    private static int result(int num1, String value, int num2) {
        switch (value){
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
        }
        return num1/num2;
    }

    private static boolean isOperation(String value) {
        return value.equals("+") || value.equals("-")
                || value.equals("*") || value.equals("/");
    }

}
