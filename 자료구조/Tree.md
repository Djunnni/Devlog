### Tree

##### 완전트리

모든 잎이 아닌 노드가 2개의 자식 노드를 가지고 있고 마지막 줄은 왼쪽에서 오른쪽 순서로 채워져 있는 트리입니다.

##### 정트리

모든 잎이 아닌 노드가 2개의 자식 노드를 가지고 있고 모든 잎이 같은 레벨에 있는 트리입니다.

#### 순회

순회를 돌 때, 서브트리를 생각하면서 돌면 쉽다.

![tree-traversal](../img/tree-traversal.png)

#### 깊이 우선 탐색
재귀를 이용해 푸는 경우가 많음

##### 전위 순회
- rootNode - left - right (파랑)
표현에 따라 연산자 우선순위를 적용하기 힘들어 계산하기 어렵다.

##### 중위 순회
- left - rootNode - right (노랑)

##### 후위 순회
- left - right - rootNode (초록)
연산자 우선순위와 상관없이 계산이 가능하다.


#### 너비 우선 탐색
레벨순으로 트리 노드에 넘버를 붙인다.

```java

public class Node<E> {
    E data;
    Node<E> left, right;

    public Node(E obj) {
        this.data = obj;
        left = right = null;
    }
}
```