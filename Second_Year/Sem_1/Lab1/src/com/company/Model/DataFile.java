package com.company.Model;

public class DataFile {
    private int date;
    private double Close;


    public DataFile(int data, double close) {
        this.date = data;
        Close = close;
    }

    public int getDate() {
        return date;
    }


    public double getClose() {
        return Close;
    }


    @Override
    public String toString() {
        return "DataFile{" +
                "date=" + date +
                ", Close=" + Close +
                '}';
    }
}
