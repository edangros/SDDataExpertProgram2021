package practice1;

import java.util.Scanner;

public class PTime {
    public static void main(String[] args){
        System.out.println("초단위 시간을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); // 문자열 읽기
        int sec = num % 60;
        int min = num % (60*60) / 60;
        int hour = num % (60*60*60) / (60*60);
        int day = num % (60*60*60*24) / (60*60*60);
        System.out.printf("%d일 %d시간 %d분 %d초\n",day,hour,min,sec);
    }
}
