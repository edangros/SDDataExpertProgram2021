package MoreBitAdvancedGame;

import java.util.ArrayList;

//무기를 다루는 클래스입니다.
public class Weapon {
    //무기는 공격력과 공격속도가 있겠네요
    public final int damage, attSpeed;
    //이름도 있고요
    public final String name;
    //생성하고 나면 바뀔 값이 아니니 final을 붙여 처음 정의되면 바뀌지 않게 했습니다.

    //무기의 성질을 나타내는 '속성' 필드를 enum으로 만들겠습니다.
    enum Element {DAGGER,BOW,MELEE,RANGED,PROJECTILE}
    private final ArrayList<Element> elements = new ArrayList<>(); //자식 클래스들이 쓸거고, 여기서는 따로 정의하지 않습니다.
    //속성이 있는지를 반환하는 메서드
    public boolean hasElemental(Element element){
        return elements.contains(element);
    }
    //속성을 추가하는 메서드
    protected void addElemental(Element element){
        elements.add(element);
    }

    //생성자
    public Weapon(String pName, int pDamage, int pAttSpeed){
        damage = pDamage;
        attSpeed = pAttSpeed;
        name = pName;
    }

    //무기라면 공격할 수 있어야겠죠. 이번엔 아무 처리도 하지 않습니다. 자식 클래스가 처리할거에요.
    public void attack(Character target){ //몬스터가 플레이어를 때릴 일이 있을지도 모르므로 Monster->Character로 변경!
    }
    //damage, attspeed의 getter 정의해줍시다.
    public int getDamage(){
        return damage;
    }
}
