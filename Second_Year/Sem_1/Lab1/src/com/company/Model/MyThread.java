package com.company.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyThread extends Thread {
    private final String path;
    public List<DataFile> list;
    public double X_;
    public double n;
    public double b_x;
    public double sumOfClose;

    public MyThread(String path) {
        this.path = path;
    }

    public void run() {
        try {
            // read from file and save in list<DataFile> .
            list = ReadFromFileToColl(path);
            // set n
            n = list.size();
            // sorting the list .
            list.sort(Comparator.comparingInt(DataFile::getDate));
            // get Model x
            X_ = getX_();
            // get sum of Close
            sumOfClose = getSumOfClose();
            // get б(X)
            b_x = getB_X();
        } catch (IOException e) {
            // error
        }
    }

    private double getB_X() {
        double s = getSquareSum();
        return Math.sqrt(s);
    }
    private double getX_() {
        double sum = 0;
        for (DataFile e:list) {
            sum += e.getClose();
        }
        return sum/n;
    }

    private double getSquareSum() {
        double sum = 0;
        for (DataFile e : list) {
            double q = e.getClose() - X_;
            sum += (q*q);
        }
        return sum;
    }

    private double getSumOfClose() {
       double sum = 0;
        for (DataFile e : list) {
            sum += e.getClose() - X_;
        }
        return sum;
    }
    public List<DataFile> ReadFromFileToColl(String path) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader(path));
        List<DataFile> dataFile = new ArrayList<>();
        read.readLine();
        String line = read.readLine();
        while (line != null) {
            String[] da = line.split(";");
            dataFile.add(new DataFile(Integer.parseInt(da[2]), Double.parseDouble(da[4])));
            line = read.readLine();
        }
        return dataFile;
    }
}
