package MoreBitAdvancedGame;

import java.util.ArrayList;
import java.util.Collections;

//플레이어와 몬스터의 부모 클래스, 캐릭터입니다.
public class Character {

    //DB
    private Data data;//데이터 개체는 캡슐화되어 외부에서 직접 접근은 못함
    //데이터 개체는 변하지 않는 고정된 데이터베이스값!
    class Data{
        private final int hp, armor, damage;
        private final String name;

        public Data(String name, int hp, int armor, int damage) {
            this.hp = hp;
            this.armor = armor;
            this.name = name;
            this.damage = damage;
        }

        public int getDamage() {
            return damage;
        }

        public int getHp() {
            return hp;
        }

        public int getArmor() {
            return armor;
        }

        public String getName() {
            return this.name;
        }
    }

    protected int hp;
    public Character(String name, int hp, int armor, int damage) {
        this.data = new Data(name,hp,armor,damage);
        this.hp = this.data.getHp();
    }

    //GetSet
    //getter setter 선언하는데. setter는 많이 숨겨지고 없는 경우도 많습니다.
    //게임에서 버프 없이 스탯 변하는 일은 거의 없으니까요. 대신 효과 적용은 버프를 통해 움직입니다.
    public int getHp() {
        return hp;
    }

    //진짜 세터는 숨겨둡니다.
    //세터를 int타입으로 바꾸었습니다. 체력 변화량을 리턴합니다.(화면 표시용)
    private int setHp(int value) {
        int prevHp = this.hp;
        this.hp = value;
        return this.hp-prevHp;
    }
    //hp의 모든 세터들은 체력 변화량을 리턴합니다.(화면 표시용)
    //hp의 첫 번째 세터 -> 체력을 데이터베이스상 체력의 일정 비율로 조절
    public int setHpPercentage(int percent){
        return this.setHp(Math.min((int)(this.data.hp*percent*0.01),this.getMaxHp()));//그런다고 최대체력을 넘기긴 ㄴㄴ
    }
    //hp의 두 번째 세터 -> 체력을 깎음
    public int hitThis(int amount){
        if(amount<0){return 0;}//변경량이 0 이하면 반영 안함
        int damage = onHit(amount);
        damage = setHp(Math.max(this.hp-damage,0));
        if(this.getHp()<=0){this.onDeath();} //죽었으면 죽음처리
        return damage;//체력을 0 이하로 떨어뜨리진 않고 데미지 처리
    }
    //hp의 세 번째 세터 -> 체력을 회복
    public int healThis(int amount){
        if(amount<0){return 0;}//변경량이 0 이하면 반영 안함
        return setHp(Math.min(this.hp+amount,this.getMaxHp()));//최대 체력 이상으로 올리진 않음
    }

    //스텟을 리턴할때는 상태효과에 의한 변동량을 계산해서 리턴해야합니다.
    //따라서 getter는 멤버변수값이 아니라 어떠한 결과값을 리턴합니다! (getter의 확장)
    public int getArmor() {
        int res = this.data.getArmor();//표준 아머 값으로 시작
        for (StatusEffect se : statusEffects) {//가지고 있는 상태이상대로
            res = se.modifyArmor(res);//실행해서 변경된 값을 전달
        }
        return res;
    }

    public int getDamage() {
        int res = this.data.getDamage();//표준 공격력 값으로 시작
        for (StatusEffect se : statusEffects) {//가지고 있는 상태이상대로
            res = se.modifyDamage(res);//실행해서 변경된 값을 전달
        }
        return res;
    }

    public int getMaxHp() {
        int res = this.data.getHp();//표준 체력 값으로 시작
        for (StatusEffect se : statusEffects) {//가지고 있는 상태이상대로
            res = se.modifyMaxHp(res);//실행해서 변경된 값을 전달
        }
        return res;
    }

    //밖에서 보면 name의 getter같지만 사실 데이터개체에 연결됨!
    public String getName() {
        return this.data.name;
    }

    //이벤트 처리부
    //데미지 이벤트 처리용. 부모 클래스에서는 아무것도 안하고 자식 클래스에서 처리
    //다만 변경된 데미지를 다시 리턴해주긴 해야함
    protected int onHit(int damage){
        return damage;
    }
    //죽었을 경우도 이벤트로 분리(아직은 초보적인 이벤트고 차차 발전시킬 예정)
    protected void onDeath(){

    }



    //상태이상

    //역할 체인을 만들겁니다.
    //역할 체인은 원래 A개체 내부에 다음 개체 B로 보내라고, B 개체 내에 C로...가 정석이지만
    //여기서는 큐와 유사한 구조를 가지는 리스트 + 해석기로 처리하겠습니다.
    ArrayList<StatusEffect>statusEffects = new ArrayList<StatusEffect>();
    //상태이상 실행 해석기
    protected void executeStatusEffects(){
        for (StatusEffect se : statusEffects) {//가지고 있는 상태이상대로
            se.execute(this);//실행
        }
        //원래는 역할 체인이 자기 혼자 돌아야 하지만 우리는 역할 체인의 구조가 계속 능동적으로 변해야 합니다.
        //그래서 리스트에 올립니다. 클라이언트 요구가 또 생기면 문제가 생기지만 지금은 훌륭하게 '큐' 처럼 동작하게 됩니다.
        //(올바른 역할 체인 구성을 위해 최종판은 '링크드 리스트'처럼 동작하게 설계되어야 합니다.)
    }
    //상태이상 등록
    public void registerStatusEffect(StatusEffect statusEffect){
        statusEffects.add(statusEffect);
    }
    //상태이상 해제
    public void unRegisterStatusEffect(StatusEffect statusEffect){
        statusEffects.remove(statusEffect);//단순히 리스트에서 지웠는데, '같은 상태이상의 중첩'에서 이건 문제가 발생합니다.
        //원리상 remove는 '가장 처음 걸리는 놈'을 지우니까 어떻게 되기는 하는데... 그게 먼저 없어져야 하는 애라는 보장이 있을까요?
        //SOLID원칙에 의거하면, 없어지는 주체는 StatusEffect 개체지만 지금 그 없어지는 책임은 Character가 지고 있습니다.
        //동시에 추상화되지 않은 관념(Character의 내부 리스트)에 의존하고 있네요
        //최종 버전에서는 StatusEffect가 자신이 지워져야 할 때 자신을 담고 있는 캐릭터에게 '날 지워줘'라고 보내면
        //Character 클래스는 지워달라고 한 개체를 지워주는 식으로 구현해야
        //S원칙과 D원칙을 충족할 수 있을겁니다.
        //역할 체인을 구현하는 방식이 바뀌어야 하는 거고, 표준화를 위해 인터페이스...가 등판해야 합니다.
    }
    //상태이상 갯수 카운트
    public int countStatusEffect(){
        return statusEffects.size();
    }
    //특정 상태이상 갯수 카운트
    public int countStatusEffect(StatusEffect statusEffect){
        return Collections.frequency(statusEffects,statusEffect);
    }
    //뭔가 상단의 캐릭터 관련과 이질적인 느낌이 든다면 정답.
    //이것까지 집어넣으면 슬슬 SOLID원칙과 충돌합니다.
    //이 파트는 '인터페이스'를 부여하여 표준화시키거나 '엔티티'또는 '컴포넌트'로 분리해내는게 바람직할 겁니다.
}
