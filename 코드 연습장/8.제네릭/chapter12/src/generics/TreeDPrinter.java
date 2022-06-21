package generics;

// <T> 사용할 타입이 대체될 곳!
public class TreeDPrinter<T extends Material> {
	private T material;
	// static 변수는 사용할 수 없다. T는 동적으로 만들어져서.
	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return material.toString();
	}
	
	public void printing() {
		this.material.doPrinting();
	}
}

// 제네릭에서 자료형 추론(자바 10) 
// ArrayList<String> list = new ArrayList<>();
// var list = new ArrayList<String>();