package LinkedList;

public class Main {
    public static void main(String[] args) {
        //***** задачи через class Node ****
        Node<Integer> a1 = new Node<>(1);
        Node<Integer> a2 = new Node<>(1);
        Node<Integer> a3 = new Node<>(1);
        Node<Integer> a4 = new Node<>(1);
        Node<Integer> a5 = new Node<>(1);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        int sum1 = 0;
        int max1 = a1.value;
        boolean equals = false;
        for (Node<Integer> i = a1; i != null; i = i.next) {
            sum1 += i.value;
            if (i.value > max1) {
                max1 = i.value;
            }
            if (!equals) {
                for (Node<Integer> j = i.next; j != null; j = j.next) {
                    if (i.value == j.value) {
                        equals = true;
                        break;
                    }
                }
            }
        }
        System.out.println("The nodes have two equals values = "+equals);
        System.out.println("Sum (with class Node) = "+sum1);
        System.out.println("Max (with class Node) = "+max1);
    }

}
