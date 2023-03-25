package com.ivonunes.view;

import com.ivonunes.model.Memory;
import com.ivonunes.model.MemoryObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Keyboard extends JPanel implements ActionListener {

    private final Color COLOR_DARK_GRAY = new Color(68,69,68);
    private final Color COLOR_LIGHT_GRAY = new Color(97, 100, 99);
    private final Color COLOR_ORANGE = new Color(242,163,60);

    public Keyboard(){

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        setLayout(layout);

        addButton("AC", COLOR_DARK_GRAY,c,0,0);
        addButton("+/-", COLOR_DARK_GRAY,c,1,0);
        addButton("%", COLOR_DARK_GRAY,c,2,0);
        addButton("÷", COLOR_ORANGE,c,3,0);

        addButton("7", COLOR_LIGHT_GRAY,c,0,1);
        addButton("8", COLOR_LIGHT_GRAY,c,1,1);
        addButton("9", COLOR_LIGHT_GRAY,c,2,1);
        addButton("x", COLOR_ORANGE,c,3,1);

        addButton("4", COLOR_LIGHT_GRAY,c,0,2);
        addButton("5", COLOR_LIGHT_GRAY,c,1,2);
        addButton("6", COLOR_LIGHT_GRAY,c,2,2);
        addButton("-", COLOR_ORANGE,c,3,2);

        addButton("1", COLOR_LIGHT_GRAY,c,0,3);
        addButton("2", COLOR_LIGHT_GRAY,c,1,3);
        addButton("3", COLOR_LIGHT_GRAY,c,2,3);
        addButton("+", COLOR_ORANGE,c,3,3);

        c.gridwidth = 2;
        addButton("0", COLOR_LIGHT_GRAY,c,0,4);
        c.gridwidth = 1;
        addButton(",", COLOR_LIGHT_GRAY,c,2,4);
        addButton("=", COLOR_ORANGE,c,3,4);


        //setLayout(new GridLayout(5,4));

    }

    private void addButton(String text, Color color,
                           GridBagConstraints c, int x, int y) {
        Button button = new Button(text, color);

        c.gridx = x;
        c.gridy = y;
        button.addActionListener(this);
        add(button, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {
            JButton btn = (JButton) e.getSource();
            Memory.getInstance().processOperation(btn.getText());
        }
    }
}
