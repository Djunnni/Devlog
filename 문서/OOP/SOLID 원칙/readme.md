## SOLID 원칙

### 1. SRP(Single Responsibility Principle)

객체는 하나의 책임(목적,역할)을 지녀야한다.

예시) 

개발자면서 가정을 꾸린 가장이면 2가지의 역할을 하나의 클래스에서 하고 있다. 이 부분을 쪼개보자.

#### SRP를 지키지 못하는 경우
```java
/**
 *  학교의 역할
 *  1. 학생을 조인시키기
 *  2. 전국 학교 랭킹을 조회
 */
public interface School {
    void initial(GeoLocation location);
    boolean joinStudent();
    int getCount();
    RankingBoard getNationalSchoolRanking(); // 억지 함수
    SchoolInfoXML printSchoolInfoForXML(); // 억지 함수 
}

public class ElementarySchool implements School {
    // 구현되었다고 가정하자.
}
// RankingBoard를 School에게 맡기는 걸 고려해보면 따로 클래스로 빠져나와도 되지 않을까?
// 학교가 학생을 모집하는 학교, 스코어 보드를 가지는 학교가 되어 있다.
// xml이 아니라 json 등 기타 포맷으로 받고 싶은 경우라면!?
```

#### SRP에 맞춰 변경해본 경우
```java
// 아래의 랭킹보드를 담당해주는 클래스가 있다라면 더 명확해진다.
public interface SchoolRanking {
    RankingBoard getNationalInfo(School school)
}

public interface enableXML {
    XML print();
}

public interface enableJSON {
    JSON print();
}

public interface School {
    void initial(GeoLocation location);
    boolean joinStudent();
    int getCount();
}

public class ElementarySchool implements School, enableJSON {
    // 학교를 구현, JSON으로 데이터를 받을 수 있다.
}

```

### 2. OCP(Open-Close Principle)

class는 확장에 개방 수정에 폐쇄정책을 가지는데 부모를 상속받는 자식에서 추가/수정에 관대하며 자식으로 인해 부모의 코드가 수정됨을 지양한다.

예를 들면

동물 인터페이스 또는 추상클래스가 있고 구현체로 사람, 치타, 물개가 있다고 하면 2족보행, 4족보행, 몸으로 이동하는 건 동물을 상속받은 자식객체에서 수정하고 있다.

자식들로인해 부모가 수정될 필요는 없다.

### 3. LSP(리스코프 치환 원칙)

자식 class는 언제나 부모 class를 교체할 수 있다. (부모 클래스의 위치에 자식 클래스를 넣어도 어떤 이슈도 없어야 한다)

[참고 사이트](https://blog.itcode.dev/posts/2021/08/15/liskov-subsitution-principle)

### 4. ISP(인터페이스 분리 원칙)

클라이언트가 자신과 관련이 없는 인터페이스는 구현하지 않아야한다.

예시1)

 게시판에는 CRUD 기능이 있다. 게시판은 SRP는 만족한다. 어드민 계정에서는 CRUD가 모두 사용이 가능하나 유저계정에서는 CRU는 가능하고 D는 불가능하다. 

이경우에 게시판으로부터 받은 기능을 구현하는데 자신과 관련이 없는 D기능으로인해 ISP가 성립하지 못한다.
> 이 예시는 내생각에 살짝 억지가 있는 부분이다. 이 부분에서 모든 코드가 SOLID를 맞춰 개발하는 건 쉽지 않다고 생각했고 어느정도 효용범위가 존재한다고 본다. 모든 원칙을 지키게 되면 복잡도가 높아질 수 있다고 보아
> 이 경우 유저계정에서는 throw Exception을 발생하는게 낫다고 판단했다.

예시2)

Animal 보다는 barkable, walkable, eatable로 쪼개어 구현한다.

### 5. DIP(의존성 역전 법칙)

고차원 모듈이 저차원 모듈에 의존하면 안된다. 부모 클래스는 자식 클래스에 의존해서는 안된다는 원칙

쉽게 생각하면 Interface를 타입으로 이용해 범용성을 높이는 원칙이라고 보면 좋다.

대표적인 예시로는 Collections 하위에 있는 List와 Set계열이라고 생각하자.


### 정리

예시를 들어 생각해보면 항상 SOLID 원칙을 지키며 개발하는 건 쉽지 않다. 대신 이로인해 지속적인 개발과 리팩토링을 통해서 구조를 상황에 맞게 잡아가야한다고 생각한다.

또한 디자인패턴이 해당 원칙들이 녹여들었다고 생각이 들어 앞으로 디자인패턴을 공부하면서 위 원칙들을 대입해볼 예정이다. (2022-12-02)