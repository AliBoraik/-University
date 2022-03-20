package Tree;

public class SearchTree {
    Node root;

    public SearchTree(Node root) {
        this.root = root;
    }
    public boolean add(Node v,int x) {
        if (v.value == x) return false;
        if (v.value < x) {
            if (v.right != null) {
                return add(v.right, x);
            } else {
                v.right = new Node(x);
                return true;
            }
        } else {
            if (v.left != null) {
                return add(v.left, x);
            } else {
                v.left = new Node(x);
                return true;
            }
        }
    }
    void deleteKey(int key) { root = deleteRec(root, key); }

    Node deleteRec(Node root, int key)
    {
        if (root == null)
            return root;

        if (key < root.value)
            root.left = deleteRec(root.left, key);
        else if (key > root.value)
            root.right = deleteRec(root.right, key);

        else {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;


            root.value = minValue(root.right);
            
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    public boolean find(Node v,int x){
        if (v==null)return false;
        if (v.value==x)return true;
        return v.value>x?find(v.left,x):find(v.right,x);
    }
    public boolean remove(int x){
        return remove(new Node[]{root},x);
    }

    private boolean remove(Node[] v,int x ) {
        if (find(v[0],x)) {
            if (v[0] == null) return false;
            if (v[0].value == x) {
                if (v[0].left == null && v[0].right == null) {
                    v[0] = null;
                    return true;
                } else {
                    if (v[0].right != null) {
                        Node n = v[0].right;
                        while (n.left != null) {
                            n = n.left;
                        }
                        v[0].value = n.value;
                        n = null;
                        return true;
                    } else {
                        v[0].value = v[0].left.value;
                        return true;
                    }
                }
            } else {
                if (v[0].value < x) {
                    return remove(new Node[]{v[0].right}, x);
                } else {
                    return remove(new Node[]{v[0].left}, x);
                }
            }
        }
        return false;
    }
    public String toStringPreorder(){
        return toStringPreorder(root);
    }
    private String toStringPreorder(Node root) {
        String s = "";
        if (root == null) {
            return "";
        }
        s += root.toString();
        s += "\n left = "+toStringPreorder(root.left);
        s += "\n right= "+toStringPreorder(root.right)+"\n";
        return s;
    }
}
