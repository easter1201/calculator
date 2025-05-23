package Lv2;

import java.util.*;

public class App {
    public static boolean Display(Scanner sc,Calculator calc){ //결과 이후 출력
        while(true){
            System.out.println("\n종료를 원한다면 'exit'을, 기록을 보고싶다면 'record'를, 기록 삭제를 원한다면 'delete'를, 추가 계산을 원한다면 아무 키나 입력하세요.");
            String order = sc.next();

            if(order.equals("exit")){ //계산기 종료
                System.out.println("\n계산기가 종료됩니다.");
                sc.close();
                return false;
            }
            else if(order.equals("record")){ //getter 사용 - 기록 확인
                String[] record = calc.getRecord();
                if(record.length == 0) System.out.println("\n기록이 없습니다.");
                else {
                    System.out.println("\n이전 기록");
                    for (int i = 0; i < record.length; i++) {
                        System.out.println("Record " + (i + 1) + " : " + record[i]);
                    }
                }
            }
            else if(order.equals("delete")){ //삭제 메소드 활용
                boolean isDel = calc.deleteRecord();
                if(isDel) System.out.println("\n최근 기록 1개가 제거되었습니다.");
                else System.out.println("\n제거할 기록이 없습니다.");
            }
            else return true;
        }
    }
    public static void main(String[] args){
        Calculator calc = new Calculator(); //연산 클래스 호출
        Scanner sc = new Scanner(System.in); //스캐너 호출
        boolean flag = true;

        System.out.println("Calculator");
        while(flag) { //연산 반복
            System.out.println("0 이상의 정수 1개를 입력하세요.");
            try { //정수가 아닌 다른 수 입력 시 예외처리
                long x = sc.nextLong();
                if(x < 0) throw new Exception();
                System.out.println("'+', '-', '*', '/' 중 하나의 연산자를 입력하세요.");

                char operate = sc.next().charAt(0);
                if(operate == '+' || operate == '-'|| operate == '*' || operate == '/') { //연산자가 아닌 다른 문자 입력 시 예외처리
                    System.out.println("0 이상의 정수 1개를 입력하세요.");
                    long y = sc.nextLong();
                    if(y < 0) throw new Exception();
                    if (operate == '/' && y == 0) System.out.println("0은 분모가 될 수 없습니다."); //분모 0인경우 예외처리
                    else {
                        System.out.println("연산 결과: " + calc.calculate(x, y, operate)); //연산 출력, setter 사용
                    }
                }
                else System.out.println("올바른 연산자를 입력해주세요.");

                flag = Display(sc, calc); //후속 행동 위한 출력

            } catch(InputMismatchException e){ //잘못 입력 시 에러 메시지 출력, 초기화
                System.out.println("입력된 값은 0 이상의 정수가 아닙니다.");
                sc = new Scanner(System.in);
            } catch(Exception e){
                System.out.println("정수는 0 이상이어야 합니다.");
            }
        }
    }
}
