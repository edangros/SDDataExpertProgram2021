package MoreBitAdvancedGame;

//플레이어 클래스입니다.
public class Player extends Character{
    Integer level = 0;//플레이어는 레벨이 있어요
    Integer weaponId = null, subWeaponId = null; //무기도 장착할 줄 알죠
    //생성자
    public Player(String pName){
        super(pName,100,0,10);//아직 클라이언트가 뭐 요구 안했으니 스탯은 없어요
    }

    //플레이어는 레벨이 증가할 때마다 5의 데미지를 증가시킨다고 하니 데미지 부분을 늘려봅시다.
    //주목할 부분은, 이제 플레이어가 모든 데미지 계산을 집합해서 한다는 거!
    //이러면 나중에 총공격력같은것도 쉽게 표시되겠죠?
    @Override
    public int getDamage() {
        int res = this.getDamage() + this.level*5;
        res += (weaponId != null)? GameDataManager.getInstance().getWeapon(this.weaponId).getDamage():0;//무기가 있으면 무기데미지 추가
        res += (subWeaponId != null)? GameDataManager.getInstance().getWeapon(this.subWeaponId).getDamage():0;//보조무기가 있으면 보조무기데미지 추가
        return res;
    }
    //이제 공격의 주체도 플레이어가 되었어요
    //플레이어는 무기에게 '공격' 명령을 내림, 무기는 '공격'을 알아서 수행
    public void attack(Monster target){
        if(weaponId != null){GameDataManager.getInstance().getWeapon(this.weaponId).attack(target,this);}
    }
}