import java.util.Scanner;
class Book {
    String title, author;

    /**
     * The class to store the info of the books
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}


public class BookArray {
    public static void main(String[] args) {
        Book [] book = new Book[2]; //클래스의 배열은 '클래스 참조'의 배열입니다.
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<book.length; i++) {
            System.out.print("제목>>");
            String title = scanner.nextLine();
            System.out.print("저자>>");
            String author = scanner.nextLine();
            book[i] = new Book(title, author);
        }
        //언제나 문자열은 포맷이 제일 깨끗합니다.
        for (Book value : book) {System.out.printf("(%s, %s)", value.title, value.author);}
        scanner.close();
    }
}