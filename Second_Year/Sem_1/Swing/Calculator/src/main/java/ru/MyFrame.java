package ru;

import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {
    private final ResultPanel resultPanel;
    private String operation;
    private String num1 = "";
    private String num2 = "";

    public MyFrame() throws HeadlessException {
        super("Calculator");
        setLayout(new BorderLayout());


        resultPanel = new ResultPanel();
        ButtonBar buttonBar = new ButtonBar();


        buttonBar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String s) {

                if (s.equals("C")) {
                    operation = null;
                    num1 = "";
                    num2 = "";
                    resultPanel.setResult("");

                } else if (s.equals("=")) {
                    num1 = getResult();
                    resultPanel.setResult(num1);
                    operation = null;
                    num2 = "";

                } else if (isOperation(s) && operation != null) {

                    num1 = getResult();
                    resultPanel.setResult(num1);
                    operation = s;
                    resultPanel.append(s);
                    num2 = num1;
                    num1 = "";

                } else if (isOperation(s)) {
                    operation = s;
                    resultPanel.append(s);
                    num2 = num1;
                    num1 = "";
                } else {
                    num1 += s;
                    resultPanel.append(s);

                }
            }
        });

        add(resultPanel, BorderLayout.PAGE_START);

        add(buttonBar, BorderLayout.CENTER);


        setVisible(true);
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private String getResult() {
        return switch (operation) {
            case "+" -> String.valueOf((Double.parseDouble(num2) + Double.parseDouble(num1)));
            case "-" -> String.valueOf((Double.parseDouble(num2) - Double.parseDouble(num1)));
            case "*" -> String.valueOf((Double.parseDouble(num2) * Double.parseDouble(num1)));
            case "/" -> String.valueOf((Double.parseDouble(num2) / Double.parseDouble(num1)));
            default -> null;
        };
    }

    private boolean isOperation(String text) {
        return text.equals("+") || text.equals("-") || text.equals("/") || text.equals("*");
    }
}
