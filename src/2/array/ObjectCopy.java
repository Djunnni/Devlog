package chapter7.array;

public class ObjectCopy {
    public static void main(String[] args) {
        Book[] bookArray1 = new Book[3];
        Book[] bookArray2 = new Book[3];

        bookArray1[0] = new Book("태백산맥1", "조정래");
        bookArray1[1] = new Book("태백산맥2", "조정래");
        bookArray1[2] = new Book("태백산맥3", "조정래");

        bookArray2[0] = new Book();
        bookArray2[1] = new Book();
        bookArray2[2] = new Book();

        for(int i=0;i<bookArray2.length;i++) {
            bookArray2[i].setAuthor(bookArray1[i].getAuthor());
            bookArray2[i].setBookName(bookArray1[i].getBookName());
        }
        // 주소가 복사된 얕은 복사 예시
        // System.arraycopy(bookArray1, 0, bookArray2, 0, 3);

        for(int i=0;i<bookArray2.length;i++) {
            bookArray2[i].showBook();
        }
        System.out.println("================");
        bookArray1[0].setBookName("나목");
        bookArray1[0].setAuthor("박완서");

        for(int i=0;i<bookArray1.length;i++) {
            bookArray1[i].showBook();
        }
        System.out.println("================");
        for(int i=0;i<bookArray2.length;i++) {
            bookArray2[i].showBook();
        }
    }
}
