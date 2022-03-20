package MyArrayListAndLinkedList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int capacity=100;
    private T[] arr= (T[]) new Object[capacity];
    private int index=-1;

    public MyArrayList() {
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index==-1;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i <=index ; i++) {
            if (o == arr[i]){
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
        return arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
    private boolean isFull(){
        return capacity==index;
    }
    private void toNewArray(){
        capacity=capacity*2;
        T[] newArr= (T[]) new Object[capacity];
        System.arraycopy(newArr, 0, arr, 0, arr.length);
        arr=newArr;
    }

    @Override
    public boolean add(T t) {
        index++;
        if (isFull()){
            toNewArray();
        }
        arr[index]=t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()){
            return false;
        }
        for (int i = 0; i <=index ; i++) {
           if (arr[i]==o){
               changePlaces(i,index);
               index--;
               return true;
           }
        }

        return false;
    }
    private void changePlaces(int h,int index){
        for (int i = h; i <=index-1 ; i++) {
            h++;
            arr[i]=arr[h];
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
        index=-1;

    }

    @Override
    public T get(int index) {
        return null;
    }
    @Override
    public T set(int index, T element) {
        if (index>this.index||index<this.index){
            return null;
        }
        arr[index]=element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        for (int i = index+1; i <=this.index ; i++) {
            T old=arr[i-1];
            arr[i-1]=element;
            arr[i]=old;
        }
    }

    @Override
    public T remove(int index) {
        T value=arr[index];
        changePlaces(index,this.index);
        return value;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i <=index ; i++) {
            if (arr[i]==o){
                return i;
            }
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
        list.addAll(Arrays.asList(arr).subList(fromIndex, toIndex + 1));
        return list;
    }
}
