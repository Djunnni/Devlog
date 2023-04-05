### 1. MSA 기초

#### intelliJ에서 실행시 gradle에서 여러 command에서 server.port 변경방법

1) java명령어 실행 시, VM Options 추가

    ```java
        -Dserver.port=9000
    ```

2) Gradle bootRun 시, Environment variables 설정
    
    ```java
        server.port=9001
    ```

#### eureka client 등록 시, 인스턴스 ID 따로 설정하는 이유

```yml
server:
    port: 0 # server실행 시, 랜덤 port로 변경됨.

spring:
    application:
        name: user-service

# user-service:0으로 유레카에 등록되나 마지막에 실행한 서버 주소로 덮어쓰기가 되기에 instance아이디를 따로 설정하자.

eureka:
  client:
    register-with-eureka: true # 유레카 REGIST에 등록할 지 여부
    fetch-registry: true # 클라이언트가 다른 서비스의 endpoint 정보를 다운로드 하기위해 유레카 서버에 연결을 시도할지 여부
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka # 유레카 디스커버리 서버가 띄워져있는 주소를 기입하기
  instance-id: ${spring.cloud.client.hostname}:${spring.application.instance.id:${random.value}} 
    # host.docker.internal:ce018a0a23e3bdc4383b268096dd0f6b
```
