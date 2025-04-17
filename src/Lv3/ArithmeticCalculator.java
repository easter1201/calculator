package Lv3;

import java.util.*;

public class ArithmeticCalculator {
    private List<String> record = new ArrayList<>(); //연산결과 저장소, 캡슐화

    public String calculate(long x, long y, char operate){ //연산
        OperatorType ot = OperatorType.checkOperator(operate);

        long result = ot.calculate(x, y);
        String recordValue = "";
        switch(operate){
            case '+':
                recordValue = x + " + " + y + " = " + result;
                break;
            case '-':
                recordValue = x + " - " + y + " = " + result;
                break;
            case '*':
                recordValue = x + " * " + y + " = " + result;
                break;
            case '/':
                recordValue = x + " / " + y + " = " + result;
                break;
        }
        setRecord(recordValue);
        return recordValue;
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
