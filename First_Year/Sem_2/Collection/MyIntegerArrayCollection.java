import java.util.Collection;
import java.util.Iterator;

public class MyIntegerArrayCollection implements Collection<Integer> {

    private int capacity = 1000;
    private int count = 0;
    private int [] arr = new int[capacity];

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (count==0||(!(o instanceof Integer ||
                o instanceof Short ||
                o instanceof Byte ))){
            return false;
        }else {
            int x = ((Number) o).intValue();
            for (int i = 0; i < count; i++) {
                if (arr[i] == x)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        if (count == capacity) {
          return false;
        }
        arr[count] = integer;
        count++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Integer ||
                o instanceof Short ||
                o instanceof Byte )) {
            return false;
        } else {
            int x = ((Number) o).intValue();
            // removing...
            if (contains(x)){
                for (int i = 0; i <count ; i++) {
                    if (arr[i]==x){
                        for (int j = i+1; j <count ; j++) {
                            arr[i]=arr[j];
                            i++;
                        }
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    // example of Template Methods
    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean result = false;
        for (Integer num : c) {
            // create the test that will find error with ||
            result = result | add(num);
            // result = add(num) || result - that is fine
        }
        return result;
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

    }
}
