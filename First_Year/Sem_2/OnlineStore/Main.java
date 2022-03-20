package ru.kpfu.classwork.OnlineStore;

public class Main {
    public static void main(String[] args) {
        SystemOfStore s = new SystemOfStore();
        Product p1 = new Product("A51", 20000, 0,
                "ru/kpfu/classwork/OnlineStore/A51.jpg",3,"smart phone");
        Product p2 = new Product("A41", 20000, 0,
                "ru/kpfu/classwork/OnlineStore/A41.jpg",6,"smart phone");
        Product p3 = new Product("A31", 20000, 0,
                "ru/kpfu/classwork/OnlineStore/A31.jpg",5,"smart phone");
        Product p4 = new Product("A71", 20000, 0,
                "ru/kpfu/classwork/OnlineStore/A71.jpg",34,"smart phone");
        s.addProduct(p1);
        s.addProduct(p2);
        s.addProduct(p3);
        s.buy(p1,20000);
        System.out.println(s.toString());
    }
}
