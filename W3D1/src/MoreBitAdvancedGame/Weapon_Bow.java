package MoreBitAdvancedGame;

public class Weapon_Bow extends Weapon {
    public Weapon_Bow(String pName, int pDamage, int pAttSpeed) {
        super(pName, pDamage, pAttSpeed);
        this.addElemental(Element.BOW);
    }

    @Override
    public void attack(Character target, Player attacker) {
        //화살을 들고 있는지 검사합니다.
        if(attacker.subWeaponId != null){
            Weapon arrow = GameDataManager.getInstance().getWeapon(attacker.subWeaponId);
            if(arrow.hasElemental(Element.PROJECTILE)){
                //활은 자신이 공격하는 게 아니라 화살이 공격합니다.
                System.out.println(this.name + "에서 "+arrow.name +"을 발사하였다!");
                arrow.attack(target,attacker);
            }
        }
        //공격 실패
        System.out.printf("%s가 %s로 %s를 공격하려 했지만 화살이 없다!\n",
                attacker.getName(), this.name,target.getName(),damage,target.getHp());
    }

}
