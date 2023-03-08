package io.object;

import java.io.Serializable;

public class SerialDTO implements Serializable {
    static final long serialVersionUID = 1L;
    private String bookName;
    private transient int bookOrder; // transient는 보안상이나 꼭저장할 필요가 없는 변수에 한해서 사용하기
    private boolean bookSeller;
    private long soldPerDay;
    private String bookTypes = "IT";

    public SerialDTO(String bookName, int bookOrder, boolean bookSeller, long soldPerDay) {
        this.bookName = bookName;
        this.bookOrder = bookOrder;
        this.bookSeller = bookSeller;
        this.soldPerDay = soldPerDay;
    }

    @Override
    public String toString() {
        return "SerialDTO{" +
                "bookName='" + bookName + '\'' +
                ", bookOrder=" + bookOrder +
                ", bookSeller=" + bookSeller +
                ", soldPerDay=" + soldPerDay +
                ", bookTypes='" + bookTypes + '\'' +
                '}';
    }
}
