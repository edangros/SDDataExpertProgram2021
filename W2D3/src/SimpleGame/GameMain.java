package SimpleGame;

//게임 실처리부분
public class GameMain {
    public static void main(String[] args){
        //몬스터를 생성해줍니다.
        Monster slime = new Monster("Slime",100,0);
        Monster goblin = new Monster("Goblin",250,20);
        Monster ghost = new Monster("Ghost",20,55);
        //생성한 몬스터를 다루기 쉽게 배열에 넣어줍니다.
        Monster[] monsters = {slime,goblin,ghost};
        //무기를 생성해줍니다.
        Weapon stonesword = new Weapon("Stone Sword",20,5);
        Weapon bronzesword = new Weapon("Bronze Sword",40,5);
        Weapon ironsword = new Weapon("Iron Sword",60,5);
        //얘도 배열
        Weapon[] weapons = {stonesword,bronzesword,ironsword};
        int rounds = 0, weaponLv = 0;
        //메인 루프
        //계속 입력하기 귀찮으니 자동사냥이라 칩시다
        while(true){
            //적 몬스터가 죽었으면 다음 라운드로 이동
            if(monsters[rounds].hp<=0){
                rounds++;
                //라운드가 끝났으면 루프 종료
                if(rounds==monsters.length){break;}
                System.out.println("다음 라운드! 상대는 "+monsters[rounds].name);
            }
            //적 몬스터를 공격
            weapons[weaponLv].attack(monsters[rounds]);
            //적 몬스터가 너무 방어력이 높으면 무기 교체
            if(weapons[weaponLv].damage <= monsters[rounds].armor){
                if(weaponLv<(weapons.length-1)){
                    weaponLv++;//무기가 최고레벨이 아니라면 강화
                }
                System.out.println("몬스터가 강해서 무기를 강화했다!");
            }
        }
    }
}
