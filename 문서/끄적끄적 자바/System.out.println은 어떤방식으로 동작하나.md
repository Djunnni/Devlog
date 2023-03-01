## System.out.println은 어떤방식으로 동작하나

```java
System.out.println(1); // 1
System.out.println("1"); // 1

List<String> list = new LinkedList<>();
System.out.println(list); // []

Object item = null;
System.out.println(item); // null
```

println에 대해서 어떻게 동작하는 지 알아둘 필요가 있다.

Object의 경우 toString이 내부적으로 불린다고 하는데 한가지 이해안갈때가 있다. 바로 null이다. null.toString()은 에러를 유발하기 때문이다.

그렇다면 어떻게 내부적으로 처리를하는지 보자.

```java
//System.out 내부
public void println(String x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }
public void print(Object obj) {
    write(String.valueOf(obj));
}
```

String.valueOf를 기본적으로 감싸고 있다. String.valueOf의 역할은 null인지 판단하고 null이면 null을 아니면 toString()을 호출해준다.

```java
 public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }
```

그리고 println은 동기적으로 동작하는데 synchronized 덕분이다.

### 정리

1) 내부적으로 출력시에 `Object.toString()`을 바로 호출하는게 아닌 `String.valueOf()`로 `null` 검증을 거친다.
2) synchronized로 인해 동기적으로 출력된다.
