package com.ivonunes.view;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {


    public Button(String label, Color color){
        setText(label);
        setOpaque(true);
        setBackground(color);
        setForeground(color.WHITE);
        setFont(new Font("courrier", Font.PLAIN, 25));
        setBorder(BorderFactory.createLineBorder(color.BLACK));
    }
}
