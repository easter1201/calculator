package Lv2;

import java.util.*;

public class Calculator {
    ArrayList<String> record = new ArrayList<>();
    String input = "";

    public long calculate(long x, long y, char operate){
        long result = 0;
        switch(operate){
            case '+':
                result = x + y;
                input = x + " + " + y + " = " + result;
                break;
            case '-':
                result = x - y;
                input = x + " - " + y + " = " + result;
                break;
            case '*':
                result = x * y;
                input = x + " * " + y + " = " + result;
                break;
            case '/':
                result = x / y;
                input = x + " / " + y + " = " + result;
                break;
        }
        record.add(input);
        return result;
    }
}
