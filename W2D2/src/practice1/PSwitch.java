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
        switch (score/10){//결과값은 0-10이 되겠네?
            case 10:
            case 9:
            case 8:
                s = "A";
                break;
            case 7: case 6: case 5: //엔터키를 고려하지 않으니 이런 괴상한 일도 가능
                s = "B";
                break;
            case 4: case 3:
                s = "C";
                break;
            default:
                s = "D";
        }
        //파이썬이랑 똑같습니다. 문자열 포맷팅은 프로그래밍 언어랑 상관없이 거의 비슷합니다.
        //다만 자바에서는 모든 타입이 '명확할 것'을 요구하기 때문에 포맷된 문자열을 쓰겠다면 그에 맞는 메서드를 사용해야 합니다.
        //파이썬이 특이한거에요.
        //printf = 포맷된 문자열을 사용하겠다는 선언
        System.out.printf("학점은 %s 입니다\n", s); //파이썬에서는 print("학점은 %s 입니다\n"%s)
        //아래 코드도 동일한 일을 합니다.
        //String.format => 인수를 받아 포맷된 문자열을 반환
        //Println => 줄바꿈이 있는 출력
        System.out.println(String.format("학점은 %s 입니다",s)); //파이썬에서는 print("학점은 %s 입니다\n"%s)
        scanner.close();

        //삼항연산자를 쓰면 저 긴 게 한줄로 됩니다(????!)
        s = (score>=80)? "A": (score>=50)? "B": (score>=30)? "C":"D"; //if-else if 문과 같은 역할이긴...한데...
        System.out.println(String.format("학점은 %s 입니다",s));

    }
}
