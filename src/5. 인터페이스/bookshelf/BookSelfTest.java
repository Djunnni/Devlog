package chapter10.bookshelf;

public class BookSelfTest {
    public static void main(String[] args) {
        Queue shelfQueue = new BookShelf();
        shelfQueue.enQueue("태백산맥1");
        shelfQueue.enQueue("태백산맥2");
        shelfQueue.enQueue("태백산맥3");

        System.out.println(shelfQueue.deQueue());
        System.out.println(shelfQueue.deQueue());
        System.out.println(shelfQueue.deQueue());
    }
}
