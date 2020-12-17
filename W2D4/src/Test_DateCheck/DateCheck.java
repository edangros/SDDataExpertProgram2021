package Test_DateCheck;

public class DateCheck {
    private int day, month, year;
    //'throws' -> 어떤 에러가 발생했을 때, 이 메서드를 실행한 코드에 에러가 발생했음을 알립니다.
    //이 경우 try-catch 구문을 통해 에러를 잡을 수 있습니다.
    DateCheck(int pDay, int pMonth, int pYear) throws InvalidDateException {
        this.day = pDay;
        this.month = pMonth;
        this.year = pYear;
        if(!isValidDate()){throw invalidDateException();}//잘못되었으면 에러를 던집니다.
    }

    //에러메세지를 설정해서 에러를 반환하는 메서드입니다. 내가 에러메세지를 생성해서 제출하는 거니 굳이 public일 이유가 없습니다.
    //밖에서 쓰지 않을 모든 것은 private로 해놓는게 바람직합니다.
    //(여러개가 필요없는 개체는 '싱글톤 패턴'이나 static으로 정의하는게 바람직)
    //(밖에서 쓰지 않을 모든 것은 private로 해놓는게 바람직)
    private InvalidDateException invalidDateException(){
        //에러메세지에 설정하려 했던 날짜를 집어넣어 출력합니다.
        return new InvalidDateException(String.format("%d년 %d월 %d일은 잘못된 날짜입니다",this.year,this.month,this.day));
    }

    public Boolean isValidDate(){
        if((this.month>12)){return false;}//'달'은 12 이하여야 함
        if((this.day<0)||(this.month<0)){return false;}//'일'과 '달'은 무조건 양수여야 함
        switch(month){
            //2월 검사는 2페이즈 (윤년 or not)
            case 2:
                //윤년은 4로 나누어지지만 100으로 나누어떨어지지 않는 해, 또는 400으로 나누어떨어지는 해.
                if(((year%4==0)&&(year%100!=0))||(year%400==0)){return !(this.day>29);}
                //아니면 28일까지만
                else{return !(this.day>28);}
            //31일까지 있는 달인가
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return !(this.day>31);
            //30일까지 있는 달인가
            case 4: case 6: case 9: case 11:
                return !(this.day>30);
            default:
                return false;
        }

    }

    //getter setter는 이런식으로 사용이 가능합니다. 괜히 코드만 길어지는 뻘짓이 아니에요.
    //getter가 실행되면 이 개체의 성분을 가져갔다고 표시
    public int getDay() {
        System.out.println(this.hashCode()+": get day");
        return day;
    }

    //setter도 내용을 표시하는데 끝나기 전에 올바른 날짜인지 확인하여 올바르지 않다면 에러 떨구기
    public void setDay(int pDay) throws InvalidDateException {
        System.out.println(this.hashCode()+": set day as "+pDay);
        this.day = pDay;
        if(!isValidDate()){throw invalidDateException();}//잘못되었으면 에러를 던집니다.
    }

    public int getMonth() {
        System.out.println(this.hashCode()+": get month");
        return month;
    }

    public void setMonth(int pMonth) throws InvalidDateException {
        System.out.println(this.hashCode()+": set month as "+pMonth);
        this.month = pMonth;
        if(!isValidDate()){throw invalidDateException();}//잘못되었으면 에러를 던집니다.
    }

    public int getYear() {
        System.out.println(this.hashCode()+": get year");
        return year;
    }

    public void setYear(int pYear) throws InvalidDateException {
        System.out.println(this.hashCode()+": set year as "+pYear);
        this.year = pYear;
        if(!isValidDate()){throw invalidDateException();}//잘못되었으면 에러를 던집니다.
    }


    //위에서 보이듯이, getter setter가 만들어지면 추후 확장(저기서 에러 떨구고, print하고...)이 매우 용이해집니다.
    //만약 public 변수로 선언하였다면, 나중에 이 변수의 변경이나 출력을 추적하는 코드가 필요해졌을 때,
    //해당 public 변수와 관련된 모든 부분을 getter setter로 수정해야 합니다.
    //하지만 처음부터 약간의 수고(마우스 오른클릭 -> getter/setter 생성)만 해둔다면 이후 다른 코드는 한줄도 안바꿔도
    //이 클래스 파일에서만 getter setter를 조금 수정하면 기능의 추가/변경이 매우 용이해집니다.
    //이렇게, 외부 코드를 변경할 필요 없이, 자기 자신만 수정해서 기능을 조정할 수 있게 하는게 캡슐화의 장점이며
    //인터페이스와 함께
    //'SOLID' 원칙의 O원칙(OCP, Open-Close Principle, 개방-폐쇄의 원칙)을 구현하는 부분입니다.

    //====개방 폐쇄의 법칙===
    //클래스는 변경에 대해서는 열려있고 수정에 대해서는 닫혀 있어야 한다.
    //=>클래스는 확장(기능의 변경, 추가)에 용이하게 설계되어야 하고
    //   그 때 클래스 바깥에서 클래스를 사용하는 기존 코드는 수정되지 않아야 한다.
    //=>내가 클래스를 고치고 싶으면 클래스만 고치고 다른데는 손댈 필요가 없게 설계단계에서 똑바로 설계하자

    //객체 지향형 프로그래밍에서 '객체간의 연결을 느슨하게 하는 것'은 매우 중요한 부분입니다.
    //시간나면 '객체지향 프로그래밍의 5원칙'(SOLID원칙)에 대해서 찾아보세요.


    //메소드 오버라이딩으로 toString을 갱신합니다.
    //...?? 이거 상속받은 클래스가 없는데요?
    //모든 클래스는 Class를 상속받고, Class는 Object를 상속받습니다 toString은 Class에 들어있는 메서드입니다.
    //문자열로 형변환이 일어날 때 어떤 문자열을 반환할지를 결정합니다.
    @Override
    public String toString() {
        return (this.hashCode() +
                "DateCheck{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}');
    }
}
