package MoreBitAdvancedGame;

//아머파괴 상태입니다.
public class StatusEffect_ArmorBreak extends StatusEffect{
    private final int armorBreak;//파괴되는 아머의 양입니다

    public StatusEffect_ArmorBreak(int armorBreak) {
        this.armorBreak = armorBreak;
    }

    @Override
    public void execute(Character character) {
        //실행 내용은 없습니다.
    }

    @Override
    public int modifyArmor(int initialArmor) {
        return Math.max(initialArmor-armorBreak,0);//아머를 깎기는 하지만 음수가 되지는 않습니다.
    }

    //나머지는 그대로 두네요
    @Override
    public int modifyDamage(int initialDamage) {
        return initialDamage;
    }

    @Override
    public int modifyMaxHp(int initialMaxHp) {
        return initialMaxHp;
    }
}
