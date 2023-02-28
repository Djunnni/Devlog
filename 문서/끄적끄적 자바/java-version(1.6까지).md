## java version (1.6까지)

### java 버전별로 수정된 이력을 알아두자.
프로젝트에서는 항상 최신 버전을 이용하게 되는 건 아니다. 이전버전에 대해서 어떤 점이 변경/수정 되었나 확인하고
써야하는 경우도 많다.

### java 특징

1. "단순하고, 객체지향이며, 친숙"
2. "견고하며 보안 안전"
    * 클라이언트로 다운로드한 승인받지 않은 프로그램은 실행할 수 없도록 되어있다.
3. "아키텍쳐에 중립적이고 포터블"
    * compile이 된다면 바이트코드로 어떠한 플랫폼에서도 실행할 수 있다.
4. "높은 성능"
5. "인터프리터 언어, 쓰레드 제공, 동적 언어"
    * 자바 인터프리터는 어떠한 환경에서도 수행할 수 있도록 해준다.
    * 멀티스레드 환경을 제공하고 있어 여러작업 수행이 가능하다.
    * 자바 컴파일러는 컴파일 시 매우 정적인 점검을 수행한다. 실행시 동적으로 필요한 프로그램들을 링크시킨다.

### JDK 1.0

* 내부 클래스(inner class) 도입
* javaBeans, JDBC, RMI

### JDK 1.2

* JIT 컴파일러 Sun JVM 첫 도입
    * 일부 메소드 또는 전체 코드를 네이티브코드로 변환해 JVM에서 번역하지 않음으로서 빠른 성능을 제공
* 자바 플러그인 추가
* Collections 프레임웤 추가

### JDK 1.3

* Hotspot JVM 추가 (Hotspot JVM은 JDK 1.2 JVM에서 추가, 공식적으론 JDK1.3에서 추가)
* JNDI 코어 라이브러리에 추가
    * 어떤 객체를 쉽게 찾을 수 있도록 도와주는 이름을 지정한 후, 나중에 그 이름을 찾아가는 것을 의미
* JPDA(Java Platform Debugger Architecture)

### JDK 1.4

* assert 예약어 추가
* Perl 언어의 정규표현식을 따르는 정규표현식 추가
* exception chaining을 통해 하위레벨 캡슐화 가능
* IPv6 지원
* NIO라는 non-blocking 추가
* logging API 추가
* jpeg, png 이미지를 읽고 쓰기 위한 image i/o 추가
* 통합 XML 파서 추가

### JDK 1.5

* 제네릭 추가
* 어노테이션 메타데이터 추가
* autoboxing, unboxing 기능 추가
* enum 추가
* varargs 추가(String... names)
* forEach문 도입(for(String name : names))
* static import 도입

* 스레드 처리 쉽게 concurrent 도입
* Scanner 도입

### JDK 1.6

* 스크립팅 언어가 JVM에서 수행 가능하게 됨
* 각종 코어 기능 개선
* Compiler API가 추가되어 프로그램에서 자바 컴파일러 실행이 가능

