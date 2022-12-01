package oop.inheritance;

// Robot을 PowerRobot과 SpeedRobot에 상속
public class Robot {
	int hp;
	
	public void move() {
		System.out.println("로봇이 움직입니다.");
	}
	public void stop() {
		System.out.println("로봇이 멈춥니다.");
	}
	public static void main(String[] args) {
		PowerRobot probot = new PowerRobot();
		
		SpeedRobot srobot = new SpeedRobot();
		
		probot.attack();
		srobot.run();
	}
}
