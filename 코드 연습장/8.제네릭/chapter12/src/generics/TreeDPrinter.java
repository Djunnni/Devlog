package generics;

// <T> ����� Ÿ���� ��ü�� ��!
public class TreeDPrinter<T extends Material> {
	private T material;
	// static ������ ����� �� ����. T�� �������� ���������.
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

// ���׸����� �ڷ��� �߷�(�ڹ� 10) 
// ArrayList<String> list = new ArrayList<>();
// var list = new ArrayList<String>();