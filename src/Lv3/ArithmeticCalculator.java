package Lv3;

import java.util.*;

public class ArithmeticCalculator<T> {
    private List<String> record = new ArrayList<>(); //연산결과 저장소, 캡슐화

    public <T extends Number> String calculate(T x, T y, char operate) throws ArithmeticException{ //연산
        OperatorType ot = OperatorType.checkOperator(operate);

        double result;
        double xValue = x.doubleValue();
        double yValue = y.doubleValue();
        String recordValue = "";
        switch(operate){
            case '+':
                result = xValue + yValue;
                recordValue = x + " + " + y + " = " + result;
                break;
            case '-':
                result = xValue - yValue;
                recordValue = x + " - " + y + " = " + result;
                break;
            case '*':
                result = xValue * yValue;
                recordValue = x + " * " + y + " = " + result;
                break;
            case '/':
                if(yValue == 0) throw new ArithmeticException("0은 분모가 될 수 없습니다.");

                result = xValue / yValue;
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
