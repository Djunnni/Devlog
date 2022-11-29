## JUnit을 활용한 테스트코드 작성

JUnit은 자바 언어에서 사용되는 대표적인 테스트 프레임워크로서 단위 테스트를 위한 도구를 제공합니다.

또한 단위 테스트뿐만 아니라 통합 테스트를 할 수 있는 기능도 제공합니다. JUnit의 가장 큰 특징은 어노테이션 기반의 테스트 방식을 지원한다는 점. 몇개의 어노테이션만으로 간편하게 테스트 코드를 작성할 수 있습니다. 또한 JUnit을 활용하면 단정문을 통해 테스트케이스의 기대값이 정상적으로 도출됐는지 검토할 수 있는 장점이 있습니다.

### JUnit의 세부 모듈

JUnit5는 3가지 모듈로 구성됩니다.

#### JUnit Platform

JUnit Platform은 JVM에서 테스트를 시작하기 위한 뼈대 역할을 합니다. 테스트를 발견하고 테스트 계획을 생성하는 테스트 엔진의 인터페이스를 가지고 있다. 테스트 엔진은 테스트를 발견하고 테스트를 수행하며 그 결과를 보고하는 역할을 수행합니다. 또한 각종 IDE와의 연동을 보조하는 역할을 수행합니다.

#### JUnit Jupiter
테스트 엔진 API의 구현체를 포함하고 있으며, JUnit5 에서 제공하는 Jupiter기반의 테스트를 실행하기위한 Test엔진을 가지고 있습니다. 테스트의 실제 구현체는 별도 모듈의 역할을 수행하는데 그중 하나가 Jupiter Engine입니다. Jupiter Engine은 Jupiter API를 활용해 작성한 테스트 코드를 발견하고 실행하는 역할을 수행

#### JUnit Vintage

JUnit 3,4에 대한 Test엔진 API를 구현하고 있습니다. JUnit3,4 테스트코드를 실행할 때 사용되며 Vintage 엔진을 포함하고 있다.


<table style="border:1px solid">
    <tbody>
        <tr>
            <td style="border: 1px solid">vintage</td>
            <td style="border: 1px solid">jupiter</td>
        </tr>
        <tr>
            <td style="border: 1px solid; text-align:center" colspan="2">platform</td>
        </tr>
    </tbody>
</table>

### JUnit 생명주기

@Test : 테스트 코드를 포함한 메서드를 정의합니다.

@BeforeAll: 테스트를 시작하기 전에 호출되는 메서드를 정의합니다.

@BeforeEach: 각 테스트 메서드가 실행되기 전에 동작하는 메서드를 정의합니다.

@AfterAll: 테스트를 종료하면서 호출되는 메서드를 정의합니다.

@AfterEach: 각 테스트 메서드가 종료되면서 호출되는 메서드를 정의합니다.

```java
package com.springboot.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll() {
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("## AfterAll Annotation 호출 ##");
        System.out.println();
    }

    @BeforeEach
     void beforeEach() {
        System.out.println("## BeforeEach Annotation 호출 ##");
        System.out.println();
    }

    @AfterEach
     void afterEach() {
        System.out.println("## AfterEach Annotation 호출 ##");
        System.out.println();
    }

    @Test
    void test1() {
        System.out.println("## Test1 시작 ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2!!!")
    void test2() {
        System.out.println("## Test2 시작 ##");
        System.out.println();
    }

    @Test
    @Disabled
    void test3() {
        System.out.println("## Test3 시작 ##");
        System.out.println();
    }
}
/*
결과 ====>

## BeforeAll Annotation 호출 ##

## BeforeEach Annotation 호출 ##

## Test1 시작 ##

## AfterEach Annotation 호출 ##

## BeforeEach Annotation 호출 ##

## Test2 시작 ##

## AfterEach Annotation 호출 ##


void com.springboot.test.TestLifeCycle.test3() is @Disabled
## AfterAll Annotation 호출 ##

*/
```