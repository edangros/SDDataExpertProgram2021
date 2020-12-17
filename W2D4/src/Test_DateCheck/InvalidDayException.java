package Test_DateCheck;
//날짜가 잘못되었음을 알리는 InvalidDayException이라는 에러를 만듭니다.
public class InvalidDayException extends Exception {
    public InvalidDayException(String errorMessage) {
        super(errorMessage);
    }
}