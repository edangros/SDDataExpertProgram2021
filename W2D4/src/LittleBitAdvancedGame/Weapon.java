package LittleBitAdvancedGame;

//무기를 다루는 클래스입니다.
public class Weapon {
    //무기는 공격력과 공격속도가 있겠네요
    public final int damage, attSpeed;
    //이름도 있고요
    public final String name;
    //생성하고 나면 바뀔 값이 아니니 final을 붙여 처음 정의되면 바뀌지 않게 했습니다.
    //왜 이건 getter setter를 쓰지 않았나요 => final이라 나중에 영향받고 할 일이 전혀 없어서요.

    //생성자
    public Weapon(String pName, int pDamage, int pAttSpeed){
        damage = pDamage;
        attSpeed = pAttSpeed;
        name = pName;
    }

    //무기라면 공격할 수 있어야겠죠. 이번엔 아무 처리도 하지 않습니다. 자식 클래스가 처리할거에요.
    public void attack(Monster target){
    }
    //damage, attspeed의 getter 정의해줍시다.
    public int getDamage(){
        return damage;
    }
}
