## equals 오버라이딩 시, 지켜야할 규칙

1. reflexive(재귀): null이 아닌 x라는 객체의 x.equals(x)는 항상 true
2. symmetric(대칭): null이 아닌 x,y 객체가 있을 때, y.equals(x)가 true라면 x.equals(y) 도 참이다.
3. transitive(타동적): null이 아닌 x,y,z가 있을 때, x.equals(y)가 true고 y.equals(z)가 true면 x.equals(z)도 true 다.
4. consistent(일관적): null이 아닌 x와 y가 있을 때, 객체 상태가 변경되지 않은 상황에서 몇번이나 x.equals(y)는 항상 true or false다.
5. null과의 비교: null이 아닌 x라는 객체의 x.equals(null)은 항상 false다.

자바 API문서상에 적힌 규칙이다.

### equals 메서드를 overriding시, hashCode도 함께 재정의 해야한다. 

equals 메서드를 오버라이딩해서 객체가 서로 같다고 이야기할 수 있지만 그 값이 같다고 해서 객체의 주소값이 같지 않기 때문이다.

| 항상 객체를 구현할 때, equals, hashCode, toString은 상황에 맞게 재정의를 해야하는 걸 고려하자.

hashCode의 규칙

1. 자바 애플리케이션이 수행되는 동안에 어떤 객체에 대해서 이 메소드가 호출될 때에는 항상 동일한 int를 리턴해줘야한다. 하지만 자바를 실행할 때마다 같은 값이어야 할 필요는 없다.

2. 어떤 두 객체에 대해 equals() 메소드를 사용해 비교한 결과가 true일 경우, 두 객체의 hashCode메소드를 호출하면 동일한 int 값을 리턴해야 한다.

3. 두 객체를 equals 메서드를 사용하여 비교한 결과 false를 리턴했다고 해서, hashCode를 호출한 int 값이 무조건 달라야할 필요는 없다. 이 경우에 서로 다른 int 값을 제공하면 hashTable의 성능을 향상시키는데 도움된다.

### IDE가 제공하는 오버라이딩 기술을 활용해 hashCode와 equals를 재정의 하라.
