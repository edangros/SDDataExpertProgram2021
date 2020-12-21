package MoreBitAdvancedGame;

//추상 클래스는 별거 없어요
//난 아무것도 안하고 자식들이 알아서 할거라는거.
//공통된 구조는 있지만 개체마다 모두 구현이 제각각인 개체들에 적당합니다.
public abstract class StatusEffect {
    public abstract void execute(Character character);//상태이상을 실행시킵니다.
    //역할 체인 모델은 character를 받아 처리한 뒤에 원래 character를 다시 출력 => 다음 공정자에게 넘김
    //으로 작성해야 하나, 여기서는 제가 카드게임 만들때 썼던 편법대로 할거에요.
    //거기서 끝이 아닙니다. 캐릭터의 getter와 setter가 수정되어서 캐릭터의 데미지 감소, 방어력 감소같은 것도
    //영향을 주어야 할 거에요.
    public abstract int modifyArmor(int initialArmor);//아머 getter 수정용
    public abstract int modifyDamage(int initialDamage);//데미지 getter 수정용
    public abstract int modifyMaxHp(int initialMaxHp);//최대체력 getter 수정용
}
