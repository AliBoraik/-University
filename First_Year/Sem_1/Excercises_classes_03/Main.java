package Excercises_classes_03;

import Excercises_classes_02.Account;
public class Main  {
    public static void main(String[] args) {
        Client one=new Client(22,"ali","891234567");
        Account test =new Account(12, (int) 12.2,234);
        System.out.println(one.addAccount(test));
        System.out.println(one.removeAccount(23));
        System.out.println(one.removeAccount(12));
        System.out.println(one.addAccount(test));
        System.out.println(one.toString());
    }
}
