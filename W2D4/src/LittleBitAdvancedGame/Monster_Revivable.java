package LittleBitAdvancedGame;

//부활 가능한 몬스터입니다.
public class Monster_Revivable extends Monster{
    int life;
    public Monster_Revivable(String pName, int pHp, int pArmor, int life) {
        super(pName, pHp, pArmor);
        this.life = life;
    }

    //onDamaged 이벤트를 재정의합니다.
    @Override
    public void onDamaged(int damage) {
        super.onDamaged(damage);
        //만약 라이프가 남았고 내가 죽었다면
        if((life>0)&&(this.currHp<=0)) {
            this.currHp = hp;//체력을 다시 복구(부활)
            this.life -= 1;//라이프도 1 감소
            System.out.println(this.name+"(이)가 부활하였다!");
        }
    }
}
