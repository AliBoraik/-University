package Excercises_classes_02;

public class Main{
    public static void main(String[] args) {
        Account testAccount = new Account(1122, 20000, 4.5);
        if (testAccount.withdraw(2100))
            System.out.println("see");
        else
            System.out.println("not");

        testAccount.deposit(3000);
    }
}