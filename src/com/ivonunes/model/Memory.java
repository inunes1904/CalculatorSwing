package com.ivonunes.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private enum CommandType  {
        CLEAN, NUMBER, DIV, MULT, SUM, SUB, EQUAL, SEMICOLON, CHANGE;
    };
    private static final Memory memory = new Memory();

    private CommandType lastOp = null;
    private boolean replace = false;
    private String currentText = "";
    private String bufferText = "";

    private final List<MemoryObserver> observers = new ArrayList<>();

    private Memory(){

    }

    public static Memory getInstance(){
        return memory;
    }

    public String getCurrentText(){
        return currentText.isEmpty() ? "0" : currentText;
    }

    public void addObserver(MemoryObserver o){
        observers.add(o);
    }

    public void processOperation(String value){

        CommandType cmdType = detectTypeCmd(value);
        System.out.println(cmdType);

        if(cmdType == null){
            return;
        } else if (cmdType == CommandType.CLEAN){
            currentText = "";
            bufferText = "";
            replace = false;
            lastOp = null;
        }else if (cmdType == CommandType.NUMBER ||
                  cmdType == CommandType.SEMICOLON){
            currentText = replace ? value : currentText + value;
            replace = false;
        }else{
            replace = true;
            currentText = obtainOpResult();
            bufferText = currentText;
            lastOp = cmdType;
        }

        observers.forEach(o ->o.valueChanged(getCurrentText()));
    }

    private String obtainOpResult() {
        if (lastOp == null || lastOp == CommandType.EQUAL){
            return currentText;
        }
        double numberBuffer = Double.parseDouble(bufferText
                              .replace(",","."));
        double currentNum = Double.parseDouble(currentText
                              .replace(",","."));
        double result = 0;
        if (lastOp == CommandType.SUM){
            result =  numberBuffer + currentNum;
        }else if (lastOp == CommandType.SUB){
            result =  numberBuffer - currentNum;
        }else if (lastOp == CommandType.DIV){
            result =  numberBuffer / currentNum;
        }else if (lastOp == CommandType.MULT){
            result =  numberBuffer * currentNum;
        }else if (lastOp == CommandType.CHANGE){
        result =  -1 * currentNum;
        }
        String resultStr = Double.toString(result)
                .replace(".",",");
        boolean ifInt = resultStr.endsWith(",0");
        return ifInt ? resultStr.split(",")[0]: resultStr ;
    }

    private CommandType detectTypeCmd(String text) {
        if (currentText.isEmpty() && text == "0"){
            return null;
        }
        try {
            System.out.println(text);
            Integer.parseInt(text);
            return CommandType.NUMBER;
        } catch (NumberFormatException e) {
            // when is not a number
            if ("AC".equals(text)){
                return CommandType.CLEAN;
            }else if ("÷".equals(text)){
                return CommandType.DIV;
            }else if ("x".equals(text)){
                return CommandType.MULT;
            }else if ("+".equals(text)){
                return CommandType.SUM;
            }else if ("-".equals(text)){
                return CommandType.SUB;
            }else if ("=".equals(text)){
                return CommandType.EQUAL;
            }else if (",".equals(text) && !currentText.contains(",")){
                return CommandType.SEMICOLON;
            }else if ("+/-".equals(text)){
                return CommandType.CHANGE;
            }
        }
        System.out.println("!");
        return null;
    }
}
