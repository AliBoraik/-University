package Comparable;

import java.util.Comparator;

public class ComByString extends User implements Comparable<String>, Comparator<String> {
    public ComByString(String name,int age) {
        this.name = name;
        this.age=age;
    }
    @Override
    public int compareTo(String o) {
        return this.name.compareTo(o);
    }
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
