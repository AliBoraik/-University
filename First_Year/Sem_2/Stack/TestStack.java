package Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> myStack=new Stack<Integer>();
        myStack.pop();
        myStack.push(12);
        myStack.push(123);
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
        myStack.pop();
        System.out.println(myStack.isEmpty());
    }
}
