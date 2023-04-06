
### 3. LSP(리스코프 치환 원칙)

서브타입은 언제나 자신의 기반타입(구현할 대상 등)으로 교체할 수 있어야 한다.

if문이나 instanceof를 사용하는 코드들은 LSP를 지키지 않았을 뿐더라 OCP를 지키지 않은 경우다.

| * LSP를 지키지 못한 건 -> base타입으로 변환은 가능하다. 용도나 목적에 맞지 않았기 때문에 if조건이나 instanceof를 활용해 추가적인 기능을 수행하기 위함
| * OCP를 지키지 못한 건 -> 주변의 환경에 if, instanceof와 같은 예외를 주어야 처리가 가능하므로 OCP에 벗어난다.

#### LSP를 올바르게 쓰면?

기반 클래스의 사용자가 그 기반클래스에서 유도된 클래스를 기반 클래스로써 사용할 때, 특별한 것을 할 필요없이 마치 원래 기반 클래스를 사용하는 양 그대로 사용할 수 있어야한다.

즉, instanceof나 다운캐스팅을 할 필요가 없어야 한다.

**사용자가 파생 클래스에 대해서 아무것도 알 필요가 없어야 한다. 파생클래스가 존재하는 것 조차도..!**

| 제일 중요한 부분인 것 같다. 즉, 파생된 클래스에 대해 기본적인 문맥 없이도 항상 치환이 가능하며 기반 클래스의 기능을 잘 수행할 수 있다. 
| 예를들어 RuntimeException을 내부적으로 호출하는 함수가 생긴다면 그것부터가 LSP를 지키지 못한 경우가 될 수 있다고 본다.

#### 예시

```java
public abstract class Employee {
    int calcPay(); // 급여 계산
}

public class SalariedEmployee extends Employee {
    ...
}

public class HourlyEmployee extends Employee {
    List<TimeCard> timecards; // 시간당 기록 근무내역
    ...
}
```

`Employee`를 기반으로 SalariedEmployee와 HourlyEmployee가 있다. 봉급을 받는 사람은 급여 계산 함수를 호출할 때, 일정하게 받아갈 것이고

시간근무직원의 경우 timecard를 기반으로 시간금액을 계산해 가져갈 것이다.

그런데 `VolunteerEmployee`(자원봉사자) 클래스가 생겼다고 하자.

```java
public class VolunteerEmployee extends Employee {
    public double calcPay() {
        return 0;
    }
}
```
봉사자는 0원을 주어야 맞을 것이다. 근데 항상 이게 맞을까? 자원봉사자도 급여를 계산할 수 있는 함수기능을 제공하는 경우를 말하는 거다.

Employee를 통해 모든 객체를 다루다보면 메일도 보내질텐데 이경우 자원봉사자도 급여메일을 받게 된다. // 좀 그렇지?

예외를 던질 수도 있지만 더 안좋은 상황이 발생할 수 있다.

```java
public double calcPay() {
    throw new UnpayableEmployeeException();
}
```

바로 Employee리스트를 통해 임금을 계산할 경우 문제가 `Runtime`에서 발생하는 것이다. 그러다보니 이와같은 상황이 벌어진다.
```java
for(Employee em : employees) {
    try {
        totalPay += em.calcPay();
    } catch(UnpayableEmployeeException e) {
        // 예외처리
    }
}
```

구현부에서 내부의 문제를 알고 Exception처리를 해줘야 한다. 여기서 한 술 더뜨면 `instanceof`까지 등장하게 된다.

```java
for(Employee em : employees) {
    if(!(em instanceof VolunteerEmployee)) {
        totalPay += em.calcPay();
    }
}
```

이 모든 혼란은 LSP를 어겨서 발생한 경우다. VolunteerEmployee는 Employee대신 들어갈 수 없다. Employee는 VolunteerEmployee만 들어가도 영향을 받고 있다.

그 결과 예외와 if문 처리를 한다. -> OCP에 어긋난다.

유도된 클래스의 함수를 호출하는 행위를 불법으로 만드려고 할때마다 LSP를 어긴다. 그렇다고 아무것도 안하는 것도 LSP를 어긴다.

| 지저분한 예외를 사용하거나 instanceof를 검사할 수 밖에 없는게 LSP를 어긴거다.

#### 예시를 어떻게 처리해야 하나?

VolunteerEmployee는 직원모델이 아니다. 그러므로 Employee에서 파생해선 안되고

구현부의 calcPay [서비스 로직에서] 가 호출되는 곳에 전달해서도 안된다.

