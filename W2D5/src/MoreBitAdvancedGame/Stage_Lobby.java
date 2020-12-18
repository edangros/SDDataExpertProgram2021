package MoreBitAdvancedGame;

import java.util.Scanner;

public class Stage_Lobby extends Stage{
    Scanner scanner;

    public Stage_Lobby() {
         this.scanner = new Scanner(System.in);
    }

    @Override
    public void main() {
        System.out.print("이름을 입력하세요 : ");
        scanner.next();
    }
}
