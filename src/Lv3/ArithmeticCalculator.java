package Lv3;

import java.util.*;
import java.util.stream.*;
public class ArithmeticCalculator<T> {
    private Map<String, Double> record = new LinkedHashMap<>();                                     //연산결과 저장소, 캡슐화 - 조회 및 검색 시 연산 내용도 함께 출력 위해 Map, 결과값 조건 비교 위해 value에는 결과값만
    private int recordNumber = 0;                                                                   //연산 번호 - 중복되는 연산 구분
    public <T extends Number> String calculate(T x, T y, char operate) throws ArithmeticException{  //연산
        double result = 0;
        double xValue = x.doubleValue();
        double yValue = y.doubleValue();
        String recordValue = "";

        switch(operate){                                                                            //연산자에 따른 연산
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
                if(yValue == 0) throw new ArithmeticException();                                  //0으로 나누려는 시도 - 예외처리

                result = xValue / yValue;
                recordValue = x + " / " + y + " = " + result;
                break;
        }

        String returnValue = recordValue;                                                         //출력위한 변수 선언, recordValue값 저장
        recordValue = "Record " + ++recordNumber + " : " + recordValue;                           //Key값에 기록 번호 저장
        setRecord(recordValue, result);                                                           //수식 및 결과 저장(Key: 기록번호 + 수식 + 결과, value: 결과값)

        return returnValue;                                                                       //Key값 반환
    }

    public OperatorType searchOperator(char operator){                                            //연산자 체크 호출 및 반환
        OperatorType result = OperatorType.checkOperator(operator);

        return result;
    }

    public String[] getRecord(){                                                                  //기록 긁어오기
        String[] output = new String[this.record.size()];
        Iterator<String> iter = this.record.keySet().iterator();
        for(int i = 0; i < this.record.size(); i++){
            output[i] = iter.next();
        }
        return output;
    }

    public void setRecord(String recordValue, Double result){                                     //기록 추가
        this.record.put(recordValue, result);                                                     //Key에는 기록 번호 포함한 전체 수식, value에는 단순 결과값만 저장
    }

    public boolean isDeleteRecord(){                                                                //기록이 남아있을 경우에만 삭제 진행
        boolean del = false;
        String last = null;
        for(String key : this.record.keySet()) {                                                  //키값 검색해 저장
            last = key;
        }
        if(last != null) {                                                                        //저장된 키값이 있는 경우(기록이 1개라도 남아있는 경우)
            this.record.remove(last);                                                             //삭제
            recordNumber--;                                                                       //기록 번호 감소
            del = true;                                                                           //삭제 완료 체크
        }
        return del;
    }

    public List<String> searchRecord(double searchOrder){                                       //lambda&Stream 사용 - 검색
        return this.record.entrySet().stream()
                .filter(entry -> entry.getValue() > searchOrder)                                //value가 기준값 이상인 것만 필터링
                .map(Map.Entry :: getKey)                                                       //Key 값(전체 수식) 반환
                .collect(Collectors.toList());                                                  //리스트화
    }
}
