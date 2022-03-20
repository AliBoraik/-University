package Tree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left=null;
        right=null;
    }
    @Override
    public String toString() {
        return "value=" + value;
    }

}