package chapter9.gamelevel;

public class SuperLevel extends PlayerLevel{

    @Override
    public void run() {
        System.out.println("겁나게 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("겁나게 점프합니다.");
    }

    @Override
    public void turn() {
        System.out.println("겁나게 돕니다.");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("*** 상급자 레벨입니다 ***");
    }
}
