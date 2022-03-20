package ru;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBar extends JPanel implements ActionListener {
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btn0, btn_c, btnAdd, btnSub, btnMul, btnDiv, btnEq,
            btnCom, btn_cc, btnMin, btnP;

    private StringListener stringListener;


    public ButtonBar() {

        btn_cc = new JButton("CC");
        btnMin = new JButton("-/+");
        btnP = new JButton("%");

        btn_c = new JButton("C");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");
        btnEq = new JButton("=");
        btnCom = new JButton(".");

        GridLayout experimentLayout = new GridLayout(5, 4);

        setLayout(experimentLayout);
        setFontsFromButton();
        btn_c.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnDiv.addActionListener(this);
        btnMul.addActionListener(this);
        btnEq.addActionListener(this);
        btnCom.addActionListener(this);

        add(btn_c);
        add(btn_cc);
        add(btnP);
        add(btnMin);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btnMul);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btnSub);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btnAdd);
        add(btn0);
        add(btnCom);
        add(btnDiv);
        add(btnEq);


    }

    private void setFontsFromButton() {
        btn0.setFont(new Font("Arial", Font.PLAIN, 30));
        btn1.setFont(new Font("Arial", Font.PLAIN, 30));
        btn2.setFont(new Font("Arial", Font.PLAIN, 30));
        btn3.setFont(new Font("Arial", Font.PLAIN, 30));
        btn4.setFont(new Font("Arial", Font.PLAIN, 30));
        btn5.setFont(new Font("Arial", Font.PLAIN, 30));
        btn6.setFont(new Font("Arial", Font.PLAIN, 30));
        btn7.setFont(new Font("Arial", Font.PLAIN, 30));
        btn8.setFont(new Font("Arial", Font.PLAIN, 30));
        btn9.setFont(new Font("Arial", Font.PLAIN, 30));
        btnAdd.setFont(new Font("Arial", Font.PLAIN, 30));
        btnMul.setFont(new Font("Arial", Font.PLAIN, 30));
        btnDiv.setFont(new Font("Arial", Font.PLAIN, 30));
        btnSub.setFont(new Font("Arial", Font.PLAIN, 30));
        btnEq.setFont(new Font("Arial", Font.PLAIN, 30));
        btnCom.setFont(new Font("Arial", Font.PLAIN, 30));
        btn_c.setFont(new Font("Arial", Font.PLAIN, 30));
        btn_cc.setFont(new Font("Arial", Font.PLAIN, 30));
        btnMin.setFont(new Font("Arial", Font.PLAIN, 30));
        btnP.setFont(new Font("Arial", Font.PLAIN, 30));

    }

    public void setStringListener(StringListener stringListener) {
        this.stringListener = stringListener;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        stringListener.textEmitted(jButton.getText());
    }
}
