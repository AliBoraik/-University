package ru.kpfu.classwork.EXClasses;

import java.util.Arrays;

public class Library {
    private final int MAX_BOOKS = 10;
    private Book[] books = new Book[MAX_BOOKS];
    private String[] catalog = new String[MAX_BOOKS];
    private final Book[] blackLest=new Book[MAX_BOOKS];
    private int number = 0;
    private int numberInBlacklist=0;
    protected static int numberTheBooks;

    public boolean searchINCatalog(Book book) {
        for (String s : catalog) {
            if (book.getNameBook().equals(s))
                return true;
        }
        return false;
    }
    public Library() {
    }
    public void setBook(Book book) {
        if (number == 10) {
            System.out.println("The library is full");
        } else {
            books[number] = book;
            catalog[number] = book.getNameBook();
            number++;
        }
    }
    public boolean takeBook(Book book, place placeOfRead) {
        if (searchINCatalog(book)) {
            for (Book value : books) {
                if (book == value) {
                    value.setPlaceOfRead(placeOfRead);
                    if (placeOfRead==place.in_blacklist){
                        setToBlackLest(value);
                    }
                    return true;
                }
            }

        }
        return false;
    }
    public String infoBook(Book book){
        return "InFo for book {"+
                " Name: "+book.getNameBook()+
                " id ="+book.getId()+
                " Place: "+book.getPlaceOfRead()+
                " }";
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }
    public String[] getCatalog() {
        return catalog;
    }
    public void setCatalog(String[] catalog) {
        this.catalog = catalog;
    }
    public Book[] getBlackLest() {
        return blackLest;
    }
    public boolean notInLibrary(Book book){
        return book.getPlaceOfRead() != Library.place.in_library;
    }
    public void setToBlackLest(Book book) {
       if (notInLibrary(book)){
           blackLest[numberInBlacklist]=book;
           book.setPlaceOfRead(Library.place.in_blacklist);
           numberInBlacklist++;
       }
    }

enum place {
    subscription,
    reading_room,
    in_library,
    in_blacklist
}
    @Override
    public String toString() {
        return "Library {" +
                ", books = " + Arrays.toString(books) +
                ", catalog = " + Arrays.toString(catalog) +
                ", blackLest = " + Arrays.toString(blackLest) +
                '}';
    }
}
