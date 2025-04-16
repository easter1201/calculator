import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculator");
        while(true) {
            System.out.println("0 이상의 정수 1개를 입력하세요.");
            try {
                long x = sc.nextLong();
                System.out.println("'+', '-', '*', '/' 중 하나의 연산자를 입력하세요.");
                char operate = sc.next().charAt(0);
                if(operate == '+' || operate == '-'|| operate == '*' || operate == '/') {
                    System.out.println("0 이상의 정수 1개를 입력하세요.");
                    long y = sc.nextLong();
                    if (operate == '/' && y == 0) {
                        System.out.println("0은 분모가 될 수 없습니다.");
                    } else {
                        switch (operate) {
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
                else System.out.println("올바른 연산자를 입력해주세요.");
                System.out.println("종료를 원한다면 'exit'을, 추가 계산을 원한다면 아무 키나 입력하세요.");
                String order = sc.next();
                if(order.equals("exit")){
                    System.out.println("계산기가 종료됩니다.");
                    break;
                }
                }catch(InputMismatchException e){
                    System.out.println("잘못된 입력입니다.");
                    sc = new Scanner(System.in);
                }
            }
        }
}