package IntegerList;

public class List implements IntegerList{
    private int[] arr;
    private int index=0;
    private int size;

    public List(int size) {
        this.size=size;
        arr=new int[this.size];
    }

    @Override
    public boolean add(int x) {
        if (!isFull()){
         arr[this.index]=x;
         index++;
         return true;
        }
        return false;
    }
    private boolean isFull(){
        return index==size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
       this.index=0;
    }
    @Override
    public boolean remove(int x){
        if (contains(x)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == x) {
                    for (int j = i + 1; j < arr.length; j++) {
                        arr[i] = arr[j];
                        i++;
                    }
                    index--;
                }
            }
            return true;
        }else
            return false;
    }

    @Override
    public boolean contains(int x) {
        if (isEmpty()){
            return false;
        }
        for (int j : arr) {
            if (j == x) {
                return true;
            }
        }
        return false;
    }
    private boolean isEmpty(){
        return index==0;
    }

    @Override
    public String toString() {
        String s="List{";
        for (int i = 0; i <index ; i++) {
            s+=arr[i];
            if (i!=index-1){
                s+=",";
            }
        }
        s+="}";
        return s;
    }
}
