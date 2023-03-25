package com.ivonunes.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private static final Memory memory = new Memory();

    private String currentText = "";

    private final List<MemoryObserver> observers = new ArrayList<>();

    private Memory(){

    }

    public static Memory getInstance(){
        return memory;
    }

    public String getCurrentText(){
        return currentText;
    }

    public void addObserver(MemoryObserver o){
        observers.add(o);
    }

    public void processOperation(String value){
        currentText += value;

        observers.forEach(o ->o.valueChanged(currentText));
    }
}
