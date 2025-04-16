import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculator");
        System.out.println("0 이상의 정수 1개를 입력하세요.");
        long x = sc.nextLong();
        System.out.println("'+', '-', '*', '/' 중 하나의 연산자를 입력하세요.");
        char operate = sc.next().charAt(0);
        System.out.println("0 이상의 정수 1개를 입력하세요.");
        long y = sc.nextLong();
        if(operate == '/' && y == 0) {
            System.out.println("0은 분모가 될 수 없습니다.");
        }
        else{
            switch(operate){
                case '+':
                    System.out.println("연산 결과: " + (x + y));
                    break;
                case '-':
                    System.out.println("연산 결과: " + (x - y));
                    break;
                case '*':
                    System.out.println("연산 결과: " + (x * y));
                    break;
                case '/':
                    System.out.println("연산 결과: " + (x / y));
                    break;
            }
        }
    }
}