package com.company.Model;

public class Answer {
    public double Value;

    public Answer(double value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "{\"r\":"+Value+"}";
    }
}
