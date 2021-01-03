package MoreBitAdvancedGame;

//몬스터 클래스입니다.
public class Monster extends Character{


    //생성자
    public Monster(String pName, int pHp, int pArmor){
        super(pName,pHp,pArmor,0);//아직 데미지는 없어요
    }

    //데미지 입으면 '아야' 합시다
    @Override
    protected int onHit(int damage) {
        int res = super.onHit(damage);
        if(res >0){System.out.println(this.getName()+": 아야");}
        this.executeStatusEffects();//맞았을때 독 받아야지!
        return damage;
    }
}