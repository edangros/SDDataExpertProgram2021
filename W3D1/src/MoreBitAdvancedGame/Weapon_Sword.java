package MoreBitAdvancedGame;

public class Weapon_Sword extends Weapon{
    public Weapon_Sword(String pName, int pDamage, int pAttSpeed) {
        super(pName, pDamage, pAttSpeed);
    }

    @Override
    public void attack(Character target, Player attacker) {
        target.hitThis(attacker.getDamage() - target.getArmor());//심플해진 공격처리
        System.out.printf("%s가 %s로 %s에게 %d의 데미지를 가했다! 대상의 현재 체력은 %d이다\n",
                attacker.getName(), this.name,target.getName(),damage,target.getHp());
    }
}
