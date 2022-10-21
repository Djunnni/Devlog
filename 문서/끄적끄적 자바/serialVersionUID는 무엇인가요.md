## serialVersionUID는 무엇인가요?

코드 작성하다보면 어떤 경우에는 serialVersionUID가 있는 경우가 있었다.

왜 이 부분이 있어야 하는 지 필요성을 알아보자.

### 직렬화

자바에서 직렬화란 자바의 객체를 바이트 배열로 변환해 파일, 메모리, DB 등 저장하는 과정을 말함. 

역 직렬화는 직렬화된 파일을 다시 객체로 변환하는 것을 말합니다.


### serialVersionUID를 이용

직렬화 할 때는 serialVersionUID를 저장을 하고 다시 불러드릴 때, 그 값을 체크하는 용도로 사용하게 된다.

### 작성하지 않으면?

JAVA VM 내부 알고리즘에 의해 자동으로 작성, 어떤 VM을 사용하느냐에 따라 값이 달라질 수 있다.

window, linux에서 VM이 다르므로 이 값이 다르게 설정될 수 있고 역직렬화 시 익셉션이 발생할 수 있다.

1. 저장하는 쪽의 컴파일러와 불러오는 쪽의 컴파일러가 다를 경우
2. 저장하는 시기의 클래스 속성과 불러오는 시기의 클래스 속성이 다를 경우

```java
java.io.InvalidClassException: com.leedovoca.test2.Human; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
```
### 실습
```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		read();
	}
	public static void read() throws IOException, ClassNotFoundException {
		MemberDto member = null;
		FileInputStream fi = new FileInputStream("C:\\ssafy\\test.ser");
		ObjectInputStream in = new ObjectInputStream(fi);
		
		member = (MemberDto) in.readObject();
		System.out.println(member);
		in.close();
	}
	public static void write() throws IOException {
		MemberDto member = new MemberDto("이동준","서울",23);
		
		FileOutputStream fo = new FileOutputStream("C:\\ssafy\\test.ser");
		ObjectOutputStream out = new ObjectOutputStream(fo);
		
		out.writeObject(member);
		out.close();
	}
}
/* 1번 예외 케이스 [1]번의 serialVersionUID 수정
Exception in thread "main" java.io.InvalidClassException: MemberDto; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2

/* 2번 예외 케이스 [2]번의 새로운 필드 추가
Exception in thread "main" java.io.InvalidClassException: MemberDto; local class incompatible: stream classdesc serialVersionUID = 7169820433892352033, local class serialVersionUID = 6077652754431604139
	
*/

/* MemberDto */
import java.io.Serializable;

public class MemberDto implements Serializable {

    private static final long serialVersionUID = 2L; // [1]
	private String name;
	private String addess;
	private int age;
	private String nick; // [2]
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddess() {
		return addess;
	}
	public void setAddess(String addess) {
		this.addess = addess;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "MemberDto [name=" + name + ", addess=" + addess + ", age=" + age + "]";
	}
	
	public MemberDto() {}
	
	public MemberDto(String name, String addess, int age) {
		super();
		this.name = name;
		this.addess = addess;
		this.age = age;
	}
	
	
}

```