package Lv2;

public class Calculator {
    public long calculate(long x, long y, char operate){
        long result = 0;
        switch(operate){
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
        }
        return result;
    }
}
