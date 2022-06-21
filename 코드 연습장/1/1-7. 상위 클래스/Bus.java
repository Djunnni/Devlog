package chapter6.corporation;

public class Bus extends Trans {
    int busNumber;

    public Bus() {}
    public Bus(int busNumber) {
        this.busNumber = busNumber;
        this.cost = 1000;
    }
    public void showInfo() {
        System.out.println("버스 " + busNumber+ "번의 승액은 " + passengerCount +"명이고, 수입은"
                + money + "입니다.");
    }
}
