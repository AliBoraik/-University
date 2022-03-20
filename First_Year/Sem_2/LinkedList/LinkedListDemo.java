package LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        Linked<Integer> linked=new Linked<>();
        linked.add(new Node<>(1));
        linked.add(new Node<>(2));
        linked.add(new Node<>(3));
        linked.add(new Node<>(4));
        linked.display();
        System.out.println();
        System.out.println(linked.addOnPosition(2,new Node<>(10)));
        linked.addToEnd(new Node<>(11));
        linked.display();
        linked.deleteEnd();
        System.out.println();
        linked.display();
        System.out.println(linked.deleteOnPosition(5));
        System.out.println();
        linked.display();


    }
}
