package Excercises_classes_04;

import Excercises_classes_02.Account;
import Excercises_classes_03.Client;

public class Main {
    public static void main(String[] args) {
        Client[] clients=new Client[2]; //null null
        clients[0]= new Client(1,"Ali","1234567890");

        clients[0].addAccount(new Account(1,2345,76547));
        clients[0].addAccount(new Account(12,2346,76548));
        clients[1]=new Client(2,"Aqel","987654321");

        clients[1].addAccount(new Account(13,2347,76549));
        clients[1].addAccount(new Account(14,2348,76541));
        clients[1].addAccount(new Account(15,2349,76543));
        System.out.println(clients[0]);
    }
}
