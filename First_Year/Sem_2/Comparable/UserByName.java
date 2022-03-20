package Comparable;


import java.util.Comparator;

public class UserByName extends User implements Comparable<UserByName>,Comparator<UserByName> {
    public UserByName(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(UserByName o1) {
        return this.name.compareTo(o1.name);
    }
    @Override
    public int compare(UserByName o2, UserByName o3) {
        return o2.compareTo(o3);
    }
}