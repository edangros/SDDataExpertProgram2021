package Test_AnimalLand;

public class Fish extends Animal{

    public Fish() {
        this.name = "Fish";
        this.gender = Gender.Female; //이렇게 가능!
    }

    @Override
    public void move() {
        swim();
    }
    public void swim() { System.out.println("물고기가 헤업칩니다");}
    @Override
    //자식 클래스끼리 공통되지 않은 부분만 분리해서 구현. 상위인 displayInfo는 건드리지 않음.
    //굳이 메서드 하나 더 만들지 말고 super()를 사용해도 되긴 함
    protected void displayAdditionalInfo() {
        System.out.println("종을 알 수 없는 물고기입니다");
    }
}
