package GooGooDan;

import java.util.Scanner;
/**
 * 입력을 받아 해당 단을 출력하는 구구단 프로그램
 */
public class GooGooInput {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num1;
        System.out.print("구구단을 보고자 하는 숫자를 입력하세요 :");
        while (true){
            num1 = scanner.nextInt();
            System.out.println();//줄바꿈
            if ((num1==1)||(num1>=10)){
                System.out.print("2-9사이 숫자를 입력하세요 :");
            }
            else {
                System.out.println();//줄바꿈
                break;
            }
        }
        System.out.printf("%d단\n",num1);
        for(int i=2;i<10;i++){
            System.out.printf("%d\tX %d\t=%d\n",num1,i,num1*i);
        }

    }
}
