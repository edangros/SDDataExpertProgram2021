package MoreBitAdvancedGame;

public class Weapon_Arrow_Poison extends Weapon_Arrow {
    StatusEffect_Poison statusEffect;
    //화살은 자신을 쏜 활의 레퍼런스를 들고 있어야 합니다.
    public Weapon_Arrow_Poison(String pName, int pDamage, int pAttSpeed,int pPoisonStrength) {
        super(pName, pDamage, pAttSpeed);
        this.statusEffect = new StatusEffect_Poison(pPoisonStrength);
    }
    @Override
    public void attack(Character target) {
        //대상의 독 중첩수를 검사해 3번이 안된다면 독효과를 부여합니다.
        if(target.countStatusEffect(this.statusEffect)>3){target.registerStatusEffect(this.statusEffect);}
        //나머지 시행
        super.attack(target);
    }
}
