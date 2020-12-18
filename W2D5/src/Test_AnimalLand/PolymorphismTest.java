package Test_AnimalLand;

public class PolymorphismTest {
    public static void main(String[] args){
        Animal aHuman = new Human();
        Animal aLion = new Lion();
        Animal aEagle = new Eagle();
        Animal aFish = new Fish();

        //PolymorphismTes polyTest = new PolymorphismTest(); ->안좋은 습관. 프로그램 전체에 하나밖에 없을 개체를 싱글톤도 없이 인스턴스화
        //예재니까 그냥 썼던 거라고 생각하면 되고, animalMove는 PolymorphismTest가 특정 인스턴스냐에 영향받지 않으므로 여기서는 static이 바람직
        //Static의 단점은 프로그램 시작부터 끝까지 메모리에 상주한다는 건데, 어차피 이 클래스는 메인 클래스라 프로그램 로드되면 로드되어서
        //프로그램 끝날때까지 메모리에 남아있음. 태생적으로.
        animalMove(aHuman);
        animalMove(aLion);
        animalMove(aEagle);
        animalMove(aFish);
        aEagle.eat(aFish);
        aLion.eat(aHuman);
        //어거지로 Human.speak를 실행시키자
        ((Human)aHuman).speak();
        //객체지향 L원칙에 매우 좋지 않음. aHuman은 Human이 아니라 Animal이었고,
        //aHuman에는 원래 Animal 자식개체는 아무거나 와도 작동을 보장해야 하지만 이제 무조건 aHuman만 받을 수 있음.
        //이럴거면 처음부터 자료형을 aHuman으로 주었어야 함. 강제 형변환은 없는 기능이다 생각하고 안쓸 정도가 가장 이상적.
        //하지만 세상은 이상적으로 돌아가지 않으니, '타입이 명확한 경우' 또는 '에러가 나도 상관없을 경우' 사용하면 되는 패턴...
        //(당장 유명 게임엔진 유니티에서도 밥먹듯이 형변환해야할 일이 많음. 유니티의 구조 자체가 심각하게 느슨한 영향...)
    }

    public static void animalMove(Animal a){
        a.move();
    }
}
