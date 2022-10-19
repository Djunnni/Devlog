## Iterator와 Enumeration의 차이

### 서론 
Spring에서 Session 처리를 다루던 중 교수님이 Enumeration을 쓰는 경우를 발견했다.

왜 그랬을까? 무슨 차이가 있어서 이 부분에서 Iterator이 아니었을까? 찾아보자!

### HttpSession의 getAttributeNames()는 Enumeration<String>을 돌려줍니다.

HttpSession의 getAttributenames()는 `Enumeration<String>`을 돌려줍니다.

Enumeration은 hasMoreElements(), nextElement()로 순회를 할 수 있다고 한다.

### Iterator와 Enummeration의 차이는 뭐가 있지?

1. Iterator의 remove는 Enumeration에는 없다.

2. snap-shot, fail-fast 지원 차이

Enumeration은 반복을 시작하기전에 원본 데이터에 대한 snap-shot을 찍고 해당 snap-shot을 반복한다.

원본이 아닌 사본으로 반복을 하다보니 원본데이터가 중간에 바뀌어도 문제가 없이 반복을 끝낸다.

- 단점
    - snap-shot을 찍을 때 생기는 비용
    - snap-shot과 원본간 데이터 불일치 문제

> 이 부분을 보완하고자 Iterator는 snap-shot을 안찍고 바로 원본 데이터를 바라보고 진행해 데이터에 변경이 발생하면 예외를 발생시키게 된다.
이 내용은 [fail-safe vs fail-fast iterator](./fail-safe_vs_fail-fast_iterator.md)에서 소개를 한 적이 있으니 읽어보면 좋다.

### Iterator 인터페이스 추가 전까지 사용된 Enumeration

=> Vector, HashTable과 같이 컬렉션 중 레거시에서만 사용이 가능하다. (범용커서가 아니다)
=> Fail-Safe로 동시수정 예외를 throw하지 않는다.
=> 열거를 사용해 제거 작업은 불가능하다. (읽기전용 인터페이스)

### 정리

Session에서 Enumeration을 썼을 이유를 보면 snap-shot을 통해서 현재 가지고 있는 정보들에 한해서만 자유로이 처리가 가능하게 하는게 더 나을 수도 있겠다는 생각도 든다. 읽기 전용이면 충분하기 때문이다.
iterator와 enumeration의 차이도 알았고 앞으로 잘 써봐야겠다.

### 참고

[geeksforgeeks - difference_between_iterator_and_enumeration](https://www.geeksforgeeks.org/difference-between-iterator-and-enumeration-in-java-with-examples/)

