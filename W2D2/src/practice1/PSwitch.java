package practice1;

import java.util.Scanner;

public class PSwitch {
    public static void main(String[] args) {

        System.out.println("점수를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        String s;
        // 아래처럼도 됩니다. 안헷갈리는법은 간단합니다.
        // 자바는 탭이나 엔터키를 신경쓰지 않습니다.
        // 오로지 괄호랑 줄바꿈만 고려하고
        // case문 아래에서는 괄호를 쓰지 않으므로
        // case문 하위항목에서는 break를 만나 switch문을 빠져나가지 않는 한 그대로 아랫줄을 진행합니다.
        switch (score/10){
            case 10:
            case 9:
            case 8:
                s = "A";
                break;
            case 7:
            case 6:
            case 5:
                s = "B";
                break;
            case 4:
            case 3:
                s = "C";
                break;
            default:
                s = "D";
        }
        System.out.printf("학점은 %s 입니다%n", s);

    }
}
