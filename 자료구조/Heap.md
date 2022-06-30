### Heap

##### MaxHeap vs MinHeap

MaxHeap : 루트가 최대값인 경우,
MinHeap : 루트가 최소값인 경우,

##### Add:

insert next available space

tricke up

1. 비어있는 공간에 노드를 추가합니다.
2. 부모 노드보다 큰 숫자인지 확인하고 만약 그렇다면 두 노드를 바꿉니다. (trickle up)

##### Remove:

remove the root

replace w/ last element

tricle down

 - swap with the large of the children


1. 루트를 제거합니다.
2. 트리의 마지막 요소를 루트에 넣어줍니다.
3. 루트에서 시작하여 두 자식 중 큰 노드와 바꿔주어 힙의 규칙을 만족하게 합니다. (trickle down)

무언가를 제거할 때 힙에서는 항상 루트를 제거해야 합니다.

##### 부모 자식간의 index

children: 2 * parent + 1 또는 2 * parent + 2
parent: floor((child-1)/2)

##### 힙 정렬 알고리즘
O(nlogn)
n개의 숫자를 logn과 비교를 한다.
숫자들의 순서를 바꿔 정렬을 하기 때문에 데이터 복사본을 만들 필요가 없다는 장점이 있다.


```java

public class Heap<E> {
    int lastPosition;
    E[] array;

    Heap(int size) {
        array = (E[]) new Object[size];
        lastPosition = 0;
    }
    public void add(E obj) {
        array[++lastPosition] = obj;
        trickleUp(lastPosition);
    }
    public void swap(int parent, int position) {
        E temp = array[parent];
        array[parent] = array[position];
        array[position] = temp;
    }
    public void trickleUp(int position) {
        if(position == 0) {
            return;
        }
        int parent = Math.floor((position - 1) / 2);
        if(((Comparable<E>) array[position]).compareTo(array[parent]) > 0) {
            swap(position, parent);
            trickleUp(parent);
        }
    }
    public E remove() {
        E temp = array[0];
        swap(0, lastPosition--);
        trickleDown(0);
        return E;
    }
    public void trickleDown(int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        if(left == lastPosition && ((Comparable<E>) array[left]).compareTo(array[parent]) < 0) {
            swap(left, parent);
            return;
        }
        if(right == lastPosition && array[parent] < array[right]) {
            swap(parent, right);
            return;
        }

        if(left >= lastPosition || right >= lastPosition) {
            return;
        }

        if(array[left] > array[right] && array[parent] < array[left]) {
            swap(left, parent);
            trickleDown(left);
        } else if(array[parent] < array[right]) {
            swap(parent, right);
            trickleDown(right);
        }
    }
}

```