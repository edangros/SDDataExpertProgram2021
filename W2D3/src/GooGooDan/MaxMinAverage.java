package GooGooDan;
import java.util.Scanner;
/**
 * 배열에 수를 입력받아 최댓값, 최솟값, 평균값을 입력받는 프로그램
 */
public class MaxMinAverage {
    public static void main(String[] args){
        //자바는 띄어쓰기도 많은 부분을 무시합니다. 꼭 서로 구분해야 하는 곳만 구분해요
        Scanner scanner = new Scanner (System.in);

        int[] intArray = new int[5];
        int max = 0, min = 0, sum = 0; //한줄에 여러 변수 선언법
        double ava;
        System.out.println("숫자 5개를 입력해주세요");
        for(int i=0;i<intArray.length;i++){
            intArray[i] = scanner.nextInt();
            //MAX 변경
            if(intArray[i]>max){max = intArray[i];}
            //MIN 변경
            if(intArray[i]<min){min = intArray[i];}
            //SUM 변경
            sum += intArray[i];
        }
        //AVA 계산
        ava = sum*(1.0/intArray.length); //(명시적 형변환 외에도 1.0을 이용해 강제 형변환 가능)

        System.out.printf("MAX:%d MIN:%d AVA:%.2f\n",max,min,ava);
    }
}
