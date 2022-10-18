### Strong / Soft / Weak / Phantom References
몇개 글을 찾아보면 모바일 앱에서 메모리관리에 신경을 쓰다보면 관리가 필수적이라고 한다.
Java의 GC에 의해 메모리가 관리되긴하지만 메모리 수거가 발생하지 않는 참조에 대해서는 OOM(Out Of Memory) Low Memory가 발생할 수 있다.

자바는 참조유형이 4가지다.

참조 유형에 따라 GC 처리 실행 대상여부와 시점이 달라진다. 

Strong -> Phantom으로 갈수록 GC 처리가 앞당겨진다.

#### 1. Strong Reference (강한 참조)

```java
Object item = new Object(); // item 변수가 참조를 가지고 있는 한, GC의 대상이 되지 않는다.
item = null // item은 이제 null 처리가 되고 GC에 의해 메모리 반환이 일어날 수 있어졌다.
```

#### 2. Soft Reference (소프트 참조)
객체를 참조하는 경우가 SoftReference만 있을 경우 GC의 대상이 된다.
단, 메모리가 부족한 경우에만 제거되며 부족하지 않는다면 굳이 제거하진 않는다.

```java
import java.awt.*;
import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    public static void main(String[] args) {
        Point p = new Point(1, 2);

        SoftReference<Point> softRef = new SoftReference<>(p);

        p = null;

        System.gc();

        System.out.println(softRef.hashCode());
        System.out.println(softRef.get());
    }
}

```

#### 4. Weak Reference (약한 참조)
다음 GC 실행 시 무조건 힙 메모리에서 제거된다.
```java
import java.awt.*;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {
    public static void main(String[] args) {
        Point p = new Point(1, 2);

        WeakReference<Point> weekRef = new WeakReference<>(p);

        p = null; //  weekRef만 new Point(1,2)에 연결되어 있게됨.

        System.gc(); // GC가 동작하게 적용하면 메모리가 남은 여부 상관없이 weekRef는 힙 메모리에서 제거된다.

        System.out.println(weekRef.hashCode());
        System.out.println(weekRef.get()); // null
    }
}

```
#### 5. PhantomReference

#### 6. WeakReference에 StrongReference 지정일 경우
```java
import java.awt.*;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {
    public static void main(String[] args) {
        Point p = new Point(1, 2);

        WeakReference<Point> weekRef = new WeakReference<>(p);

        p = null;

        System.out.println(weekRef.hashCode());
        System.out.println(weekRef.get());

        Point tempP = weekRef.get(); // StrongReference 연결
        System.out.println(tempP);
        // tempP = null; // StrongReference를 null 처리 안하면 GC를 돌아도 weekRef는 GC가 메모리 반환을 할 수 없다.

        System.gc();
        
        System.out.println(weekRef.hashCode());
        System.out.println(weekRef.get());
    }
}

```
