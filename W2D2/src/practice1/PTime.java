package practice1;

import java.util.Scanner;

public class PTime {
    public static void main(String[] args){
        System.out.println("초단위 시간을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); // 문자열 읽기
        int sec = num % 60;//원리 : 60으로 나눈(분 이상을 다 자른) 나머지
        int min = num % (60*60) / 60;// 60곱하기 60으로 나눈 나머지(시간 이상을 다 자른)를 60으로(초 부분은 필요없으니) 나눈 몫
        int hour = num % (60*60*60) / (60*60);
        int day = num % (60*60*60*24) / (60*60*60);
        // 파이썬에서는 튜플을 썼지만 자바에서는 '가변 인자'라는 걸로 전달합니다.
        // printf 위에 마우스를 올리면 설명이 있을텐데 마지막에 Object....이라고 되어있을겁니다.
        // 이건 Object자리에 몇개가 오건 상관 없다는 이야기로, format 내에 들어갈 변수의 갯수는 몇개인지 모르므로
        // 원하는 만큼 집어넣을 수 있게 설계한 구조입니다.
        // 자바는 만든 사람이 printf를 이렇게 짰지만
        // 저기 main메서드에 쓰는 String[]처럼 배열 등의 구조로 받을수도 있습니다. 사람마다 취향타는 부분.
        System.out.printf("%d일 %d시간 %d분 %d초\n",day,hour,min,sec);
        scanner.close();
    }
}
