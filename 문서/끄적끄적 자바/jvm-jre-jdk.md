### JVM 이해하기

#### JVM(Java Virtual Machine)

자바 가상 머신으로 자바 바이트코드(.class)를 OS에 특화된 코드로 변환 후 실행
바이트 코드를 실행하는 표준이자 구현체이다.
특정 플랫폼에 종속적.
why? OS에 특화된 부분을 맡아 메모리에 로딩하거나 작업하기 때문에 특정 벤더들이 생기는 이유같다. oracle, amazon, azul 등

#### JRE(Java RunTime Environment)
JVM + Library로 구성
자바 애플리케이션이 실행될 수 있는 배포판.
JVM과 핵심라이브러리 및 자바 런타임 환경에서 사용하는 프로퍼티 세팅이나 리소스 파일을 가지고 있음.
개발 툴은 포함 x

#### JDK(Java Development Kit)
JRE + 개발 툴로 구성
소스코드 작성 시, 자바언어는 플랫폼에 독립적
why? 바이트코드로만 변환이 되면 나머지는 JVM에서 어떤 환경이든지 동작하기 때문.

#### JVM 언어
JVM 기반으로 동작하는 프로그래밍 언어
kotlin, jRuby, jthyon, scala 등

### JVM 구조

JVM -> 클래스로더 시스템, 메모리, 인터프리터, 네이티브 메소드 인터페이스, 네이티브 메소드 라이브러리


클래스 로더 -> 로딩, 링킹, 초기화
.class에서 바이트코드를 읽고 메모리에 저장
로딩 : 클래스를 읽어오는 과정
링킹 : 레퍼런스 연결 과정
초기화 : static값들 초기화 및 변수에 할당

메모리 -> 스택, PC register, 네이티브 메소드 스택, 힙, 메소드
1. 메소드 영역에는 클래스 수준의 정보(클래스 이름, 부모 클래스 이름, 메소드, 변수) 저장, 공유 자원이다.
2. 힙 영역에는 객체를 저장, 공유 자원이다.
3. 스택 영역에는 쓰레드 마다 런타임 스택을 만들고, 그 안에 메소드 호출을 스택 프레임이라 부르는 블럭으로 쌓는다. 쓰레드를 종료하면 런타임 스택도 사라진다.
4. PC register는 쓰레드마다 쓰레드 내 현재 실행할 instruction의 위치를 가리키는 포인터가 생성됨.
5. 네이티브 메소드 스택
네이티브 메소드 인터페이스를 통해서 불러온 메소드들의 정보를 미리 가지고 있음.

실행 엔진 -> 인터프리터, JIT 컴파일러, GC
1. 인터프리터는 바이트코드를 한줄씩 실행
2. JIT(Just In Time) 컴파일러는 인터프리터의 효율을 높이기 위해, 인터프리터가 반복되는 코드를 발견하면 JIT 컴파일러로 반복되는 코드를 모두 네이티브 코드로 변경. 그 다음부터 인터프리터는 네이티브 코드로 컴파일된 코드를 참고
3. GC(가비지 컬렉터)는 더 이상 참조되지 않는 객체를 모아서 정리.

JNI(Java Native Interface)
자바 어플리케이션에서 C, C++ 등으로 작성된 함수를 사용할 수 있는 방법을 제공한다.
native 키워드를 사용한 메소드 호출

네이티브 메소드 라이브러리
C, C++로 작성된 라이브러리.


참고
[https://dzone.com/articles/jvm-architecture-explained](https://dzone.com/articles/jvm-architecture-explained)
[https://howtodoinjava.com/java/basics/jdk-jre-jvm/](https://howtodoinjava.com/java/basics/jdk-jre-jvm/)
[https://aboullaite.me/understanding-jit-compiler-just-in-time-compiler/](https://aboullaite.me/understanding-jit-compiler-just-in-time-compiler/)

