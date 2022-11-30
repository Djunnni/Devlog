package pattern.strategy;

public class Gun implements Weapon {

	@Override
	public void doAttack() {
		System.out.println("총 쏘기!");
	}

}
