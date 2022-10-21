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
### 무조건 작성하자.

