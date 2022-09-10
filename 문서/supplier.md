### Supplier\<T\> 사용

Supplier를 통해서 Lazy Evaluation을 해보고 장점을 알아보자.

```java
import java.util.function.Supplier;

public class LazyEvaluation {
    public static void main(String[] args) {
        Supplier<String> helloSupplier = () -> "hello ";

        System.out.println(helloSupplier.get() + "world");
    }
}
```

Supplier는 get()을 내장하고 있는데 <T>에 맞는 타입의 Value를 리턴합니다.
  
### Sleep 예시
```java
package TEST;

import java.util.concurrent.TimeUnit;

public class LazyEvaluation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        findItem(0, getExpensiveValue());
        findItem(-1, getExpensiveValue());
        findItem(-2, getExpensiveValue());

        long end = System.currentTimeMillis();

        System.out.println(((end - start) / 1000) + " Seconds");
    }
    public static String getExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return "Daniel";
    }
    public static void findItem(int num, String value) {
        if(num < 0) {
            System.out.println("Item not exist");
        } else {
            System.out.printf("Item %d : %s \n", num, value);
        }
    }
}
                   
결과
Item 0 : Daniel 
Item not exist
Item not exist
9 Seconds
```
### Supplier<T> 적용 후
```java
  package TEST;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LazyEvaluation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        findItem(0, () -> getExpensiveValue());
        findItem(-1, () -> getExpensiveValue());
        findItem(-2, ()  -> getExpensiveValue());

        long end = System.currentTimeMillis();

        System.out.println(((end - start) / 1000) + " Seconds");
    }
    public static String getExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return "Daniel";
    }
    public static void findItem(int num, Supplier<String> value) {
        if(num < 0) {
            System.out.println("Item not exist");
        } else {
            System.out.printf("Item %d : %s \n", num, value.get());
        }
    }
}
Item 0 : Daniel 
Item not exist
Item not exist
3 Seconds
```
                   
