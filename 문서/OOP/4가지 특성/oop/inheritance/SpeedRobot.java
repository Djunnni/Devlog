package oop.inheritance;

public class SpeedRobot extends Robot {
	int modelId;
	
	public void run() {
		super.move();
		System.out.println("로봇이 달립니다.");
	}
	
	public void walk() {
		super.move();
		System.out.println("로봇이 걷습니다.");
	}

}
