package Test_AnimalLand;

public class Lion extends Animal{

    public Lion() {
        this.name = "Lion";
        this.gender = Animal.Gender.Female; //이렇게 가능!
    }

    @Override
    public void move() {
        System.out.println("사자가 은밀하게 걸어갑니다");
    }

    @Override
    public void eat(Animal animal) {
        this.hunt(animal);
        super.eat(animal);
    }

    public void hunt(Animal animal){
        System.out.println("사자가 먹잇감 "+animal.name+"을 덮칩니다!");
    }
    @Override
    //자식 클래스끼리 공통되지 않은 부분만 분리해서 구현. 상위인 displayInfo는 건드리지 않음.
    //굳이 메서드 하나 더 만들지 말고 super()를 사용해도 되긴 함
    protected void displayAdditionalInfo() {
        System.out.println("암사자입니다.");
    }
}
