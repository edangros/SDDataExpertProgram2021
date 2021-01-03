package MoreBitAdvancedGame;

public class Weapon_Arrow extends Weapon{
    Weapon_Bow bow;
    //화살은 자신을 쏜 활의 레퍼런스를 들고 있어야 합니다.
    public Weapon_Arrow(String pName, int pDamage, int pAttSpeed) {
        super(pName, pDamage, pAttSpeed);
        this.addElemental(Element.PROJECTILE);
    }
    public void setBow(Weapon_Bow bow){
        this.bow = bow;
    }

    @Override
    public void attack(Character target, Player attacker) {
        int damage = target.hitThis(attacker.getDamage() - target.getArmor());//심플해진 공격처리
        System.out.printf("%s가 %s로 %s에게 %d의 데미지를 가했다! 대상의 현재 체력은 %d이다\n",
                attacker.getName(), this.name,target.getName(),damage,target.getHp());
    }
}
