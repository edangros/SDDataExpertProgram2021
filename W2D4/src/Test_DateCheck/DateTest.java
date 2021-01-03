package Test_DateCheck;

public class DateTest {
    public static void main(String[] args){
        DateCheck date;
        //일반적인 환경이면 이 메서드 자체가 InvalidDayException을 떨구는게 맞겠지만... 클래스 테스트를 위해서 try-catch 도배
        try{
           date = new DateCheck(45,2,2000);//에러가 발생! 2000년 2월 45일은 없으니까
        }
        catch (InvalidDateException e) {
            e.printStackTrace();
        }
        try {
            date = new DateCheck(15,3,2000);//이번엔 정상실행되겠지
            date.showDate();
            date.setDay(25);
            date.setMonth((12));
            date.setYear((2015));
            date.setDay(30);
            //ToString을 override했기 때문에 DataCheck->String 자동 형변환이 일어나서 println에 바로 삽입 가능!
            System.out.println(date);
            date.setMonth(2);//여기서 에러 떠야함! (2월 30일은 잘못된 날짜니까!)
        } catch (InvalidDateException e) {
            e.printStackTrace();
        }
    }
}
