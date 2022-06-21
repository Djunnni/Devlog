package chapter6.corporation;

public class Student {
    String studentName;
    int grade;
    int money;

    public Student(String name, int money) {
        this.studentName = name;
        this.money = money;
    }

    public void take(Trans trans) {
        trans.take(trans.cost);
        this.money -= trans.cost;
    }
    public void showInfo() {
        System.out.println(studentName + "님의 남은 돈은 "+ money + "입니다.");
    }

}
