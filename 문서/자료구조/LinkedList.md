### LinkedList

링크드 리스트는 배열과 다르게 추가될 요소들의 크기만큼만 추가, 제거가 된다.

배열의 경우, 처음 선언을 할 때 크기가 정해지기 때문에 공간이 낭비 또는 부족이 될 수 있다.

이런점에서 링크드리스트가 장점이 될 수 있다.

#### LinkedList 구성요소

Node이다. next와 data로 구성되어 next는 다음 Node를 가리키게 된다.

Head를 이용해 연결을 할 수 있게 된다.

#### LinkedList 크기 
LinkedList의 크기는 2가지 방법으로 확인 가능하다.

1. 매번 전체 길이를 알고 싶을 때, head에서부터 tail까지 길이를 재는 O(n) 방법.
2. 추가/제거 될 시점에 count를 세는 방법 O(1)

#### 경계조건(Boundary Conditions)

어떤 자료구조든 고려해야할 경계조건이 있다.

1. 자료구조가 비어있을 때,
2. 자료구조에 하나의 요소가 들어있을 때,
3. 자료구조의 첫 번째 요소를 제거/추가할 때,
4. 자료구조의 마지막 요소를 제거/추가할 때,
5. 자료구조의 중간을 처리할 때,

#### LinkedList 코드

```java
public class LinkedList<E> implements List<E> {
    class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        if(head == null) {
            node.next = head = tail;
            head = node;
            currentSize++;
            return;
        }
        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);
        if(head == null) {
            head = tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }
    public E removeFirst() {
        if(head == null) { // 경계조건 1번
            return null;
        }
        E tmp = head.data;
        if(head == tail) { // 경계조건 2번
            head = tail = null;
        } else {
            head = head.next;
        }
        currentSize--;
        return tmp;
    }
    public E removeLast() {
        if(head == null) {
            return null;
        }
        if(head == tail) {
            return removeFirst();
        }
        Node<E> current = head;
        Node<E> previous = null;

        while(current != tail) {
            previous = current;
            current = current.next;
        }
        tail = previous;
        previous.next = null;
        currentSize--;

        return current.data;
    }
    public E remove(E obj) {
        Node<E> previous = null, current = head;

        while(current != null) { // 경계 조건 1
            if(((Comparable<E>) obj).compareTo(current.data) == 0) {
                if(current == head) { // 경계조건 2, 경계조건 3
                    return removeFirst();
                }
                if(current == tail) { // 경계조건 4
                    return removeLast();
                }
                currentSize--;  // 경계조건 5
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }
    public boolean contains(E obj) {
        Node<E> current = head;
        while(current != null) { // 경계 조건 1
            if(((Comparable<E>) obj).compareTo(current.data) == null) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public E peekFirst() {
        if(head == null) {
            return null;
        }
        return head.data;
    }
    public E peekLast() {
        if(tail == null) {
            return null;
        }
        return tail.data;
    }
}
```

#### 이중 연결 리스트

Node상에 prev를 두어 연결하기.
장점은 Node삭제시 상수시간이 걸린다.

#### 원형 연결 리스트

원형인지 확인은 어떻게 하는게 좋을까?

1. tail의 Next가 head인지 인지한다 O(1)
2. head부터 시작해 next가 null이 아닌지 또는 다시 head로 돌아오는지 O(n)
3. 두개의 임시 포인터를 두어 시작점을 잡고 currentSize만큼 돌고 다시 포인터를 이동하는 방법 O(n ^ 2)