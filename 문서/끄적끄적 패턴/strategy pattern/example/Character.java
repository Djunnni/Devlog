package pattern.strategy;

public class Character {
	private String name;
    // 접근점
	private Weapon weapon;
	
	public Character() {}
	public Character(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void attack() {
		System.out.println("=========================");
		System.out.println(name + "이 공격하고 있습니다!");
        if(weapon == null) {
            System.out.println("맨손 공격");
        } else {
		    weapon.doAttack();
        }
		System.out.println("=========================");
	}
	
}
