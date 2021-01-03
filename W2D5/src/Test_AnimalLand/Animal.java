package Test_AnimalLand;

public class Animal {
    String name;
    //상수는 enum을 쓰면 편합니다.
    //성별쓰는데 문자열 쓰면 이상한 값(성별이 Star에요!같은거)을 받는 사태가 벌어질 수 있으므로
    //gender는 지정된 값만 받게 할 겁니다. 이제 Animal.Gender.Male(0), Female(1)의 값으로 표현됩니다.
    public enum Gender{Male,Female    }
    public Gender gender; //그래서 이제 gender는 Gender형을 받습니다!


    public void move(){}//'공통된 부분은 부모 클래스에서 정의한다' -> S원칙과 I원칙!
    public void eat(){System.out.println("냠냠");}//'마찬가지'
    public void eat(Animal animal){System.out.println(this.name+"가"+animal.name+"을 냠냠");}//'다른 동물을 먹는거'
    public void displayInfo(){ //공통된 부분은 부모 클래스에서 정의한다!
        System.out.println(this.name+"\n");
        //공통되지만 자식 클래스마다 다른 부분은 부모 클래스에서 선언하고 자식 클래스에서 정의한다!
        //따라서 이를 위해 자식 클래스도 모두 동일한 부분과
        //자식 클래스끼리는 다른 부분은 메서드를 쪼개서 책임소재를 명확히 할 수 있음
        //모든 클래스는 하나만 책임진다 + 모든 책임은 각각 하나의 클래스에게만 주어진다 => 책임과 클래스의 일대일 대응
        displayAdditionalInfo();
    }
    //자식마다 다른 부분은 선언만 하고 끝
    protected void displayAdditionalInfo(){}
}
