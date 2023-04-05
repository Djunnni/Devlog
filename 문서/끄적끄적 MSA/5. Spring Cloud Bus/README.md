### Spring Cloud Bus

#### 이전까지 서버의 상태를 갱신하기 위해 취했던 방법

1. 서버 재시작
    - 논외
2. Actuator Refresh
    - 분산 서비스 환경에서 많은 하위 서비스의 actuator를 불러야해서 번거로운 문제가 발생

#### Spring Cloud Bus
    - 분산 시스템의 노드를 경량 메시지 브로커와 연결
    - 상태 및 구성에 대한 변경 사항을 연결된 노드에게 전달(broadcast)

1. AMQP
    - 메시지 지향, 큐잉, 라우팅(Publisher - Subcriber) 신뢰성 보장, 보안
    - Erlang(병렬처리 특화언어), RabbitMQ에서 사용

2. Kafka
    - Apache Software Foundation이 Scalar 언어로 개발한 오픈소스 메시지 브로커 프로젝트
    - 분산형 스트리밍 플랫폼
    - 대용량의 데이터 처리 가능한 메시징 시스템


### Rabbit MQ 설치

#### MAC

```
brew update
brew install rabbitmq
```

#### DOCKER

```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11
```


### 5672, 15672 PORT

The Default Port is: 5672. It's defined in the RABBITMQ_NODE_PORT variable.

Source: https://www.rabbitmq.com/configure.html#define-environment-variables

Port 15672: It is used to access the management console of Rabbit MQ.

Change Port in property file from 15672 to 5672 and it will work!

#### Cloud Bus 이용하기

1. Cloud Bus를 이용하는데 Rabbit MQ 서버를 구동함.

2. 각 MSA에서 설치한 `implementation 'org.springframework.cloud:spring-cloud-starter-bus-amqp'` 을 이용한다.

3. application.yml에서 rabbit MQ를 설정한다.

4. busrefresh를 추가한다.
    ```
        management:
        endpoints:
            web:
            exposure:
                include: refresh, health, beans, httptrace, busrefresh
    ```

5. actuator로 busrefresh를 AMQP가 연결된 아무서버에게 보내면 연결된 모든 서버가 갱신된다.

