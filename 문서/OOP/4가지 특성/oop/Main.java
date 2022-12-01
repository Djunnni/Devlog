package oop;

public class Main {
	public static void main(String[] args) {
		Zergling zerg1 = new Zergling();
		Zergling zerg2 = new Zergling();
		
		zerg1.attack();
		zerg1.attack();
		zerg1.status();
		
		zerg2.move();
		zerg2.move();
		zerg2.status();
	}
	
}

class Marin {
	int hp=100;
	public void run() {
		hp -= 100;
		System.out.println("running...");
	}
}

class Zergling {
	int hp = 80;
	int mana = 200;
	
	public void attack() {
		hp -= 1;
		mana -= 10;
		System.out.println("저글링 공격!");
	}
	
	public void move() {
		hp -= 10;
		mana += 5;
		System.out.println("저글링 이동");
	}
	
	public void status() {
		System.out.println("hp : " + hp + ", mana : " + mana);
	}
}