## Singleton 패턴

### 싱글톤 패턴은 왜 사용할까?

1) 인스턴스를 하나만 만들어서 메모리 낭비를 방지하기 위함.
2) 이미 생성된 인스턴스를 사용하다보니 속도 측면에서도 이점이 있음
3) 다른 클래스간 데이터 공유가 쉽다. 싱글톤 인스턴스는 전역으로 사용되기에 다른 클래스의 인스턴스들이 접근해 사용할 수 있다. 

### 단점

1) 멀티스레드환경에서 동기화 처리를 하지 않으면 인스턴스가 2개 생성되는 경우도 존재할 수 있다. (동기화 문제 - syncronized 사용)
2) 테스트하기 어려움
    - 싱글톤 인스턴스는 자원을 공유하고 있기 때문에 테스트가 결정적으로 격리된 환경에서 수행되려면 매번 인스턴스 상태를 초기화시켜야한다. 안그러면 온전한 테스트가 수행되지 못한다.

3) 의존관계상 클라이언트가 구체 클래스에 의존하게 된다. new 키워드를 직접 사용해 클래스안에 객체를 생성하고 있으므로 SOLID 원칙중 DIP를 위반하게 되고 OCP 원칙또한 위반할 가능성이 있다.

4) 자식 클래스 생성 불가, 내부상태 변경 어려움


```java
package pattern;

public class SingletonTest {
	public static void main(String[] args) {
		Service service = Service.getInstance();
		System.out.println(service);
		
		Service service2 = Service.getInstance();
		System.out.println(service2);
		
		System.out.println(service.equals(service2));
		System.out.println(service == service2);
	}
}

class Service {
	private static Service instance;
	private Service() {
		System.out.println("Service 인스턴스는 1번 생성됩니다.");
	}
	
	public static Service getInstance() {
		if(instance == null) {
			System.out.println("Service 인스턴스가 없어서 생성합니다.");
			return instance = new Service();
		}
		System.out.println("Service인스턴스가 있어 리턴합니다.");
		return instance;
	}
	
}
/* synchronized 설정 예시
class Service {
	private volatile static Service instance;
	private Service() {
		System.out.println("Service 인스턴스는 1번 생성됩니다.");
	}
	
	public static Service getInstance() {
		if(instance == null) {
			System.out.println("Service 인스턴스가 없어서 생성합니다.");
			synchronized (Service.class) {
				if(instance == null) {
					return instance = new Service();
				}
			}
		}
		System.out.println("Service인스턴스가 있어 리턴합니다.");
		return instance;
	}
	
}
*/

```

### 참조

[테코블 - 싱글톤](https://tecoble.techcourse.co.kr/post/2020-11-07-singleton/)