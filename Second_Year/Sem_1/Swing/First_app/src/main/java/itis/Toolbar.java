package itis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel  implements ActionListener {
    private JButton btn1;
    private JButton btn2;
    private StringListener stringListener;


    public Toolbar() {
        btn1 = new JButton("Hello");
        btn2 = new JButton("Goodbye");

        setLayout(new FlowLayout(FlowLayout.CENTER));

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        add(btn1);
        add(btn2);

    }

    public void setStringListener(StringListener stringListener) {
        this.stringListener = stringListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton click = (JButton) e.getSource();
        if (click == btn1){
            stringListener.textEmitted(btn1.getText());
          //  textPanel.append(btn1.getText()+"\n");
        }else
            stringListener.textEmitted(btn2.getText());
          //  textPanel.append(btn2.getText()+"\n");
    }
}
