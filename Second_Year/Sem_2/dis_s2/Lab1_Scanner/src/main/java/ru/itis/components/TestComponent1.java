package ru.itis.components;


import ru.itis.annotations.Component;

@Component(name="test1")
public class TestComponent1 {

    public String getComponent1Info() {
        return "Hello from TestComponent # 1 !";
    }


}
