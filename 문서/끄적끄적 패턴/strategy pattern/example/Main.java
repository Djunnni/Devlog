package pattern.strategy;

public class Main {
	public static void main(String[] args) {
		
		// 캐릭터 2명 선언
		Character daniel = new Character("daniel");
		Character wayne = new Character("wayne");
		
		daniel.setWeapon(new Sword());
		wayne.setWeapon(new Gun());
		
		daniel.attack();
		wayne.attack();
		
	}
}
