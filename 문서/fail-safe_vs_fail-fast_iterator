### fail safe vs fail-fast (iterator)

다중스레드로 넘어갔을 때, 동시수정을 하다보면 문제가 발생할 수 있다.
이 개념을 fail-safe, fail-fast로 정의를 해두고 있던데 java SE에서는 fail-safe에대해 용어를 사용하지 않으나 fail-fast와 non-fail-fast를 분리하기 위해 fail-safe에대해 언급을 한다.

* 동시 수정 * : 프로그래밍에서 동시수정은 다른 작업이 이미 실행중일 때, 동시에 개체를 수정하는 것을 의미한다.

자바에서는 다른 스레드가 컬렉션을 반복할 때, 컬렉션을 수정하면 일부 Iterator에서 이 동작을 감지해 ConcurrentModificationException 예외가 발생한다.

#### fail-fast iterators

Fail-Fast Iterator의 경우 수정이 있는 경우 즉시 ConcurrentModificationException 예외가 발생한다. 구조적 수정은 스레드가 해당 컬렉션을 반복하는 동안 컬렉션에 요소를 추가, 제거를 의미한다.
대표적인 클래스는 ArrayList, HashMap 클래스의 Iterator가 대표적이다.

컬렉션이 수정됐는지 여부를 확인하기 위해 내부적으로 modCount를 플래그로 사용하는데 fail-fast는 다음값을 얻을때마다 modCount를 확인한다. 만약 수정이 발생하면 ConcurrentModificationException가 발생한다.

```java
// HashMap modCount 사례
 final class KeySet extends AbstractSet<K> {
        public final int size()                 { return size; }
        public final void clear()               { HashMap.this.clear(); }
        public final Iterator<K> iterator()     { return new KeyIterator(); }
        public final boolean contains(Object o) { return containsKey(o); }
        public final boolean remove(Object key) {
            return removeNode(hash(key), key, null, false, true) != null;
        }
        public final Spliterator<K> spliterator() {
            return new KeySpliterator<>(HashMap.this, 0, -1, 0, 0);
        }
        public final void forEach(Consumer<? super K> action) {
            Node<K,V>[] tab;
            if (action == null)
                throw new NullPointerException();
            if (size > 0 && (tab = table) != null) {
                int mc = modCount;
                for (int i = 0; i < tab.length; ++i) {
                    for (Node<K,V> e = tab[i]; e != null; e = e.next)
                        action.accept(e.key);
                }
                if (modCount != mc)
                    throw new ConcurrentModificationException();
            }
        }
    }

```
* 추가 메모리가 필요하지 않다.
* 컬렉션의 요소를 순회하기 위해 원본 컬렉션을 사용한다.

참고
1. iterator.remove를 통해 제거하면 예외가 발생하지 않으나 collection.remove를 사용하면 예외가 발생한다.
2. 동기화 되지 않은 채 동시수정을 하는 건 보장할 수 없기에 이 예외에 의존하는 프로그램을 작성하는 건 잘못됐다.

#### fail-safe iterators

Fail-Safe는 Fail-Fast와 달리 구조적으로 수정된 경우 예외를 throw하지 않는다. 원본 컬렉션이 아닌 컬렉션의 복제본에서 작동하기 때문에 오류 방지 반복자라고도 한다.
CopyOnWriteArrayList, ConcurrentHashMap가 대표적임. (두개는 용도가 다르다)

* 컬렉션을 반복하는 동안 수정할 수 있다.
* 컬렉션이 수정되어도 예외를 던지지 않는다.
* 컬렉션의 요소를 순회하기 위해 원본 컬렉션의 복사본을 사용한다.
* 컬렉션 복제를 위해 추가 메모리가 사용됨.


1. ConcurrentHashMap
CopyOnWriteArrayList와 달리 메모리에 클론/스냅샷을 생성하지 않을 수 있다. 자바 공식문서에서는 약한 일관성으로 설명된 의미 체계를 갖는데 코드를보자.
```java
import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
  
public class FailSafeItr {
    public static void main(String[] args)
    {
  
        // Creating a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map
            = new ConcurrentHashMap<String, Integer>();
  
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);
  
        // Getting an Iterator from map
        Iterator it = map.keySet().iterator();
  
        while (it.hasNext()) {
            String key = (String)it.next();
            System.out.println(key + " : " + map.get(key));
  
            // This will reflect in iterator.
            // Hence, it has not created separate copy
            map.put("SEVEN", 7);
        }
    }
}

결과 
=>
ONE : 1
FOUR : 4
TWO : 2
THREE : 3
SEVEN : 7
```
참고(java-docs에서) : ConcurrentHashMap에 의해 반환된 반복자는 약한 일관성이 있습니다. 

이것은 이 반복자가 동시 수정을 허용할 수 있고 반복자가 생성될 때 존재했던 요소를 순회하며 반복자의 생성 후에 컬렉션에 대한 수정을 반영할 수 있음을 의미합니다(그러나 보장되지는 않음).

#### 참고자료

https://www.baeldung.com/java-fail-safe-vs-fail-fast-iterator
https://www.geeksforgeeks.org/fail-fast-fail-safe-iterators-java/
