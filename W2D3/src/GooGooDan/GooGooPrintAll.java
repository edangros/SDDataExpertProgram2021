package GooGooDan;


/**
 * 모든 구구단을 출력하는 프로그램
 */
public class GooGooPrintAll {
    public static void main(String[] args){
        System.out.print("||\t");//줄시작
        for(int j=2;j<10;j++){//첫줄
            System.out.printf("\t%d단\t\t||\t",j);
        }
        System.out.println();//줄바꿈
        for(int i=2;i<10;i++){//세로줄
            System.out.print("||\t");//줄시작
            for(int j=2;j<10;j++){//가로줄
                System.out.printf("%d\tX %d\t=%d\t||\t",i,j,i*j);
            }
            System.out.println();//줄바꿈
        }

    }
}
