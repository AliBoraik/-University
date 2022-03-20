package itis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });

    }
}


//  zero = new JButton("0");
//        one = new JButton("1");
//        tow = new JButton("2");
//        three = new JButton("3");
//        four = new JButton("4");
//        five = new JButton("5");
//        six = new JButton("6");
//        seven = new JButton("7");
//        eight = new JButton("8");
//        nine = new JButton("9");



//        add(one);
//        add(tow);
//        add(three);
//        add(four);
//        add(five);
//        add(six);
//        add(seven);
//        add(eight);
//        add(nine);
//        add(l);
