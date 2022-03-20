package LinkedList;

public class Node<T> {
    public T value;
    public Node<T> next=null;

    public Node(T value) {
        this.value=value;
    }
}