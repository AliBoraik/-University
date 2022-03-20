package ru.itis;

import ru.itis.components.TestClass;

public class Main {
    public static void main(String[] args) {
        Context app = new Context(Main.class);

        TestClass.run();

    }
}
