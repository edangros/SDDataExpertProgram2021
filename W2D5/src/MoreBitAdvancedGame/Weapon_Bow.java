package MoreBitAdvancedGame;

public class Weapon_Bow extends Weapon {
    Weapon_Arrow arrow;//활은 화살이 있어야죠
    public Weapon_Bow(String pName, int pDamage, int pAttSpeed) {
        super(pName, pDamage, pAttSpeed);
    }

    @Override
    public void attack(Character target) {
        //활은 자신이 공격하는 게 아니라 화살이 공격합니다.
        System.out.println(this.name + "에서 "+this.arrow.name +"을 발사하였다!");
        this.arrow.attack(target);
    }

    //활은 데미지 리턴할때 화살도 고려!
    @Override
    public int getDamage(){
        return this.damage+this.arrow.damage;
    }
}
