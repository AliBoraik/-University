package com.company.Model;

public class WrongAnswer {
    public int Error;
    public String Description;

    public WrongAnswer(int error, String description) {
        Error = error;
        Description = description;
    }

    @Override
    public String toString() {
        return "{\"error\":"+Error+"\"description\":"+Description+"}";
    }
}
