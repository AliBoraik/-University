package itis;

import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {
    private TextPanel textPanel;
    private Toolbar toolbar;

    public MyFrame() throws HeadlessException {
        super("Hello");
        setLayout(new BorderLayout());


        textPanel = new TextPanel();
        toolbar = new Toolbar();


        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.append(text+"\n");
            }
        });


        add(textPanel, BorderLayout.CENTER);

        add(toolbar, BorderLayout.NORTH);


        setVisible(true);
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
