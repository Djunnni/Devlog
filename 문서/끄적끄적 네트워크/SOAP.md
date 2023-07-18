# SOAP 

| REST는 SOAP 이후에 개발되어 많은 단점을 해결하고 있지만 몇몇 외부 서비스 연결에 필요한 상황이라 알아두면 좋다.



### SOAP란?

“Simple Object Access Protocol”로 HTTP, HTTPS, SMTP 등을 사용해 XML 기반의 메시지를 컴퓨터 네트워크 상에서 교환하는 프로토콜



### 어떤 목적으로 넌 만들어졌냐?

결국은 서로다른 서비스 간 연동을 목적으로 생성되었다. 원격지에 있는 서비스 객체나 API를 자유롭게 사용하고자 함

RPC(Remote Procedure Call) 패턴으로 웹서비스 클라이언트에서 서버 쪽으로 메시지를 요청하고 서버는 그 메시지에 반응하게 됨.

### SOAP의 형태

* SOAP-ENV Envelope

    * SOAP-ENV Header

    * SOAP-ENV Body


### SOAP의 장점

* 프록시와 방화벽에 구애받지 않고 쉽게 통신이 가능하다.

* 플랫폼 독립적이다.

* 프로그래밍 언어에 독립적이다.

### SOAP의 단점

* XML 포맷은 태그 형태로 보내기 때문에 상대적으로 느림

* 확장하기 어려움(서버는 클라이언트와 교환한 이전 메시지를 모두 저장해 상태를 유지함)

* XML 데이터 형식 교환만 지원



### SOAP v.s. REST

데이터 교환 메커니즘에 차이가 있다.

* 유사점

    * 둘 다 애플리케이션이 다른 애플리케이션의 데이터 요청을 작성, 처리, 응답하는 방식에 대한 규칙과 표준을 설명

    * HTTP를 사용해 정보를 전달한다.

    * SSL/TLS를 지원함

* 차이점
    
    *  https://aws.amazon.com/ko/compare/the-difference-between-soap-rest/




참고

- https://aws.amazon.com/ko/compare/the-difference-between-soap-rest/
- http://wiki.hash.kr/index.php/SOAP
- https://www.ibm.com/docs/ko/integration-bus/10.0?topic=ssmkhh-10-0-0-com-ibm-etools-mft-doc-ac55780--htm