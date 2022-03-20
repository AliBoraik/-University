package ru.kpfu.classwork.EXClasses;

public class Book {
    private String nameBook;
    private int id;
    private Library.place placeOfRead;


    public Book(String nameBook, int id) {
        this.nameBook = nameBook;
        this.id = id;
        this.placeOfRead= Library.place.in_library;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Library.place getPlaceOfRead() {
        return placeOfRead;
    }

    public void setPlaceOfRead(Library.place place) {
        this.placeOfRead = place;
    }

    @Override
    public String toString() {
        return "{" +
                "nameBook='" + nameBook + '\'' +
                ", id=" + id +
                '}';
    }
}

