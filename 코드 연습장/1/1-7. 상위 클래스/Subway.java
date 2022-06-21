package chapter6.corporation;

public class Subway extends Trans {
    int lineNumber;

    public Subway(int lineNumber) {
        this.lineNumber = lineNumber;
        this.cost = 1500;
    }
    public void showInfo() {
        System.out.println("지하철 " + lineNumber+ "번의 승액은 " + passengerCount +"명이고, 수입은"
                + money + "입니다.");
    }
}
