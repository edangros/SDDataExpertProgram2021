package Test_DateCheck;

public class DateTest {
    public static void main(String[] args){
        DateCheck date;
        //일반적인 환경이면 이 메서드 자체가 InvalidDayException을 떨구는게 맞겠지만... 클래스 테스트를 위해서 try-catch 도배
        try{
           date = new DateCheck(45,2,2000);
        }
        catch (InvalidDayException e) {
            e.printStackTrace();
        }
        try {
            date = new DateCheck(15,3,2000);
            date.setDay(25);
            date.setMonth((12));
            date.setYear((2015));
            date.setDay(30);
            System.out.println(date);//오버라이딩했던 문자열만드는 메서드 덕분에 이런게 가능
            date.setMonth(2);//여기서 에러 떠야함!
        } catch (InvalidDayException e) {
            e.printStackTrace();
        }
    }
}
