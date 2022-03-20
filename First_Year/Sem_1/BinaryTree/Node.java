package BinaryTree;

public class Node {
    int value;
    Node nodeLeft;
    Node nodeRight;

    public Node(int value, Node nodeLeft, Node nodeRight) {
        this.value = value;
        this.nodeLeft = nodeLeft;
        this.nodeRight = nodeRight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", nodeLeft=" + nodeLeft +
                ", nodeRight=" + nodeRight +
                '}';
    }
}
