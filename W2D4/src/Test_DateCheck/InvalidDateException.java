package Test_DateCheck;
//날짜가 잘못되었음을 알리는 InvalidDayException이라는 에러를 만듭니다.
public class InvalidDateException extends Exception {
    //String errorMessage => 에러가 발생하면 띄울 날짜
    public InvalidDateException(String errorMessage) {
        super(errorMessage);
    }
    //This를 이렇게도 사용할 수 있습니다. (생성자를 다양한 종류로 받음)
    public InvalidDateException(int pDay, int pMonth, int pYear){
        //문자열을 만들어 문자열 인자 생성자를 다시 호출
        this(String.format("%d년 %d월 %d일은 잘못된 날짜입니다",pYear,pMonth,pDay));
    }
}