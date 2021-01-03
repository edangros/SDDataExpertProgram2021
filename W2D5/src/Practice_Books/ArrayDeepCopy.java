package Practice_Books;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayDeepCopy {
    public static void main(String[] args){
        Book[] bookShelf = new Book[5];
        bookShelf[0] = new Book("토지", "박경리");
        bookShelf[1] = new Book("태백산맥", "조정래");
        bookShelf[2] = new Book("당신들의 천국", "이청준");
        bookShelf[3] = new Book("나목", "박완서");
        bookShelf[4] = new Book("데미안", "헤르만 헤세");
        //deep copy는 개체를 새로 만들어서 부여하면 됨.
        //clone 명령을 이용하면 for문같은 귀찮은 일 필요없음
        Book[] copiedBookShelf = new Book[5];
        copiedBookShelf[0] = new Book();
        copiedBookShelf[1] = new Book();
        copiedBookShelf[2] = new Book();
        copiedBookShelf[3] = new Book();
        copiedBookShelf[4] = new Book();
        for(int i = 0;i<bookShelf.length;i++){
            copiedBookShelf[i].setTitle(bookShelf[i].getTitle());
            copiedBookShelf[i].setAuthor(bookShelf[i].getAuthor());
        }
        bookShelf[0].setTitle("나목"); bookShelf[0].setAuthor("박완서");
        for (int i = 0; i < bookShelf.length; i++) {
            System.out.println(bookShelf[i]);
            bookShelf[i].showBookInfo();
        }
        System.out.println("=======================");
        for (int i = 0; i < copiedBookShelf.length; i++) {
            System.out.println(copiedBookShelf[i]);
            copiedBookShelf[i].showBookInfo();
        }
    }
}
