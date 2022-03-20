package BinaryTree;

public class Main {
    public static void main(String[] args) {
        Node root=new Node(12,null,null);
        Binary binaryTree=new Binary(root);
        Node node1=new Node(10,null,null);
        Node node2=new Node(13,null,null);
        Node node3=new Node(8,null,null);
        Node node4=new Node(15,null,null);
        Node node5=new Node(11,null,null);
        binaryTree.addNode(node1, binaryTree.root);
        binaryTree.addNode(node2, binaryTree.root);
        binaryTree.addNode(node3, binaryTree.root);
        binaryTree.addNode(node4, binaryTree.root);
        binaryTree.addNode(node5, binaryTree.root);
        binaryTree.Search(10,root);
        binaryTree.Search(15,root);
        binaryTree.Search(22,root);


    }
}
