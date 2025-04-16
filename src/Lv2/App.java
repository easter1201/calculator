package Lv2;

import java.util.*;
public class App {
    public static void main(String[] args){
        Calculator calc = new Calculator(); //연산 클래스 호출
        Scanner sc = new Scanner(System.in); //스캐너 호출

        System.out.println("Calculator");
        while(true) { //연산 반복
            System.out.println("0 이상의 정수 1개를 입력하세요.");
            try { //정수가 아닌 다른 수 입력 시 예외처리
                long x = sc.nextLong();
                System.out.println("'+', '-', '*', '/' 중 하나의 연산자를 입력하세요.");

                char operate = sc.next().charAt(0);
                if(operate == '+' || operate == '-'|| operate == '*' || operate == '/') { //연산자가 아닌 다른 문자 입력 시 예외처리
                    System.out.println("0 이상의 정수 1개를 입력하세요.");
                    long y = sc.nextLong();
                    if (operate == '/' && y == 0) System.out.println("0은 분모가 될 수 없습니다."); //분모 0인경우 예외처리
                    else {
                        System.out.println("연산 결과: " + calc.calculate(x, y, operate)); //연산 출력, setter 사용
                    }
                }
                else System.out.println("올바른 연산자를 입력해주세요.");

                System.out.println("종료를 원한다면 'exit'을, 기록을 보고싶다면 'record'를, 추가 계산을 원한다면 아무 키나 입력하세요.");
                String order = sc.next();

                if(order.equals("exit")){ //exit 입력시 탈출
                    System.out.println("계산기가 종료됩니다.");
                    break;
                }
                else if(order.equals("record")){ //getter 사용-기록 출력
                    String[] record = calc.getRecord();
                    for(int i = 0; i < record.length; i++){
                        System.out.println("Record " + (i + 1) + " : " + record[i]);
                    }
                }
                else if(order.equals("delete")){ //setter 사용-제거 기능
                    calc.deleteRecord();
                    System.out.println("최근 기록 1개가 제거되었습니다.");
                }
            } catch(InputMismatchException e){ //잘못 입력 시 에러 메시지 출력, 초기화
                System.out.println("잘못된 입력입니다.");
                sc = new Scanner(System.in);
            }
        }
    }
}
