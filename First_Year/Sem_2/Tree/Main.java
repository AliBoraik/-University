package Tree;

public class Main {
    public static void main(String[] args) {
        Node root=new Node(3);
        SearchTree searchTree=new SearchTree(root);
        searchTree.add(root,4);
        searchTree.add(root,5);
        searchTree.add(root,1);
        searchTree.add(root,2);
//        System.out.println(searchTree.toStringPreorder(root));
//        searchTree.remove(2);
        searchTree.deleteKey(2);
        System.out.println(searchTree.toStringPreorder());



    }
}
