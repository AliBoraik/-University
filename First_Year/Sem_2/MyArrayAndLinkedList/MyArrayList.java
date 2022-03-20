package MyArrayAndLinkedList;

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
               break;
           }
        }

        return false;
    }
    private void changePlaces(int h,int index){

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
       return null;
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
      return null;
    }

    @Override
    public int indexOf(Object o) {
       return  0;
    }

    @Override
    public int lastIndexOf(Object o) {
      return 0;
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
       return null;
    }
}
