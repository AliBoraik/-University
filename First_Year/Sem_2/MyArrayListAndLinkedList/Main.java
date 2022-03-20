package MyArrayListAndLinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> a=new MyLinkedList<>();
        a.add("Ali");
        a.add("Aqel");
        a.add("Ali");
        a.add("Boraik");
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(a.indexOf("Aqel"));
        System.out.println(a.contains("Ali"));
        System.out.println(a.get(2));
        a.remove("Boraik");
        System.out.println(Arrays.toString(a.toArray()));
        MyArrayList<String> a1=new MyArrayList<>();
        a1.add("1");
        a1.add("2");
        a1.add("3");
        a1.add("4");
        a1.add("2");
        a1.remove("2");
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(a1.indexOf("2"));
        System.out.println(a1.contains("2"));
        System.out.println(a1.isEmpty());
        a1.clear();
        System.out.println(a.size());
        System.out.println(a1.size());

    }
}
