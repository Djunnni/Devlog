package generics;

public class TreeDPrinterTest {

	public static void main(String[] args) {
		TreeDPrinter<Powder> printer = new TreeDPrinter<>();
		printer.setMaterial(new Powder());
		
		Powder powder = printer.getMaterial();
		System.out.println(printer);
		
		TreeDPrinter<Plastic> printerPlastic = new TreeDPrinter<>();
		printerPlastic.setMaterial(new Plastic());
		Plastic plastic = printerPlastic.getMaterial();
		System.out.println(printerPlastic);
		
		printerPlastic.printing();
		// 제네릭타입에 물은 들어가지 못하게 하고 싶을 때, 어떻게 할 것인가? T가 extends로 다른걸 가지고 있는지 확인.
//		TreeDPrinter<Water> printerWater = new TreeDPrinter<>();
//		printerWater.setMaterial(new Water());
//		System.out.println(printerWater);
	}

}
