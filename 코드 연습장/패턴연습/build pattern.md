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
				.age(30)
				.address("수원시 XXX")
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
	
	
	static class Builder {
		Student student;
		Builder() {
			student = new Student();
		}
		public Builder age(int _age) {
			student.setAge(_age);
			return this;
		}
		public Builder name(String _name) {
			student.setName(_name);
			return this;
		}
		public Builder address(String _addr) {
			student.setAddress(_addr);
			return this;
		}
		public Builder registTime(LocalDateTime now) {
			student.setRegistTime(now);
			return this;
		}
		public Student build() {
			return student;
		}
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getRegistTime() {
		return registTime;
	}

	public void setRegistTime(LocalDateTime registTime) {
		this.registTime = registTime;
	}

	@Override
	public String toString() {
		return "Student \n{name : " + name + ",\n age : " + age + ",\n address : " + address + ",\n registTime : "
				+ registTime + "}";
	}

	
}

```