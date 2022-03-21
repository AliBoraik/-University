package ru.itis.components;

import ru.itis.annotations.Column;
import ru.itis.annotations.Entity;
import ru.itis.annotations.Id;

@Entity(name = "model")
public class Model {
    @Id
    Long id;
    @Column
    String name;
}
