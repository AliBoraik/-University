package Excercises_classes_06;

import Excercises_classes_02.Account;
import Excercises_classes_03.Client;

import java.util.ArrayList;

public class Main {
    // create the new class of Account class
    public static void main(String[] args) {
        ArrayList<Account> Accounts =new ArrayList<>();
        Accounts.add(new Account(123,11.2,4,new Client(3,"Ali","2345678")));
        System.out.println(Accounts);
    }
}