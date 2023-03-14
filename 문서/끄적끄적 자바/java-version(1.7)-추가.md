### java-version(1.7)-추가

### Fork/Join

Fork : 작업을 여러개로 나누어 계산
Join: 나누어서 작업한 결과를 모으기

여기에 java7부터는 Fork/Join과정에서 `Work Stealing` 개념이 추가된다.

#### `Work Stealing`이란?

어떤 작업이 대기하고 있는 큐가 있다고 할 때, 한쪽만 끝이 아니라 양쪽이 끝인 경우 Dequeue라고 한다. 여러개의 Dequeue작업에 나뉘어져 어떤 일이 진행될 때, 만약 하나의 Dequeue는 너무 바쁘고, 다른 Dequeue는 바쁘지 않을 경우가 있다.

이 상황에서 할 일이 없는 Dequeue가 바쁜 Dequeue의 대기하고 있던 작업을 가져가서 해주는 개념이다.

이러한 개념이 기본적으로 Fork/Join에 포함된다.

#### Fork/Join 작업의 기본 수행 개념
```java
if(작업단위가 충분히 작을 경우) {
    // 해당 작업을 수행
} else {
    // 작업을 반으로 쪼개어 두 개의 작업으로 나눔
    // 두 작업을 동시에 실행시키고, 두 작업이 끝날 때까지 결과를 기다림
}
```

회귀적으로 수행될 때, 많이 사용

java.util.concurrent 패키지에 RecursiveAction과 RecursiveTask라는 abstract 클래스를 사용해야 한다.

* java.util.concurrent
    * RecursiveAction
        * Generic: false
        * 결과 리턴: false
    * RecursiveTask
        * Generic: true
        * 결과 리턴: true

두 클래스 모두 `ForkJoinTask<V>`를 상속받아서 구현됐다.

```java
public abstract class ForkJoinTask<V> extends Object implements Future<V>, Serializable
```
| Future는 Java5부터 추가된 인터페이스로 '비동기적인 요청을 하고 응답을 기다릴 때 사용'

작업을 수행하는 클래스로 RecursiveTask, RecursiveAction 클래스를 확장하여 개발하고 모두 compute 메서드가 있다.

그리고나서 ForkJoinPool 클래스를 사용해 작업을 시작한다.

```java
ForkJoinPool mainPool = new ForkJoinPool();
mainPool.execute(ForkJoinTask); // ForkJoinTask.fork(); 비동기적 호출 수행
mainPool.invoke(ForkJoinTask); // ForkJoinTask.invoke(); 호출 후 결과 대기
mainPool.submit(ForkJoinTask); // ForkJoinTask.fork(); 호출 후 Future 객체 수신
```

[연습코드](/%EC%BD%94%EB%93%9C%20%EC%97%B0%EC%8A%B5%EC%9E%A5/forkjoin/)에서 살펴볼 수 있다.

JVM에서 알아서 쓰레드 작업을 진행하게 된다.

### WatchService 클래스가 추가됨

이전까지는 파일이 변경되었는지 확인할 때, lastModified를 체크하는 꼼수를 써야했다.

```java
long lastModified = -1;
public boolean fileChangeCheck(String fileName) {
    boolean result = false;
    FIle file = new File(fileName);
    long modifiedTime = file.lastModified(); // 내부적으로 연계 메서드가 많아 성능에 영향이 적지 않음.
    if(lastModified == -1) {
        lastModified = modifiedTime;
    } else {
        if(modifiedTime != lastModified) {
            result = true;
        }
    }
    return result;
}

```

이런 단점을 보완하고자 `WatchService`라는 인터페이스가 제공됨. 이 `WatchService`는 항상 지키고 있는 담당자가 문제가 발생했을 때만 알려준다.

[WatcherSample](/%EC%BD%94%EB%93%9C%20%EC%97%B0%EC%8A%B5%EC%9E%A5/niosecond/WatcherSample.java)에서 확인 가능하다.

