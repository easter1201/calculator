package Lv3;

public enum OperatorType {
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

    public static OperatorType checkOperator(char operator){
        for(OperatorType ot : OperatorType.values()){
            if(ot.operator == operator) return ot;
        }
        return null;
    }
}
