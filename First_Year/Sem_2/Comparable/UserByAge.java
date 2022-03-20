package Comparable;

import java.util.Comparator;

public class UserByAge extends User implements Comparable<UserByAge>, Comparator<UserByAge> {
    public UserByAge (String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(UserByAge o1) {
        return this.age-o1.age;
    }
    @Override
    public int compare(UserByAge o2, UserByAge o3) {
        return o2.compareTo(o3);
    }
}
