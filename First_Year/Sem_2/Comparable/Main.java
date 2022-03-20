package Comparable;

public class Main {
    public static void main(String[] args) {
        UserByName byName1 = new UserByName("Ali", 12);
        UserByName byName2 = new UserByName("Ahmed", 14);
        UserByName byName3 = new UserByName("Raheb", 15);
        System.out.println(byName1.compareTo(byName3));
        System.out.println(byName1.compareTo(byName2));
        UserByAge byAge1 =new UserByAge("Ali",18);
        UserByAge byAge3 =new UserByAge("Raheb",22);
        System.out.println(byAge1.compareTo(byAge3));
        ComByString byString=new ComByString("Ali",21);
        System.out.println(byString.compareTo("Ahmed"));
        ByDouble byDouble=new ByDouble(0.123456789);
        System.out.println(byDouble.compareTo(0.123465878));
    }
}
