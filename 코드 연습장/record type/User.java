import java.util.Objects;

/**
 * java14 이후
 * final 변수로 이루어진 id, name을 가지고 있다.
 * 요소에 접근 시, id(), name()을 사용하게 된다.
 * default 생성자를 통해서 id, name에 대해 제한을 걸 수 있다. 
 */
public record User(Long id, String name) {
	public User {
		Objects.requireNonNull(id, "아이디를 넣어주세요.");
		Objects.requireNonNull(name, "이름이 필요합니다.");
		if(name.isEmpty()) {
			throw new RuntimeException("이름이 빔");
		}
	}

	public final void getInfo() {
		System.out.println(id + ": " + name);
	}
}
