package SimpleGame;

//몬스터 클래스입니다.
public class Monster {
    //지금은 고기방패입니다. 체력과 방어력만 있습니다.
    public int hp, armor;
    public final String name;
    //생성자
    public Monster(String pName, int pHp, int pArmor){
        name = pName;
        hp = pHp;
        armor = pArmor;
    }
}
