package oop.inheritance;

public class PowerRobot extends Robot {
	int mana;
	
	public void attack() {
		super.move();
		System.out.println("로봇이 공격합니다.");
	}
	
	public void jump() {
		super.move();
		System.out.println("로봇이 뛰어오릅니다.");
	}
}
