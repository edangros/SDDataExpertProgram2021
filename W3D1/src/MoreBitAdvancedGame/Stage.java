package MoreBitAdvancedGame;

//게임이 실재로 벌어지는 '스테이지'입니다. 추상클래스로 선언합니다.

public abstract class Stage {
    public abstract void main(); //각 스테이지는 자신의 메인루프를 가지고 있지만, 프로그램의 메인루프는 아닙니다.
}
