package practice1;

import java.util.Scanner;
public class PIf {
    public static void main(String[] args) {
        char grade;
        Scanner scanner = new Scanner(System.in);
        System.out.print("점수를 입력하세요(0~100): ");
        int score = scanner.nextInt(); // 점수 읽기
        if(score >= 90){ grade = 'A';} // 괄호를 넣어줄 수 있습니다. 저는 이 패턴을 선호함...
        else if(score >= 80) { grade = 'B';} //자바는 엔터를 생각 안하니 이렇게 한줄로 붙일 수 있고
        else if(score >= 70) { grade = 'C';} //엔터 잔뜩 들어갔을 때보다 훨씬 깔끔해보이죠?
        else if(score >= 60) { grade = 'D';} //물론 이것도 취향 탑니다
        else {grade = 'F';}
        //프로그래머 유머 중에는 저기 main줄 옆에 괄호를 그 줄에 적냐 다음줄에 적냐로 싸우는것도 있어요
        //탕수육 부먹찍먹처럼요(둘다 어차피 잘 돌아감)
        System.out.println("학점은 "+ grade + "입니다.");
        scanner.close();
    }
}
