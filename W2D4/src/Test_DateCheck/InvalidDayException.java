package Test_DateCheck;
//날짜가 잘못되었음을 알리는 InvalidDayException이라는 에러를 만듭니다.
public class InvalidDayException extends Exception {
    //String errorMessage => 에러가 발생하면 띄울 날짜
    public InvalidDayException(String errorMessage) {
        super(errorMessage);
    }
}