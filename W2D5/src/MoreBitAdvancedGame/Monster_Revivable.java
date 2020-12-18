package MoreBitAdvancedGame;

//부활 가능한 몬스터입니다.
public class Monster_Revivable extends Monster {
    int life;
    public Monster_Revivable(String pName, int pHp, int pArmor, int life) {
        super(pName, pHp, pArmor);
        this.life = life;
    }

    //onDeath 이벤트를 받아봅시다.
    @Override
    protected void onDeath() {
        if(this.life>0){
            revive();//라이프가 남아있으면 부활
            super.onDeath();
        }
    }

    //부활 자체도 캡슐화합시다
    private void revive(){
        this.hp = this.getMaxHp();//체력을 다시 복구(부활)
        this.life -= 1;//라이프도 1 감소
        System.out.println(this.getName()+"(이)가 부활하였다!");
    }
    //이럴거면 revive를 둘 필요가 없어보여요
    //맞는 소리에요. 이건 사실 컴포넌트 모델로 가야해요.
}
