package IntegerList;

public class IntegerListDemo {
    public static void main(String[] args) {
        List l=new List(2);
        l.add(1);
        l.add(2);
        System.out.println(l.toString());
        l.remove(2);
        System.out.println(l.toString());
    }
}
