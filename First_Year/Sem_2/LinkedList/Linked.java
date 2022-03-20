package LinkedList;

public class Linked<T> {
    Node<T> head;
    Node<T> end;
    int count=0;


    public Linked() {
        head=null;
    }

    public void add(Node<T> newNode){
        newNode.next=head;
        this.head=newNode;
        count++;
    }

    public void addToEnd(Node<T> newNode){
        if (end==null) {
            for (Node<T> i = head; i != null; i = i.next) {
                if (i.next == null) {
                    i.next = newNode;
                    end = newNode;
                    count++;
                    break;
                }
            }
        }else{
            end.next=newNode;
            end=newNode;
            count++;
        }
    }
    public boolean addOnPosition(int index, Node<T> newNode ){
        if (index>this.count){
            return false;
        }
        int n=1;
        for (Node<T> i =head; n <=index; i=i.next) {
            if (n==index){
                newNode.next=i.next;
                i.next=newNode;
                count++;
            }
            n++;
        }
        return true;
    }
    public void delete(){
        head=head.next;
        count--;
    }
    public void deleteEnd() {
        for (Node<T> i = head; i !=null; i =i.next) {
            if ( i.next.next == null) {
                i.next = null;
                end = i;
                count--;
            }
        }
    }

    public boolean deleteOnPosition(int index){
        if (index>this.count||index==0){
            return false;
        }
        int n=1;
        if (index==1){
            delete();
            return true;
        }
        if (index==this.count){
            deleteEnd();
            return true;
        }
        for (Node<T> i =head; n <=index; i=i.next) {
            if (n+1==index){
              i.next=i.next.next;
                count--;
            }
            n++;
        }
        return true;
    }
    public void display(){
        for (Node<T> i =head; i !=null ; i=i.next) {
            System.out.print(i.value+"\t");
        }
    }

}
