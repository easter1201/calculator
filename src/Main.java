import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculator");
        System.out.println("양의 정수 2개를 순차적으로 입력하세요.");

        long x = sc.nextLong();
        char operate = sc.next().charAt(0);
        long y = sc.nextLong();

        switch(operate){
            case '+':
                System.out.println(x + y);
                break;
            case '-':
                System.out.println(x - y);
                break;
            case '*':
                System.out.println(x * y);
                break;
            case '/':
                System.out.println(x / y);
                break;
        }
    }
}