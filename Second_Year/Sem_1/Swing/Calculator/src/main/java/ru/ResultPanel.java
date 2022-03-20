package ru;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    private JTextField textArea;
    public ResultPanel() {
        setBorder(BorderFactory.createTitledBorder("Your result will be here"));

        textArea = new JTextField(16);
        textArea.setEditable(false);

        textArea.setPreferredSize(new Dimension(50,50));
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea),BorderLayout.CENTER);
    }
    public void append(String text){
        textArea.setText(textArea.getText()+text);
    }
    public String getText(){
        return textArea.getText();
    }
    public void setResult(String t){
        textArea.setText(t);
    }
}
