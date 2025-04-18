package Lv3;

import java.util.*;

public class App {
    public static boolean DisplayMenu(Scanner sc, ArithmeticCalculator calc){ //결과 이후 출력
        while(true){
            System.out.println("\n종료를 원한다면 'exit'을, 기록을 보고싶다면 'record'를, 기록 삭제를 원한다면 'delete'를,\n이전 결과에서 특정 값 이상의 결과만 찾고 싶다면 'search'를, 추가 계산을 원한다면 아무 키나 입력하세요.");
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
            else if(order.equals("search")){
                System.out.println("\n기준값을 입력해 주세요.");
                double searchOrder = sc.nextDouble();

                List<String> searchedValue = calc.searchRecord(searchOrder);

                System.out.println("\n기준값 "+ searchOrder + "보다 결과값이 큰 계산");
                if(searchedValue.size() != 0) {
                    for (String value : searchedValue) {
                        System.out.println(value);
                    }
                }
                else System.out.println("*조건에 맞는 기록이 없습니다.*");
            }
            else return true;
        }
    }

    public static void main(String[] args) {
        OperatorType calc = null;
        Scanner sc = new Scanner(System.in); //스캐너 호출
        ArithmeticCalculator<Double> ac = new ArithmeticCalculator<>();
        boolean flag = true;

        System.out.println("Calculator");
        while (flag) { //연산 반복
            System.out.println("0 이상의 정수 1개를 입력하세요.");

            try{
                double x = sc.nextDouble();

                char operate = ' ';
                while(true) {
                    System.out.println("'+', '-', '*', '/' 중 하나의 연산자를 입력하세요.");
                    operate = sc.next().charAt(0);
                    calc = OperatorType.checkOperator(operate);
                    if(calc == null) System.out.println("올바른 연산자를 입력해주세요.");
                    else break;
                }

                System.out.println("0 이상의 정수 1개를 입력하세요.");
                double y = sc.nextDouble();

                String result = ac.calculate(x, y, operate);

                System.out.println("연산 결과: " + result);

                flag = DisplayMenu(sc, ac);

            } catch(ArithmeticException ae){
                System.out.println("0은 분모가 될 수 없습니다.");
            }catch(Exception e){ //잘못 입력 시 에러 메시지 출력, 초기화
                System.out.println("잘못된 입력입니다.");
                sc = new Scanner(System.in);
            }
        }
    }
}
