package Lv2;

import java.util.*;

public class Calculator {
    private ArrayList<String> record = new ArrayList<>(); //연산결과 저장소, 캡슐화

    public long calculate(long x, long y, char operate){ //연산
        long result = 0;
        String input = "";
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
        setRecord(input);
        return result;
    }

    public String[] getRecord(){ //기록 긁어오기
        String[] output = new String[this.record.size()];
        for(int i = 0; i < this.record.size(); i++){
            output[i] = this.record.get(i);
        }
        return output;
    }

    public void setRecord(String input){ //기록 추가
        this.record.add(input);
    }

    public boolean deleteRecord(){ //기록이 남아있을 경우에만 삭제 진행
        boolean del = false;
        if(this.record.size() != 0) {
            this.record.remove(this.record.size() - 1);
            del = true;
        }
        return del;
    }
}
