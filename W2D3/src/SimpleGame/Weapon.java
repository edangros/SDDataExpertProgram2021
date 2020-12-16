package SimpleGame;

//무기를 다루는 클래스입니다.
public class Weapon {
    //무기는 공격력과 공격속도가 있겠네요
    public final int damage, attSpeed;
    //이름도 있고요
    public final String name;
    //생성하고 나면 바뀔 값이 아니니 final을 붙여 처음 정의되면 바뀌지 않게 했습니다.

    //생성자
    public Weapon(String pName, int pDamage, int pAttSpeed){
        damage = pDamage;
        attSpeed = pAttSpeed;
        name = pName;
    }

    //무기라면 공격할 수 있어야겠죠. 대상 몬스터를 타겟으로 받아옵니다.
    public void attack(Monster target){
        //몬스터의 체력을 깎습니다. 방어력이 더 높을 경우 힐링되는 사태를 막기 위해 데미지를 0으로 바꿉니다.
        int damage = Math.max((this.damage - target.armor), 0);
        target.hp -= damage;
        //객체는 '참조 방식'으로 전달되어서 여기서 target의 체력을 변경하면 인자를 넘겨준 그 몬스터 체력이 감소한다.
        System.out.printf("%s로 %s에게 %d의 데미지를 가했다! 대상의 현재 체력은 %d이다\n",
                this.name,target.name,damage,target.hp);
    }
}
