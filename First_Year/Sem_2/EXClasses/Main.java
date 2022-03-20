package ru.kpfu.classwork.EXClasses;


public class Main {
    public static void main(String[] args) {
        Library library=new Library();
        Book b1=new Book("Matitmatica",12);
        Book b2=new Book("er",3);
        Book b3=new Book("fgdsdf",14562);
        Book b4=new Book("Matitmahgfdstica",654);
        Book b5=new Book("trewsdfv",54);
        library.setBook(b1);
        library.setBook(b2);
        library.setBook(b3);
        library.setBook(b4);
        library.setBook(b5);
        library.searchINCatalog(b1);
        library.notInLibrary(b1);
        library.takeBook(b1, Library.place.subscription);
        library.takeBook(b2, Library.place.subscription);
        library.takeBook(b3, Library.place.reading_room);
        System.out.println(library.infoBook(b2));
        System.out.println(library.infoBook(b1));
        System.out.println(library.takeBook(b1, Library.place.reading_room));
        System.out.println(library.infoBook(b1));
        library.setToBlackLest(b2);
        System.out.println(library.infoBook(b2));
        Student student1=new Student("Ali",21, 13);
        Student student2=new Student("Nasser",19, 14);
        Student student3=new Student("Faded",16, 15);
        System.out.println(student2.getNumberOfStudent());




    }
}
