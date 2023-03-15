### java version 8

#### Optional

`선택적인`의미로 Optional은 Funtional 언어인 Haskell, Scala에서 제공하는 기능을 따온 것이다.
`java.util` 패키지에 있다.

```java
public final Optional<T> extends Object {}
```

final로 선언했다고 내용변경이 불가능한건 아니다. 클래스이기에 추가적인 확장은 불가능하다. 즉, 자식클래스는 만들 수 없다.

* 값 넣기

```java
private void createOptionalObjects() {
    Optinal<String> emptyString = Optional.empty(); // 데이터가 없을 경우
    String common = null;
    Optinal<String> nullableString = Optional.isNullable(common); // null이 추가될 수 있는 상황이라면
    common = common;
    Optional<String> commonString = Optional.of(common); // 반드시 데이터가 들어갈 수 있는 상황이라면
} 
```
* 값 존재 유무
```java
System.out.println(Optional.of("present").isPresent()); // true
System.out.println(Optional.ofNullable(null).isPresent()); // false
```

* 값 가져오기
```java
private void getOptionalDate(Optional<String> data) throws Exception {
    String defaultValue = "default";
    String result1 = data.get(); // 데이터가 없을 경우 null 리턴
    String result2 = data.orElse(defaultValue); // 데이터가 없을 경우 기본값으로 들어감
    Supplier<String> stringSupplier = new Supplier<String> {
        @Override
        public String get() {
            return "daniel";
        }
    };
    String result3 = data.orElseGet(stringSupplier); // 데이터가 없을경우 기본값을 들어감
    Supplier<Exception> exceptionSupplier = new Supplier<Exception>() {
        @Override
        public String get() {
            return new Exception();
        }
    };
    Spring result4 = data.orElseThrow(exceptionSupplier); // 데이터가 없을 때, 예외를 발생시키고 싶은 경우
}
```

* 언제 Optional 클래스를 쓸까?

    * null을 좀더 쉽게 처리하려고 쓴다. 잘못하면 nullPointerException이 발생할 수 있는데 이경우 optional이 좋다. 단, optional 클래스에도 잘못 값을 넣으면 NoSuchElementException이 발생할 수 있다.

| orElse(), orElseGet()에서 주의할 점이 있다.
| orElse()의 경우 내부적으로 함수가 불릴 경우 함수가 자동 수행된다. 반면 orElseGet은 함수 수행이 null일 경우에만 불리게 된다.
| 왜 그러냐면 orElse의 선언문을 살펴봐야한다.
 ```java
       public T orElse(T other) {
            return value != null ? value : other; // 함수가 들어간다면 선언시 실행됨.
       }   
 ```
 