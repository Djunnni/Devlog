### 빌드패턴

#### 스스로 생각해본 빌드패턴은?

빌드패턴을 사용하면 어떤 좋은 점이 있을까?

1) 생성자가 너무 길어져 아규먼트가 무엇인지 파악하기 힘든 문제를 해결해준다.
2) 생성자나 Setter를 통해 인스턴스의 데이터가 온전하기 전까지 에러가 발생하면 오작동이 적어진다.
3) 구현 로직은 복잡할 수 있어도 사용하는 경우에는 단순하다.

```
import java.time.LocalDateTime;

public class BuilderPatternTest {
	public static void main(String[] args) {
		Student dongjoon = Student.builder()
				.name("이동준")
				.age(28)
				.address("수원시 영통구")
				.registTime(LocalDateTime.now())
				.build();
		System.out.println(dongjoon);
	}
}

class Student {
	private String name;
	private int age;
	private String address;
	private LocalDateTime registTime;
	
	/* static inner class로 선언 */
	static class Builder {
		private String name;
		private int age;
		private String address;
		private LocalDateTime registTime;
		
		Builder() {
		}
		public Builder age(int _age) {
			this.age = _age;
			return this;
		}
		public Builder name(String _name) {
			this.name = _name;
			return this;
		}
		public Builder address(String _addr) {
			this.address = _addr;
			return this;
		}
		public Builder registTime(LocalDateTime now) {
			this.registTime = now;
			return this;
		}
		public Student build() {
			return new Student(this);
		}
	}
	
	/* build 방식으로만 생성하는 걸 허용하므로 기본 생성자는 private 처리 합니다. */
	private Student() {}
	
	/* build 직전에 Student 필드로 빌드의 데이터를 옮기기 */
	private Student(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.address = builder.address;
		this.registTime = builder.registTime;
	}
	public static Builder builder() {
		return new Builder();
	}

	/* 별도의 Setter는 만들지 않기 : 기타 수정을 불허함. */
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public LocalDateTime getRegistTime() {
		return registTime;
	}

	@Override
	public String toString() {
		return "Student \n{name : " + name + ",\n age : " + age + ",\n address : " + address + ",\n registTime : "
				+ registTime + "}";
	}

	
}


```