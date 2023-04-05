
### MSA간 통신

#### RestTemplate를 사용한 통신

MSA 환경에서 cloud 정보를 읽는 데 order_service의 url을 등록하고 쓸 수 있다.

```yml
# ORDER-SERVICE부분을 쓰려고 한다면 RestTemplate에 LoadBalanced 어노테이션을 추가하자.
order_service:
  url: http://ORDER-SERVICE/order-service/%s/orders
```

#### FeignClient를 사용한 통신

feignClient용 interface를 생성하고 만듬

1. EnablefeignClient 어노테이션을 어플리케이션에 설정
2. interface로 각 msa 를 사용할 api를 등록
3. service-layer에서 사용하기

#### FeignClient Exception

FeignClient Exception을 통해 MSA에서 발생할 수 있는 예외에 대응한다.

#### 동기화 이슈

현재 프로젝트 구조를 살펴보면 각 MSA 간 DB를 별도로 가지고 있어 2개이상 가동시 데이터가 일치하지 않는 문제가 발생할 수 있다.

```
    예를들어

    1번 주문 서버 -> 요청 -> 요청
    2번 주문 서버 -> 조회

    가 있다면 0개의 결과를 가져오게 되는 것!
```

방법

1) DB를 하나만 쓴다.
    - transaction 관리가 필수
2) DB를 여러개 쓰고 동기화한다.
    - 동기화 시 메시지큐를 통해 상대방에게 알려준다.
3) MQ를 통해 데이터를 받고 DB로 데이터 쌓기
    - 매번 커넥션이 커서 배치를 통해 한번에 데이터를 저장하거나 쿼리를 묶어 실행하기를 고려(커넥션을 짧게 가져가기 위해)
    - 메시지 큐잉을 통해 전달하면 order서비스가 할 일은 끝남 데이터를 일괄 넣는건 큐잉서버가 담당