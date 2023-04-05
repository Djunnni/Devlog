### Apache Kafka

메시지 브로커 프로젝트

실시간 데이터 피드를 관리하기 위해 통일된 높은 처리량, 낮은 지연 시간을 지닌 플랫폼을 제공

1. Producer/Consumer 분리
2. 메시지 여러개에 Consumer에게 전송 가능
3. 높은 처리량을 위한 메시지 최적화
4. scale-out 기능
5. eco-system => 다양한 형태의 연동이 가능


#### Kafka Broker

카프카 어플리케이션 서버. 3대 이상의 브로커 클러스터 구성권장(여러개의 브로커들이 한 곳에 저장된 메시지를 다른데로 공유해주면서 문제 발생시, 다른 브로커로 전달해주는 게 가능)

장애 체크, 복구로 코디네이터로 아파치의 주키퍼가 사용됨.

#### Kafka Client

카프카에 메시지를 보내고 저장 후 컨슈머에 전달해줌

https://cwiki.apache.org/confluence/display/kafka/clients

```shell
# 주키퍼 실행
./bin/zookeeper-server-start.sh ./config/zookeeper.properties
# 카프카 실행
./bin/kafka-server-start.sh ./config/server.properties

# 토픽 생성하기
./bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092 -partitions 1 
# 토픽 조회하기
./bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
# 토픽 상세조회
./bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092

# 프로듀스
./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic quickstart-events
# 구독
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic quickstart-events --from-beginning
```
[kafka-run](./%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-03-20%20%EC%98%A4%EC%A0%84%202.45.59.png)

#### Kafka Connect

카프카에 메시지를 보낼 떄, 자바 프로그램으로 받을 수도 있지만 데이터베이스로부터 카프카의 변경된 데이터를 가져와 다른 스토리지나, 서비스에 전달하는 기능

- Data를 Import/Export 가능
- 코드 없이 Configuration으로 데이터를 이동
- standalone, distribution 지원
    - restful API 지원
    - stream or batch 형태로 데이터 전송 가능
    - 커스텀 Connector를 통한 다양한 플러그인 제공(File, S3, Hive, MySQL 등)

```
    implementation 'org.mariadb.jdbc:mariadb-java-client:2.7.2' # 3.1.10 버전에서는 JDBC 드라이버를 못찾는다는 버그가 있었음.
```

#### 정상 수행 시,

[source-connect](./kafka-source-connect.png)

```json

{
    "schema":{"type":"struct","fields":[{"type":"int32","optional":false,"field":"id"},{"type":"string","optional":true,"field":"user_id"},{"type":"string","optional":true,"field":"pwd"},{"type":"string","optional":true,"field":"name"},{"type":"int64","optional":true,"name":"org.apache.kafka.connect.data.Timestamp","version":1,"field":"created_at"}],"optional":false,"name":"users"},

    "payload":{"id":2,"user_id":"2","pwd":"test1112","name":"userName2","created_at":1679289473000}
}
// payload가 실제 전달한 데이터
```

[sink-connect](./kafka-sink-connect.png)

