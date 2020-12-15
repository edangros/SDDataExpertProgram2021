package com.w2d2;


//파이썬에서는 그냥 쳤던거지만 '객체 지향 언어'인 자바에서는 프로그램 메인도 클래스입니다
public class Main {
    //그리고 프로그램의 시작점은 메서드로 되어있습니다.
    //String[] args는 커멘드라인에서 프로그램 실행할때 붙여주는 내용입니다. GUI로 아이콘 클릭할 때는 왜 필요한지 모르겠지만
    //대표적으로 '연결 프로그램'으로 파일을 열 때를 생각하시면 되는데, 연결 프로그램을 실행시킬 때에는 아래와 같은 방식입니다.
    //abc.ppt를 파워포인트로 연다
    //cmdline에서는 powerpoint abc.ppt같은 식으로 실행시킴
    //그러면 powerpoint의 main 함수에 인자로 abc.ppt를 넘겨 실행
    //powerpoint는 main에 인자로 넘어온 파일명을 기반으로 프로그램을 실행시켜 파일을 열어 편집할 수 있게 함
    public static void main(String[] args) {
	// write your code here
        //The most well-known 'Hello World' code.
        System.out.println("Hello World");
    }
}
