package Lv3;

import java.util.*;

public class App {
    public static void DecorateDisplay(String order){
        System.out.println("\n---------------------------------------");
        System.out.println(order);
        System.out.println("---------------------------------------");
    }

    public static void DecorateRecord(String[] record){
        System.out.println("\n----------------이전 기록----------------");
        for (String recordValue: record){
            System.out.println(recordValue);
        }
        System.out.println("---------------------------------------");
    }

    public static void DisplayTitle(){
        System.out.println("\n=======================================");
        System.out.println("              Calculator");
        System.out.print("=======================================");
    }

    public static void DecorateMenu(){
        System.out.println("\n===========명령어를 작성해주세요===========");
        System.out.println("계산기 종료 : 'exit'");
        System.out.println("전체 기록 조회 : 'record'");
        System.out.println("최근 기록 삭제 : 'delete'");
        System.out.println("기록 중 기준값 이상의 결과만 조회 : 'search'");
        System.out.println("추가 계산 : 그 외 아무 키");
        System.out.println("=======================================");
    }

    public static boolean DisplayMenu(Scanner sc, ArithmeticCalculator ac){           //결과 출력 이후 분기, 입력에 따른 출력 및 종료 구현
        while(true){
            DecorateMenu();
            String order = sc.nextLine();

            if(order.equals("exit")){                                                   //계산기 종료
                DecorateDisplay("계산기가 종료됩니다.");
                sc.close();
                return false;
            }
            else if(order.equals("record")){                                            //getter 사용 - 기록 확인
                String[] record = ac.getRecord();
                if(record.length == 0) DecorateDisplay("*기록이 없습니다.*");          //기록이 존재하지 않을 경우
                else DecorateRecord(record);                                            //기록이 존재할 경우 String 배열로 받아 순차적 작성
            }
            else if(order.equals("delete")){                                            //setter 사용 - 기록 삭제
                boolean isDel = ac.isDeleteRecord();                                      //삭제 여부 확인
                if(isDel) DecorateDisplay("최근 기록 1개가 제거되었습니다.");           //삭제 시
                else DecorateDisplay("*제거할 기록이 없습니다.*");                       //기록이 없어 삭제가 안 됐을 시
            }
            else if(order.equals("search")){                                            //검색 기능
                DecorateDisplay("기준값을 입력해 주세요.");
                double searchOrder = sc.nextDouble();                                   //기준값 입력

                List<String> searchedValue = ac.searchRecord(searchOrder);              //기준값에 따른 처리 후 리스트 반환

                DecorateDisplay("기준값 "+ searchOrder + "보다 결과값이 큰 계산");
                if(searchedValue.size() != 0) {                                         //리스트가 존재할 시
                    for (String value : searchedValue) {                                //향상된 for문 사용 - 순차적으로 계산 내용 출력
                        System.out.println(value);
                    }
                }                                                                       //리스트가 존재하지 않을 시
                else DecorateDisplay("*조건에 맞는 기록이 없습니다.*");
            }
            else {
                DecorateDisplay("추가 계산을 시작합니다.");
                return true;                                                           //아무 키나 입력 시 탈출
            }
        }
    }

    public static double readNumber(Scanner sc){                                       //2개 이상의 수 입력 시 무한반복
        while(true) {
            DecorateDisplay("숫자 1개를 입력하세요.");
            String[] input = sc.nextLine().split(" ");
            if (input.length > 1) DecorateDisplay("*숫자를 1개만 입력하세요.*");
            else return Double.parseDouble(input[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                                            //스캐너 호출
        ArithmeticCalculator<Double> ac = new ArithmeticCalculator<>();                 //계산 클래스 호출, 제네릭 사용
        boolean flag = true;                                                            //종료 여부 판별 위한 flag

        DisplayTitle();

        while (flag) {                                                                  //연산 반복

            try{
                double x = readNumber(sc);                                             //첫 번째 수 입력

                char operator = ' ';
                while(true) {                                                           //올바른 연산자 입력시까지 반복
                    DecorateDisplay("'+', '-', '*', '/' 중 하나의 연산자를 입력하세요.");
                    operator = sc.nextLine().charAt(0);
                    OperatorType ot = ac.searchOperator(operator);                      //연산자 확인
                    if(ot == null) DecorateDisplay("*올바른 연산자를 입력해주세요.*");  //올바른 연산자가 아닐 시
                    else break;                                                         //올바른 연산자일 때 탈출
                }

                double y = readNumber(sc);                                              //두 번째 수 입력

                String result = ac.calculate(x, y, operator);                            //연산

                DecorateDisplay("연산 결과: " + result);                            //연산 결과 출력

                flag = DisplayMenu(sc, ac);                                             //flag 사용해 계산기 종료 여부 판별

            } catch(ArithmeticException ae){                                            //0으로 나눌 시 예외처리
                DecorateDisplay("*0은 분모가 될 수 없습니다. 연산을 처음부터 다시 시작합니다.*");
            }catch(Exception e){                                                        //잘못 입력 시 에러 메시지 출력, 초기화
                DecorateDisplay("*잘못된 입력입니다. 연산을 처음부터 다시 시작합니다.*");
                sc = new Scanner(System.in);
            }
        }
    }
}
