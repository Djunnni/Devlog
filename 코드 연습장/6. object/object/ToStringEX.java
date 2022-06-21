package chapter11.object;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    //Object의 toString을 재정의한다.
    @Override
    public String toString() {
        return title + "," + author;
    }
}
public class ToStringEX {
    public static void main(String[] args) {
        Book book = new Book("두잇자바", "이동준");
        System.out.println(book);
    }
}
