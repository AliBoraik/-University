package ru.kpfu.classwork.EXClasses;

public class Student {
    private String name;
    private int age;
    private int numberGroup;
    protected static int number;
    private int numberOfStudent;

    public Student(String name, int age, int numberGroup) {
        this.name = name;
        this.age = age;
        this.numberGroup = numberGroup;
        number++;
        numberOfStudent=number;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }
    public Student (){
        number++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) {
        this.numberGroup = numberGroup;
    }

    public static int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", numberGroup=" + numberGroup +
                ", numberOfStudent=" + numberOfStudent +
                '}';
    }
}
