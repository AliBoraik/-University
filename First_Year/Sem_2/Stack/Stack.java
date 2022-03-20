package Stack;

public class Stack<T> {
    private int capacity=10;
    private Object[] arr;
    private int index=0;

    public Stack() {
        this.arr=new Object[this.capacity];
    }
    public void push(T element){
        isFull();
        arr[this.index]=element;
        this.index++;
    }
    private void isFull(){
        if (this.index==this.capacity){
            this.capacity=this.capacity*2;
            Object[] newArr=new Object[this.capacity];
            System.arraycopy(arr, 0, newArr, 0, this.arr.length);
            this.arr=newArr;
        }
    }
    public void pop(){
        if (!isEmpty()) {
            this.index--;
        }
    }
    public boolean isEmpty(){
        return index==0;
    }
    public Object peek(){
       if (isEmpty()){
           return null;
       }else
           return arr[index-1];
    }
}
