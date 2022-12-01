package oop.polymopism;

public class Test {
	public static void main(String[] args) {
		// 다형성에 대한 예시
		Rifle[] rifles = {
				new Rifle(), new ShotGun(), new Sniper()
		};
		
		for(Rifle r : rifles) {
			r.shot();
		}
	}
}
