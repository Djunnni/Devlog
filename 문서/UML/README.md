## UML

소프트웨어 생명주기에서 '고객의 요구사항 분석'과 '설계'단계의 결과물이라고 생각한다.

그렇다면 UML을 어떻게 작성해야하는지 필수로 알아야 할 사항들을 정리해보자.

### UML 기본 알아야할 사항

1) 클래스
    - 요소
        - 속성
            - visibility name : attribute type [multiplicity] = default value
        - 행동
            - visibility name (parameter list) : type of value return
        - 참고
            - static : Attribute/ Operation인 경우 밑줄그어 표기
            - abstract : 이텔릭체
            - 접근 제어자

                <table>
                    <thead>
                        <tr>
                            <th>기호</th>
                            <th>접근제어자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>+</td>
                            <td>public</td>
                        </tr>
                        <tr>
                            <td>-</td>
                            <td>private</td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>protected</td>
                        </tr>
                        <tr>
                            <td>~</td>
                            <td>package</td>
                        </tr>
                    </tbody>
                </table>

2) 관계 표현

    - 2-1) 연관(association) 관계
        - 레퍼런스를 지속적으로 유지하는 경우
        - 표기방법 : 실선
    - 2-2) 집합(aggregation) 관계
        - 연관 관계 일종으로 배열 또는 집합으로 여러개를 관리하는 대상일 때,
        - 표기방법 : 실선 + 속이 빈 다이아몬드 화살표
    - 2-3) 합성(composition) 관계
        - 연관 관계 일종으로 객체의 생성 및 반환 때까지 항상 레퍼런스를 유지하고 있을 경우,
        - 표기방법 : 실선 + 속이 찬 다이아몬드 화살표
    - 2-4) 의존(dependency) 관계
        - 의존관계란 연관관계와는 달리 레퍼런스를 계속 유지하고 있지 않다. 어떻게 보면 변수로나 함수안에서 잠시 쓰이고 메모리가 반환되는 경우를 말한다.
        - 로컬 변수
        - 함수 파라미터
        - 팩토리
        - 표기방법 : 점선 + 화살표
    - 2-5) 상속(inheritance) 관계
        - 클래스를 상속 받았을 때,
        - 표기방법 : 실선 + 속이 빈 화살표

    - 2-6) 구현(realization) 관계
        - 인터페이스를 구현했을 때,
        - 표기방법 : 점선 + 속이 빈 화살표


### 참고 사이트

https://thinking-jmini.tistory.com/26