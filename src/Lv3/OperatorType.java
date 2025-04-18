package Lv3;

public enum OperatorType {                                      //연산자 타입 관리
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operator;

    OperatorType(char operator){
        this.operator = operator;
    }

    public char getOperator(){
        return this.operator;
    }

    public static OperatorType checkOperator(char operator){   //연산자 확인 후 반환
        for(OperatorType ot : OperatorType.values()){
            if(ot.operator == operator) return ot;
        }
        return null;                                           //맞지 않을 경우 null 반환
    }
}
