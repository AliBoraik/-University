package ExpressionTree;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Node root=new Node("+");
        root.left=new Node("3");
        root.right=new Node("*");
        root.right.right=new Node("2");
        root.right.left=new Node("5");
        System.out.println(eval(root));
        System.out.println(value_Stack(root));

    }
    private static int value_Stack(Node t){
        Stack<Integer> num=new Stack<>();
        if (t != null) {
            if (!isOperation(t.value)) {
                return Integer.parseInt(t.value);
            }
            num.push(value_Stack(t.right));
            num.push(value_Stack(t.left));
            if (isOperation(t.value))
                return calculator(num.pop(),t.value,num.pop());
        }
        return 0;
    }

    private static int eval(Node t) {
        if (t!=null){
            if (!isOperation(t.value)){
                return Integer.parseInt(t.value);
            }else {
                int num1=eval(t.left);
                int num2=eval(t.right);
                return calculator(num1,t.value,num2);
            }
        }
        return 0;
    }

    private static int calculator(int num1, String value, int num2) {
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
        return value.equals("+")||value.equals("*")||value.equals("-")||value.equals("/");
    }

}
