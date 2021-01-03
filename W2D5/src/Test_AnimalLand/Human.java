package Test_AnimalLand;

public class Human extends Animal{

    public Human() {
        this.name = "Human";
        this.gender = Animal.Gender.Male; //이렇게 가능!
    }

    @Override
    public void move() {
        System.out.println("사람이 걸어갑니다");
    }

    public void speak(){
        System.out.println("사람이 말합니다");
    }
    @Override
    //자식 클래스끼리 공통되지 않은 부분만 분리해서 구현. 상위인 displayInfo는 건드리지 않음.
    //굳이 메서드 하나 더 만들지 말고 super()를 사용해도 되긴 함
    protected void displayAdditionalInfo() {
        System.out.println("호모 사피엔스. 사람입니다.");
    }
}
