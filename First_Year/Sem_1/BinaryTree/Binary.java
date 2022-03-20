package BinaryTree;

public class Binary {
    Node root;

    public Binary(Node root) {
        this.root = root;
    }
    public void addNode(Node newNode,Node root){
        if (newNode.value<root.value){
            if (root.nodeLeft==null) {
                root.nodeLeft = newNode;
                System.out.println("Add in the left");
            }
            else
                addNode(newNode,root.nodeLeft);
        }
        if (newNode.value>root.value){
            if (root.nodeRight==null) {
                root.nodeRight = newNode;
                System.out.println("Add in the right");
            }
            else
                addNode(newNode,root.nodeRight);
        }
    }
    public void Search(int value,Node root){
        if (root==null){
            System.out.println("value don't funded !");
            return;
        }
        if (root.value==value){
            System.out.println("value is funded");
            return;
        }

        if (value> root.value) {
                Search(value, root.nodeRight);
        }
        if (value< root.value) {
                Search(value, root.nodeLeft);
        }

    }

}
