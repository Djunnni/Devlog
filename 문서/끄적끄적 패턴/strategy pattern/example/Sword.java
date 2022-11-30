package pattern.strategy;

public class Sword implements Weapon {

	@Override
	public void doAttack() {
		System.out.println("검으로 베기!!");
	}

}
