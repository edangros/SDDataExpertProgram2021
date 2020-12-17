package LittleBitAdvancedGame;

/*
W2D3 SimpleGame과 달라진 부분 :
무기 중에 갑자기 '활'이 생겼습니다.
'활'은 직접 공격을 하지 않고, '화살'을 만들어 '화살'이 몬스터를 공격해야 합니다.
구조가 바뀌었으므로 개체를 바꾸어봅시다.
활과 화살, 칼은 '무기'의 일종입니다. 따라서 Weapon 클래스를 상속받는 Bow, Arrow, Sword 클래스를 만듭니다.
각 활은 Bow 클래스의 인스턴스, 화살은 Arrow 클래스의 인스턴스, 칼은 Sword 클래스의 인스턴스로 만들 수 있을겁니다.

몬스터 중 'ghost'는 죽은 뒤 한번 다시 부활을 한다고 합니다. 몬스터가 죽었을 때 처리를 바꾸어야 하니 몬스터 또한
무기와 같이 상속관계로 바꾸어봅시다.

+나중에 인터페이스가 나오면 무기파트는 다시 뒤엎어집니다. 더 범용적이고 강력한 버전으로 다시 만들어질거에요.
 */


//게임 실처리부분
public class GameMain {
    //게임 전체에 아이탬목록, 몬스터목록은 하나뿐
    //+게임 전역에서 어느 클래스건 이 데이터베이스엔 접속할 수 있어야겠지?
    //=>>static이 제격!
    static Monster[] monsters;
    static Weapon_Sword[] meleeWeapons;
    static Weapon_Bow[] rangedWeapons;

    public static void main(String[] args){
        //얘도 배열
        int rounds = 0, weaponLv = 0;
        initializeWeaponsAndMonsters();
        //메인 루프
        //계속 입력하기 귀찮으니 자동사냥이라 칩시다
        while(true){
            //적 몬스터가 죽었으면 다음 라운드로 이동
            if(monsters[rounds].getCurrHp()<=0){
                rounds++;
                //라운드가 끝났으면 루프 종료
                if(rounds==monsters.length){break;}
                System.out.println("다음 라운드! 상대는 "+monsters[rounds].name);
            }
            //적 몬스터를 공격
            meleeWeapons[weaponLv].attack(monsters[rounds]);
            //적 몬스터가 너무 방어력이 높으면 무기 교체
            if(meleeWeapons[weaponLv].getDamage() <= monsters[rounds].armor){
                if(weaponLv<(meleeWeapons.length-1)){
                    weaponLv++;//무기가 최고레벨이 아니라면 강화
                    System.out.println("몬스터가 강해서 무기를 강화했다!");
                }
                else{
                    System.out.println("몬스터가 너무 강하다....");
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("이번엔 원거리다!");
        //원거리로
        rounds = 0; weaponLv = 0;
        initializeWeaponsAndMonsters();
        while(true){
            //적 몬스터가 죽었으면 다음 라운드로 이동
            if(monsters[rounds].getCurrHp()<=0){
                rounds++;
                //라운드가 끝났으면 루프 종료
                if(rounds==monsters.length){break;}
                System.out.println("다음 라운드! 상대는 "+monsters[rounds].name);
            }
            //적 몬스터를 공격
            rangedWeapons[weaponLv].attack(monsters[rounds]);
            //적 몬스터가 너무 방어력이 높으면 무기 교체
            if(rangedWeapons[weaponLv].getDamage() <= monsters[rounds].armor){
                if(weaponLv<(rangedWeapons.length-1)){
                    weaponLv++;//무기가 최고레벨이 아니라면 강화
                    System.out.println("몬스터가 강해서 무기를 강화했다!");
                }
                else{
                    //최고레벨이면 화살을 궁극의화살로 교체
                    rangedWeapons[weaponLv].setArrow(new Weapon_Arrow("The Antioch's Arrow",9999,100));
                    System.out.println("몬스터가 강해서 궁극의 화살을 부착했다!");
                }
            }
        }
    }
    //무기랑 몬스터 초기화가 너무 길어지므로 분리합시다.
    public static void initializeWeaponsAndMonsters(){
        //몬스터를 생성해줍니다.
        Monster slime = new Monster("Slime",100,0);
        Monster goblin = new Monster("Goblin",250,20);
        Monster ghost = new Monster_Revivable("Ghost",20,105,1);//ghost는 부활할거에요!
        //생성한 몬스터를 배열에 넣어줍니다.
        monsters = new Monster[]{slime, goblin, ghost};
        //무기를 생성해줍니다.
        Weapon_Sword stoneSword = new Weapon_Sword("Stone Sword",20,5);
        Weapon_Sword bronzeSword = new Weapon_Sword("Bronze Sword",25,5);
        Weapon_Sword ironSword = new Weapon_Sword("Iron Sword",30,5);
        meleeWeapons = new Weapon_Sword[]{stoneSword,bronzeSword,ironSword};
        //무기를 생성해줍니다.
        Weapon_Bow woodBow = new Weapon_Bow("Wooden Bow",10,5);
        woodBow.setArrow(new Weapon_Arrow("Simple Arrow",40,5));
        Weapon_Bow rubyBow = new Weapon_Bow("Ruby Bow",10,5);
        rubyBow.setArrow(new Weapon_Arrow("Simple Arrow",55,5));
        rangedWeapons = new Weapon_Bow[]{woodBow,rubyBow};
        //데이터 정의 파트는 '데이터베이스'와 결합시 강력해집니다. 지금은 뭐 어쩔 수...
    }
}


/*출력 결과
Slime : 아야!
Stone Sword로 Slime에게 20의 데미지를 가했다! 대상의 현재 체력은 80이다
...
Stone Sword로 Slime에게 20의 데미지를 가했다! 대상의 현재 체력은 20이다
Slime : 아야!
Stone Sword로 Slime에게 20의 데미지를 가했다! 대상의 현재 체력은 0이다
다음 라운드! 상대는 Goblin
Goblin : 아야!
Stone Sword로 Goblin에게 0의 데미지를 가했다! 대상의 현재 체력은 250이다
몬스터가 강해서 무기를 강화했다!
Goblin : 아야!
Bronze Sword로 Goblin에게 5의 데미지를 가했다! 대상의 현재 체력은 245이다
Goblin : 아야!
...
Bronze Sword로 Goblin에게 5의 데미지를 가했다! 대상의 현재 체력은 5이다
Goblin : 아야!
Bronze Sword로 Goblin에게 5의 데미지를 가했다! 대상의 현재 체력은 0이다
다음 라운드! 상대는 Ghost
Ghost : 아야!
Bronze Sword로 Ghost에게 0의 데미지를 가했다! 대상의 현재 체력은 20이다
몬스터가 강해서 무기를 강화했다!
Ghost : 아야!
Iron Sword로 Ghost에게 0의 데미지를 가했다! 대상의 현재 체력은 20이다
몬스터가 너무 강하다....

이번엔 원거리다!
Wooden Bow에서 Simple Arrow을 발사하였다!
Slime : 아야!
Simple Arrow로 Slime에게 50의 데미지를 가했다! 대상의 현재 체력은 50이다
Wooden Bow에서 Simple Arrow을 발사하였다!
Slime : 아야!
Simple Arrow로 Slime에게 50의 데미지를 가했다! 대상의 현재 체력은 0이다
다음 라운드! 상대는 Goblin
Wooden Bow에서 Simple Arrow을 발사하였다!
Goblin : 아야!
Simple Arrow로 Goblin에게 30의 데미지를 가했다! 대상의 현재 체력은 220이다
Wooden Bow에서 Simple Arrow을 발사하였다!
Goblin : 아야!
Simple Arrow로 Goblin에게 30의 데미지를 가했다! 대상의 현재 체력은 190이다
...
Wooden Bow에서 Simple Arrow을 발사하였다!
Goblin : 아야!
Simple Arrow로 Goblin에게 30의 데미지를 가했다! 대상의 현재 체력은 10이다
Wooden Bow에서 Simple Arrow을 발사하였다!
Goblin : 아야!
Simple Arrow로 Goblin에게 30의 데미지를 가했다! 대상의 현재 체력은 -20이다
다음 라운드! 상대는 Ghost
Wooden Bow에서 Simple Arrow을 발사하였다!
Ghost : 아야!
Simple Arrow로 Ghost에게 0의 데미지를 가했다! 대상의 현재 체력은 20이다
몬스터가 강해서 무기를 강화했다!
Ruby Bow에서 Simple Arrow을 발사하였다!
Ghost : 아야!
Simple Arrow로 Ghost에게 0의 데미지를 가했다! 대상의 현재 체력은 20이다
몬스터가 강해서 궁극의 화살을 부착했다!
Ruby Bow에서 The Antioch's Arrow을 발사하였다!
Ghost : 아야!
Ghost(이)가 부활하였다!
The Antioch's Arrow로 Ghost에게 9904의 데미지를 가했다! 대상의 현재 체력은 20이다
Ruby Bow에서 The Antioch's Arrow을 발사하였다!
Ghost : 아야!
The Antioch's Arrow로 Ghost에게 9904의 데미지를 가했다! 대상의 현재 체력은 -9884이다
Disconnected from the target VM, address: '127.0.0.1:49592', transport: 'socket'

Process finished with exit code 0

 */