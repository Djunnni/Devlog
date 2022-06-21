package chapter7.array;

public class Book {
    private String bookName;
    private String author;

    public Book() {}
    public Book(String name, String author) {
        this.bookName = name;
        this.author = author;
    }
    public String getBookName() {
        return this.bookName;
    }
    public void setBookName(String name) {
        this.bookName = name;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String auth) {
        this.author = auth;
    }
    public void showBook() {
        System.out.println(this.bookName +"의 저자는 " + this.author + "입니다.");
    }
}
