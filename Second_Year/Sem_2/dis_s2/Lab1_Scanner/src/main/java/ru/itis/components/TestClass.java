package ru.itis.components;


import ru.itis.annotations.Component;
import ru.itis.annotations.Inject;

@Component()
public class TestClass {

    @Inject
    public static TestComponent1 field1;

    @Inject
    public TestComponent2 field2;

    public static void run(){
        System.out.println(field1.getComponent1Info());
    }


}
