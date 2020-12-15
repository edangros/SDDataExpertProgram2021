package practice1;

public class Hello {
    public static int sum(int  n, int m){
        return n+m;
    }

    //main 메소드에 대한 내용은 Main.java 파일을 보시면 도비니다
    public static void main(String[] args){
        int i = 20;
        int s;
        char a;

        //괄호 내부 선언
        s = sum(i, 10);

        //개행문자 ; 가 있는만큼 한줄에 여러개 같이써도 됩니다. 은근히 코드흐름 잘보이게 할 수도 있음
        //다시말해 자바 코드에서 엔터키는 아무런 의미가 없습니다. 원한다면 1000줄짜리 프로그램을 한 줄로 적을수도 있습니다(...)
        a = '?'; System.out.println(a);
        System.out.println("Hello");
        System.out.println(s);
    }

    //'public'은 '이 클래스 밖 어디서건 이 개체(클래스, 메서드)에 접속 가능하다'를 의미합니다.
    //프로그램은 이 클래스 밖이므로 프로그램에서 '실행'을 시키려면 클래스는 public일 겁니다.
    //클래스 밖에서 접속하지 못하게 제한하는건 private입니다
    //'static'은 왜 붙을까요?
    //'정적 클래스'라고 부릅니다. 정적 클래스/메서드는 프로그램 시작시에 바로 메모리에 로드됩니다.
    //프로그램 시작시에 로드된 것이므로 프로그램 끝날 때까지 프로그램 전체에 오로지 한 개만 존재하며
    //모든 인스턴스가 하나의 값을 공유합니다.
    //ex : public class A의 맴버변수 public static int a와 public int b가 있다면
    //      두 인스턴스 aa와 bb에서 aa.a는 bb.a와 같음. 하나를 바꾸면 반대쪽도 같이 바뀜
    //      aa.b와 bb.b는 다름(클래스의 인스턴스가 생성될 때 만들어짐)
    //'정적 클래스'는 이것이 자바다 책 중간쯤에 나오는 '싱글톤'과 비슷하면서도 다릅니다. - 참고
}
