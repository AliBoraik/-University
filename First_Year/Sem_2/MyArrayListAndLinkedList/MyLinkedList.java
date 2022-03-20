package MyArrayListAndLinkedList;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;




public class MyLinkedList<T> implements List<T> {
    private Node<T> head;
    private int index=-1;

    public MyLinkedList() {

    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public boolean contains(Object o) {
        for (Node<T> i =head; i !=null ; i=i.next) {
            if (i.value==o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr=new Object[index+1];
        // or
        // T[] arr= (T[]) new Object[index];
        int h=0;
        for (Node<T> i =head; i !=null ; i=i.next,h++) {
            arr[h]=i.value;
        }
        return arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> a=new Node<>(t);
        a.next=head;
        head=a;
        index++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()){
            return false;
        }
        if (head.value==o){
          head= head.next;
          index--;
          return true;
        }
        for (Node<T> i = head; i.next!=null; i=i.next) {
            if (i.next.value==o){
                i.next = i.next.next;
                this.index--;
                return true;
            }
        }
        return false;
    }
    public void removeAllObject(Object o) {
        if (isEmpty()){
            return;
        }
        int n=0;
        for (Node<T> i = head; i !=null ; i=i.next,n++) {
            if (i.value==o){
                remove(n);
                n--;
            }
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head=null;
        index=-1;
    }
    @Override
    public T get(int index) {
        int n=0;
        for (Node<T> i =head; n <=index; i=i.next) {
            if (n==index){
                return i.value;
            }
            n++;
        }
        return null;
    }
    public Node<T> getNode(int index) {
        int n=0;
        for (Node<T> i =head; n <=index; i=i.next) {
            if (n==index){
                return i;
            }
            n++;
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        int n=0;
        T oldValue;
        for (Node<T> i = head; n<=index; i=i.next,n++) {
            if (n==index){
                oldValue=i.value;
                i.value=element;
                return oldValue;
            }
        }
        return null;
    }
    @Override
    public void add(int index, T element) {
        Node<T> newElement=new Node<>(element);
        int n=0;
        for (Node<T> i = head; n<=index; i=i.next,n++) {
            if (n+1==index){
               newElement.next=i.next;
               i.next=newElement;
               return;
            }
        }
    }

    @Override
    public T  remove(int index) {
        int n = 0;
        T value = null;
        if (index == 0) {
            value= head.value;
            head= head.next;
            this.index--;
            return value;
        }
        for (Node<T> i = head; n <= index; i = i.next,n++) {
            if (n + 1 == index) {
                value=i.next.value;
                i.next = i.next.next;
                this.index--;
                break;
            }
        }
        return value;
    }

    @Override
    public int indexOf(Object o) {
        int n=0;
        for (Node<T> i =head; n<=index ; i=i.next,n++) {
            if (i.value==o)
                return n;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int indexOfObject=indexOf(o);
        if (indexOfObject ==-1){
            return -1;
        }
        return indexOf(o)-1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> list=new MyArrayList<>();
        for (Node<T> i =getNode(fromIndex); i !=null ; i=i.next) {
         list.add(i.value);
        }
        return list;

    }
}
