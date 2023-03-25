package com.ivonunes.view;

import com.ivonunes.model.Memory;
import com.ivonunes.model.MemoryObserver;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements MemoryObserver {

     private JLabel label;
     public Display(){
         Memory.getInstance().addObserver(this);

         setBackground(new Color( 46,49,50));
         label = new JLabel(Memory.getInstance().getCurrentText());
         label.setForeground(Color.WHITE);
         label.setFont(new Font("courrier", Font.PLAIN, 30));

         setLayout(new FlowLayout(FlowLayout.RIGHT, 10,15));
         add(label);
     }

    @Override
    public void valueChanged(String value) {
        label.setText(value);

    }
}
