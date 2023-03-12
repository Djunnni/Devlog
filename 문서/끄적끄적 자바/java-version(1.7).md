## Java Version 1.7

### 변경된 사항

1. 숫자 표시 방법 보완
2. switch문에서 String 사용
3. 제네릭을 쉽게 사용하는 다이아몬드(<>)
4. 예외 처리시 다중 처리가능
5. AutoCloseable 구현

### 1. 숫자 표시 방법 보완

1) 10000 표현 시, 10_000 으로 ','를 대신해 표현이 가능하다.
    단, 문자 뒤에 붙는 건 불가능 하다. (ex 0b_123_123 (X) => 0b12_3123(O))
2) 8진수, 16진수, 10진수 표현에 2진수 표현이 가능하다.
    (ex, 0b11 => 3)

### 2. Switch 표현에 String 사용가능

1) String에 switch문 가능  
    단, NullPointException이 발생할 수 있으니 String이 null인지 꼭 체크하자.

### 3. 제네릭(<>)

1) 선언 시, 제네릭을 간략화 할 수 있음

    ```java
        List<Integer> list = new LinkedList<Integer>();
        // -> 7버전 이후
        List<Integer> list = new LinkedList<>();
    ```

2) 조심해야 할 제약 사항이 있음.
    2 - 1) 다이아몬드 미 지정시 컴파일 경고 발생
    2 - 2) 다이아몬드 생성 시 유의사항 1 - 메소드 내에서 객체 생성시
    2 - 3) 다이아몬드 생성 시 유의사항 2 - 제네릭하면서도 제네릭하지 않은 객체 생성 시

3) Non-refiable varargs 타입
    | refiable은 사전적 단어는 아니다. 하지만 의미는 refiable은 실행시 그 타입을 기억하고 있는 것이며 Non-refiable은 컴파일 시, 타입손실이 발생하는 걸 말한다.

    ```java
        public static <T> boolean addAll(Collection<? extends T> c, T... element)
        // => 내부적으로 다음과 같이 Object 배열로 처리됨
        public static boolean addAll(java.util.Collection c, Object[] element)

        // => 잠재적으로 문제가 발생할 수 있다. 이 경우 @SafeVarags라는 어노테이션을 붙이면 된다. 
        // 가변 매개변수를 사용하며, final이나 static으로 선언되어야 한다.
    ```

### 4. Exception

1) 예외처리 간소화

    ```java
    // JAVA 7 이전
    try {
        server = new ClientServer();
    } catch(IOException e) {
        e.printStackTrace();
    } catch(ArrayIndexOutOfException e) {
        e.printStackTrace();
    }
    // JAVA 7 이후
    try {
        server = new ClientServer();
    } catch(IOException | ArrayIndexOutOfException e) { // 예외는 임의 지정했으므로 의미를 생각하지말고 표현만 보자.
        e.printStackTrace();
    }

    ```

2) AutoCloseable
    finally로 반드시 닫지 않아도 try 문이 끝나면 함께 close를 해준다. 더 안전하다.

    ```java
    try(Socket socket = request.accept()) {

    } catch(Exception e) {
        e.printStackTrace();
    }
    ```