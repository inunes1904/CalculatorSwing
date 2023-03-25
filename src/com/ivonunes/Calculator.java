package com.ivonunes;

import com.ivonunes.view.Display;
import com.ivonunes.view.Keyboard;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public Calculator(){

        organizeLayout();
        setVisible(true);
        setSize(232,322);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void organizeLayout() {

        setLayout(new BorderLayout());
        Display display = new Display();
        display.setPreferredSize(new Dimension(232, 60));
        display.setSize(232, 22);
        add(display, BorderLayout.NORTH);

        Keyboard keyboard = new Keyboard();
        add(keyboard, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        new Calculator();
    }
}
