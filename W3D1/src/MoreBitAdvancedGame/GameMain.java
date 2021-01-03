package MoreBitAdvancedGame;



//게임 실처리부분
public class GameMain {
    //게임 전체에 아이탬목록, 몬스터목록은 하나뿐
    //+게임 전역에서 어느 클래스건 이 데이터베이스엔 접속할 수 있어야겠지?
    //=>>static이 제격!
    /*
    static Monster[] monsters;
    static Weapon_Sword[] meleeWeapons;
    static Weapon_Bow[] rangedWeapons;
    */
    //이제 저런거 안해요. '싱글톤'이 있으니까

    public static Stage stage; //어디서든 접속 가능한 '현재 씬'

    //'알만툴'(쯔꾸르, RPG Maker) 형 메인루프 구조를 택하겠습니다.
    //알만툴에서 스테이지 전환은 위의 stage 변수를 수정하여 진행합니다.
    //메인 함수는 스테이지의 main만 계속 실행시킵니다.
    //스테이지가 아무것도 없다면 루프가 종료됩니다.
    public static void main(String[] args){
        stage = new Stage_Lobby();//로비 스테이지로 연결
        while (true){//게임 루프
            if(stage == null){break;}//스테이지가 없어졌다면 게임 루프 종료
            stage.main();//스테이지의 메인을 구동시킵니다.
        }
    }
}
