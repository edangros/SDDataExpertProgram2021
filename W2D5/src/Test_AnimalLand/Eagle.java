package Test_AnimalLand;

public class Eagle extends Animal{

    public Eagle() {
        this.name = "Eagle";
        this.gender = Gender.Male; //이렇게 가능!
    }

    @Override
    public void move() {
        fly();
    }
    public void fly() { System.out.println("독수리가 날아갑니다");}
    @Override
    //자식 클래스끼리 공통되지 않은 부분만 분리해서 구현. 상위인 displayInfo는 건드리지 않음.
    //굳이 메서드 하나 더 만들지 말고 super()를 사용해도 되긴 함
    protected void displayAdditionalInfo() {
        System.out.println("겁나 큰 맹금류입니다.");
    }
}
