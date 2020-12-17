package LittleBitAdvancedGame;

//몬스터 클래스입니다.
public class Monster {
    //지금은 고기방패입니다. 체력과 방어력만 있습니다.
    public int hp, armor;
    public final String name;

    //부활을 하려면 현재 체력과 최대 체력을 구분해야겠네요?
    protected int currHp;//최대 체력 변수 생성

    //생성자
    public Monster(String pName, int pHp, int pArmor){
        name = pName;
        hp = pHp;
        armor = pArmor;
        currHp = hp;
    }

    //데미지를 이제 함수로 받읍시다. 일종의 Setter입니다.
    public void damaged(int damage){
        this.currHp -= damage;
        onDamaged(damage);
    }

    //데미지를 받는 '이벤트'입니다. damaged와 쪼갠 이유가 있어요. 나아아아중에 씁니다.
    //궁굼하면 '옵저버 패턴' 검색
    public void onDamaged(int damage){
        System.out.println(this.name + " : 아야!");
    }

    //getter도 만듭시다.
    public int getCurrHp(){
        return currHp;
    }
}
