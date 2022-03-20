package Excercises_classes_02;

import Excercises_classes_03.Client;
import Excercises_classes_05.Transaction;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private Date dateCreated;
    private double annualInterestRate;
    private Client client;
    private ArrayList<Transaction> transaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Account(int id, double balance, double annualInterestRate, Client client){
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
        dateCreated =new Date();
        this.client=client;
        this.transaction=new ArrayList<>();
    }

    public Account(int i, int i1, double v) {

    }

    public boolean withdraw(double money){
       if (money>balance)return false;
       balance-=money;
        this.transaction.add(new Transaction('W',money,this.balance,"withdrawn "+money));
       return true;

    }
    public void deposit(double money){
         this.balance+=money;
         this.transaction.add(new Transaction('D',money,this.balance,"deposited "+money));
    }

    public double getBalance() {
        return balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                ", annualInterestRate=" + annualInterestRate +
                '}';
    }
}
