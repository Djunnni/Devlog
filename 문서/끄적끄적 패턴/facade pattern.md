### facade pattern

퍼사드 패턴이라고 불림

클래스 라이브러리 같은 어떤 소프트웨어의 다른 커다란 코드 부분에 대한 간략화된 인터페이스를 제공하는 객체

* 소프트웨어 라이브러리를 쉽게 사용할 수 있게 해준다.
* 라이브러리를 사용하는 코드들을 읽기 쉽게 해준다.
* 퍼사드는 라이브러리 바깥쪽의 코드가 안쪽의 코드에 의존하는 일을 감소시켜 준다. 대부분 바깥쪽의 코드가 퍼사드를 이용하기 때문에 시스템을 개발하는데 있어 유연성이 향상된다.
* 좋게 작성되지 않은 API의 집합을 하나의 좋게 작성된 API로 감싸준다.

#### Example

```java
/* Complex parts */

class CPU {
	public void freeze() { ... }
	public void jump(long position) { ... }
	public void execute() { ... }
}

class Memory {
	public void load(long position, byte[] data) {
		...
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		...
	}
}

/* Façade */

class Computer {
	public void startComputer() {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
		cpu.freeze();
		memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
		cpu.jump(BOOT_ADDRESS);
		cpu.execute();
	}
}

/* Client */

class You {
	public static void main(String[] args) throws ParseException {
		Computer facade = /* grab a facade instance */;
		facade.startComputer();
	}
}
```