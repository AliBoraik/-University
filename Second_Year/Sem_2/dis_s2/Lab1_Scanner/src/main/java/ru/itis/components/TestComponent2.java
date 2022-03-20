package ru.itis.components;

import ru.itis.annotations.Component;

@Component(name = "test")
public class TestComponent2 {

    public String getComponent2Info() {
        return "Hello from TestComponent # 2 !";
    }

}
