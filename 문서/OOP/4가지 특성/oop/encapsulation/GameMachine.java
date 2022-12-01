package oop.encapsulation;

// 캡슐화
public class GameMachine {
	private int totalCoin;
	
	public void inputCoin(int coinCount) {
		if(coinCount > 5) {
			System.out.println("코인은 최대 5개까지 넣을 수 있습니다.");
			return;
		} 
		totalCoin += coinCount;
		if(totalCoin > 10) {
			int remain = totalCoin - 10;
			totalCoin = 10;
			System.out.println("코인이 10개를 넘어 나머지를 반환합니다. 나머지 : " + remain);
			return;
		}
	}
	public void currentCoin() {
		System.out.println("현재 코인의 개수는 " + totalCoin +"개 입니다.");
	}
	public void playGame() {
		if(totalCoin > 0) {
			totalCoin -= 1;
			System.out.println("코인을 하나 사용합니다. \n게임 시작!");
		} else {
			System.out.println("[ERROR] 코인이 없습니다.");
		}
	}
	public static void main(String[] args) {
		GameMachine machine = new GameMachine();
		
		machine.inputCoin(5);
		machine.currentCoin();
		machine.inputCoin(2);
		machine.currentCoin();
		machine.inputCoin(3);
		machine.currentCoin();
		machine.inputCoin(1);
		
		machine.playGame();
		machine.currentCoin();
	}
}
