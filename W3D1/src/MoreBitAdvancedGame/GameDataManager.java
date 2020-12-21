package MoreBitAdvancedGame;

//'싱글톤 타입'의 게임데이터메니저 개체입니다.
//Static과 마찬가지로 싱글톤 타입도 '프로그램 실행동안 단 하나 존재하는' 개체입니다. 다만 static과 좀 다릅니다.
//-멀티쓰레딩에서 static보다 낫습니다
//-static은 만들어지는 순간부터 메모리에 상주하지만 싱글톤은 메모리자원의 코드레벨 관리가 가능합니다.


import java.util.Hashtable;

public class GameDataManager {
    //'private' 생성자...?!
    private GameDataManager(){
        initializeDataSet();
    }
    private static GameDataManager instance; //왜 자기를 인수로? 어쨌든 static인걸 보니 하나만 존재하겠네
    public static GameDataManager getInstance(){
        //...뭐요?
        if(instance == null){instance = new GameDataManager();}//만들어둔 instance가 없다면 아까 만들어둔 private생성자 실행
        return instance;
    }
    //GameDataManager는 static이 아닙니다. 이걸 명심하세요
    //따라서 아래의 모든 게임정보를 가진 해시테이블(=파이썬 딕셔너리.무겁겠죠)은 instance가 만들어지기 전엔 생기지 않습니다.
    private Hashtable<Integer,Weapon> weapons = new Hashtable<>();
    public Weapon getWeapon(int weaponId){
        return weapons.get(weaponId);
    }
    private Hashtable<Integer,Monster> monsters = new Hashtable<>();
    public Monster getMonster(int monsterId){
        return monsters.get(monsterId);
    }
    private Hashtable<Integer,StatusEffect> statusEffects = new Hashtable<>();
    public StatusEffect getStatusEffect(int statusEffectId){
        return statusEffects.get(statusEffectId);
    }
    private void initializeDataSet(){
        int i = 0;//원래는 파일이나 데이터베이스로 처리하는 부분이지만... 인덱스 꼼수를 씁시다
        weapons.put(i,new Weapon_Sword("Wooden Sword",10,3));
        weapons.put(++i,new Weapon_Sword("Harden Sword",15,3));//...?!복붙이 이렇게 쉬워지다니!
        weapons.put(++i,new Weapon_Sword("Bronze Sword",20,2));
        weapons.put(++i,new Weapon_Sword("Iron Sword",25,1));
        i = 100; //인덱스 100부터는 단검 -> 단검은 주무기가 단검일 시 보조무기도 단검 착용 가능
        weapons.put(i,new Weapon_Sword("Short Dagger",5,1));
        weapons.put(++i,new Weapon_Sword("Poison Dagger",5,1));
        i =200; //인덱스 200부터는 활 -> 활은 주무기가 활일 시 보조무기로 화살 착용 가능,
        weapons.put(i,new Weapon_Bow("Wooden Bow",10,3));
        weapons.put(++i,new Weapon_Bow("Bone Bow",20,3));
        weapons.put(++i,new Weapon_Bow("Composite Bow",20,3));
        weapons.put(++i,new Weapon_Bow("Ruby Bow",20,3));
        i =300; //인덱스 300부터는 화살
        weapons.put(i,new Weapon_Arrow("Simple Arrow",10,3));
        weapons.put(++i,new Weapon_Arrow_Poison("Poison Arrow",15,3,1));
        weapons.put(++i,new Weapon_Arrow("Saint Antioch's Arrow",1000,3));

        //몬스터 정의
        i=0;
        monsters.put(i, new Monster("Goblin",100,0));
        monsters.put(++i, new Monster("Slime",80,10));
        monsters.put(++i, new Monster_Revivable("Ghost",40,60,3));
        monsters.put(++i, new Monster("Orc",200,30));

        //상태 정의
        i=0;
        statusEffects.put(i,new StatusEffect_Poison(1));
        statusEffects.put(++i,new StatusEffect_Poison(3));
    }
}
