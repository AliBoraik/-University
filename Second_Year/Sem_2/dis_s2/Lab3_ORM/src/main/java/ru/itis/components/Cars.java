package ru.itis.components;

import ru.itis.annotations.Column;
import ru.itis.annotations.Entity;
import ru.itis.annotations.Id;
import ru.itis.annotations.ManyToOne;

@Entity(name = "cars")
public class Cars {
    @Id
    Long id;

    @Column(name = "car_number")
    String number;

    @Column()
    String aa;

    @ManyToOne(name = "model_id")
    Model model;
}
