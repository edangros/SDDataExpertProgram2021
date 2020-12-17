package LittleBitAdvancedGame;

public class Weapon_Sword extends Weapon{
    public Weapon_Sword(String pName, int pDamage, int pAttSpeed) {
        super(pName, pDamage, pAttSpeed);
    }

    @Override
    public void attack(Monster target) {
        //몬스터의 체력을 깎습니다. 방어력이 더 높을 경우 힐링되는 사태를 막기 위해 데미지를 0으로 바꿉니다.
        int damage = Math.max((this.damage - target.armor), 0);
        target.damaged(damage);
        //객체는 '참조 방식'으로 전달되어서 여기서 target의 체력을 변경하면 인자를 넘겨준 그 몬스터 체력이 감소한다.
        System.out.printf("%s로 %s에게 %d의 데미지를 가했다! 대상의 현재 체력은 %d이다\n",
                this.name,target.name,damage,target.getCurrHp());
    }
}
