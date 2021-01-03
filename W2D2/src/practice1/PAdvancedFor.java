package practice1;

public class PAdvancedFor {
    //For는 전통적인 증감식 버전(PrimeChecker 참조)뿐만 아니라 파이썬 For처럼 쓸 수도 있습니다.
    //비교적 최근(이라지만 몇년 전)에 생긴 기능입니다. 예전에 제가 자바쓸때는 안되었던걸로 기억...
    //다른 언어들(C#등)에서는 'Foreach'라고도 부릅니다. 참고만 하세요
    public static void main(String[] args){

        String[] names = {"James", "Ryan", "Alice", "Jean", "Lily"}; //'배열'이라 부릅니다.
        //리스트랑 같으면서도 많이 달라요. 다르기는 아주 많이 다릅니다.

        //문자열 배열 내의 각 항목을 순회하며 실행
        for(String name : names){ //파이썬으로 치면 for name in names
            System.out.println("Hello, "+name);
        }

    }

}

// 왜 똑같은 기능인데도 for문 모양이 저렇게 차이가 크냐면
// 파이썬의 조상은 smalltalk라고 불리던 객체지향을 위한 시험용 언어였고
// 자바는 주류인 C -> C++의 자손격입니다.
// C계열 언어 특징이 개행문자 ;랑 괄호 {}를 여기저기 많이 씁니다. in같은 영어단어 대신 기호를 많이 쓰고요.
// (C계열 언어 중 자바면 상당히 사람말에 가까운 언어입니다)
// 대단한 건 없고 그냥 그런 차이에요.