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
        return operator;
    }

    public static OperatorType checkOperator(char operator){
        for(OperatorType ot : OperatorType.values()){
            if(ot.operator == operator) return ot;
        }
        return null;
    }

    public double calculate(Double x, Double y){
        if(PLUS.getOperator() == this.getOperator()){
            return x + y;
        }
        else if(MINUS.getOperator() == this.getOperator()){
            return x - y;
        }
        else if(MULTIPLY.getOperator() == this.getOperator()){
            return x * y;
        }
        else{
            if(y == 0) throw new ArithmeticException("0은 분모가 될 수 없습니다.");
            return x / y;
        }
    }
}
