package Test_DateCheck;

public class DateCheck {
    private int day, month, year;
    //'throws' -> 어떤 에러가 발생했을 때, 이 메서드를 실행한 코드에 에러가 발생했음을 알립니다.
    //이 경우 try-catch 구문을 통해 에러를 잡을 수 있습니다.
    DateCheck(int pDay, int pMonth, int pYear) throws InvalidDateException {
        this.day = pDay;
        this.month = pMonth;
        this.year = pYear;
        // 잘못되었으면 에러를 던집니다.
        // 아직 내가 초기화되었는제 불명확하...진 않지만(바로 위에서 초기화함) 어쨌든 안전하게 멤버변수 대신 인수를 그대로 넙깁니다.
        if(!isValidDate()){throw invalidDateException(pDay, pMonth, pYear);}
    }

    //에러메세지를 설정해서 에러를 반환하는 메서드입니다. 내가 에러메세지를 생성해서 제출하는 거니 굳이 public일 이유가 없습니다.
    //밖에서 쓰지 않을 모든 것은 private로 해놓는게 바람직합니다.
    private InvalidDateException invalidDateException(){
        //에러메세지에 설정하려 했던 날짜를 집어넣어 출력합니다.
        return new InvalidDateException(String.format("%d년 %d월 %d일은 잘못된 날짜입니다",this.year,this.month,this.day));
    }
    private InvalidDateException invalidDateException(int pDay, int pMonth, int pYear){
        //날짜 기반으로 에러를 발생시킵니다.
        return new InvalidDateException(pDay, pMonth, pYear);
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

    @Override
    public String toString() {
        return String.format("%d년 %d월 %d일",this.year,this.month,this.day);
    }

    public void showDate(){
        System.out.println(this);
    }
}
