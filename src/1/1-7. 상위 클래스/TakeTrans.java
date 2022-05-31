package chapter6.corporation;

public class TakeTrans {
    public static void main(String[] args) {
        Student james = new Student("james", 5000);
        Student tomas = new Student("tomas", 10000);

        Bus bus100 = new Bus(100);
        james.take(bus100);
        james.showInfo();
        bus100.showInfo();

        Subway subwayGreen = new Subway(2);
        tomas.take(subwayGreen);
        tomas.showInfo();
        subwayGreen.showInfo();
    }
}
