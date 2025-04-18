package Lv3;

import java.util.*;

public class ArithmeticCalculator<T> {
    private Map<String, Double> record = new LinkedHashMap<>(); //연산결과 저장소, 캡슐화

    public <T extends Number> String calculate(T x, T y, char operate) throws ArithmeticException{ //연산
        OperatorType ot = OperatorType.checkOperator(operate);

        double result = 0;
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
        setRecord(recordValue, result);
        return recordValue;
    }

    public String[] getRecord(){ //기록 긁어오기
        String[] output = new String[this.record.size()];
        Iterator<String> iter = this.record.keySet().iterator();
        for(int i = 0; i < this.record.size(); i++){
            output[i] = iter.next();
        }
        return output;
    }

    public void setRecord(String recordValue, Double result){ //기록 추가
        this.record.put(recordValue, result);
    }

    public boolean deleteRecord(){ //기록이 남아있을 경우에만 삭제 진행
        boolean del = false;
        String last = null;
        for(String key : this.record.keySet()) {
            last = key;
        }
        if(last != null) {
            this.record.remove(last);
            del = true;
        }
        return del;
    }

    public String searchRecord(double searchOrder){
        String result = "";
        for(Map.Entry<String, Double> entry : this.record.entrySet()){
            if(entry.getValue() > searchOrder) result += entry.getKey() + "\n";
        }
        if(result == "") result = "*계산 기록이 존재하지 않습니다.*";
        return result;
    }
}
