package LittleBitAdvancedGame;

public class Weapon_Arrow extends Weapon{
    Weapon_Bow bow;
    //화살은 자신을 쏜 활의 레퍼런스를 들고 있어야 합니다.
    public Weapon_Arrow(String pName, int pDamage, int pAttSpeed) {
        super(pName, pDamage, pAttSpeed);
    }
    public void setBow(Weapon_Bow bow){
        this.bow = bow;
    }

    @Override
    public void attack(Monster target) {
        //화살의 공격 코드는 칼과 비슷하지만, 활의 효과를 추가로 가져옵니다.
        //몬스터의 체력을 깎습니다.
        int damage = Math.max((this.damage+bow.damage - target.armor), 0);//화살을 쏜 활의 데미지를 추가로 가져옴!
        target.damaged(damage);//방어력이 더 높을 경우 힐링되는 사태를 막기 위해 데미지를 0으로 바꿉니다.
        System.out.printf("%s로 %s에게 %d의 데미지를 가했다! 대상의 현재 체력은 %d이다\n",
                this.name,target.name,damage,target.getCurrHp());
    }
}
