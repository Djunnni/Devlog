package chapter6.corporation;

public class Trans {
    int money;
    int cost;
    int passengerCount;

    public void take(int money) {
        this.money += money;
        passengerCount += 1;
    }
}
