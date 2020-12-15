package practice1;
import java.util.Scanner;
/**
 * Prime Number Checker (For문 예재)
 */
public class PrimeChecker {
    public static void main(String[] args){
        System.out.println("검사할 숫자를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        boolean res = true; //파이썬은 True, 자바는 true. 대문자 주의!!! (이것도 파이썬이 튀는거에요)

        /*아랫줄 for문은 이렇게 쪼개서 생각하면 쉬울... 수도 있어요
        int i=2;
        while (i<=(num-1)){
            i++;
            (기타등등)
        }
        서로 다른 줄에 들어가는 문장이라 줄바꿈기호 ;가 들어간다... 고 외우면 좀 이해가 될까
         */
        for(int i=2;i<=(num-1);i++){
            if(num%i==0){res = false;break;}
        }
        String output = res? "소수입니다":"소수가 아닙니다";
        System.out.println(num + "는"+output);

    }
}
