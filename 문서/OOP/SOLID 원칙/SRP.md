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
