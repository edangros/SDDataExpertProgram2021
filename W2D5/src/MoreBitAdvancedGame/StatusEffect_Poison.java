package MoreBitAdvancedGame;

//독화살 이팩트 구현체
public class StatusEffect_Poison extends StatusEffect{
    private final int poisonDamage;//독데미지로 줄 내용입니다.
    public StatusEffect_Poison(int strength){
        this.poisonDamage = strength;
    }
    @Override
    public void execute(Character character) {
        //작동할 때, 캐릭터에게 데미지를 줍니다.
        System.out.println(character.getName()+"이"+ this.poisonDamage+"의 독데미지를 입었다!");
        character.damageThis(this.poisonDamage);
    }
    //독화살 상태는 스탯에는 아무 변화도 주지 않습니다.
    @Override
    public int modifyArmor(int initialArmor) {
        return initialArmor;
    }

    @Override
    public int modifyDamage(int initialDamage) {
        return initialDamage;
    }

    @Override
    public int modifyMaxHp(int initialMaxHp) {
        return initialMaxHp;
    }
}
//뭔가 엄청 간단합니다?!
//Character 클래스의 모든게 추상화된 관념으로 존재하기 때문에 '어떤 기능'을 실행하는 코드는 '한 줄' 뿐입니다.