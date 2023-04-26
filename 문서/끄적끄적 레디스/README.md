### 끄적끄적 레디스

#### 레디스의 활용용도

1. look aside cache
    * 캐시에 데이터가 있는지 확인 없으면, DB참고
2. write back
    * 쓰기작업이 많을 경우 레디스에 먼저 쌓고 한번에 DB에 저장
    * 단, 재부팅되거나 장애발생시, 대처가 제일 중요

#### 밈캐시, 레디스 차이
밈캐시는 컬렉션을 제공안함 레디스는 제공
개발의 난이도 차이가 컬렉션에 의해 커진다.

#### 랭킹서버

같은 정보에 대해 속도 문제가 발생할 수 있음 그래서 DB보다는 캐시에서 저장
redis의 sortedSet을 사용하면 랭킹 구현하기 쉬움. 레플리카도 가능

#### 레디스의 장점

Redis는 자료구조가 atomic해서 race 컨디션을 피할 수 있지만 코드를 잘못짜면 발생 가능

#### 레디스 어디에 써야하나?

1. remote data store
    - 여러 데이터를 서버들끼리 공유하고 싶을 때
2. 한대만 필요하다면, 전역 변수를 쓰면 되지 않을까?
    - 레디스가 atomic을 보장
3. 주로 쓰는 곳
    - 인증 토큰을 저장
    - 랭킹 보드
    - 유저 API 리밋
    - 잡 큐

#### redis collection

1. string
    - prefix에 따라 분산 방식이 달라질 수 있음
2. list
3. set
4. sorted set
    - double 타입으로 Score 처리가 되고 있어서 js에서는 String으로 처리하는게 좋음. js에서는 실수에 대해 가능한 범위가 있어서
5. hash

#### Redis 운영

1. 메모리 관리를 잘하자
    - 인메모리다 보니 메모리 관리가 중요하다.
    - 물리메모리 이상을 사용하면 문제가 발생
    - swap이 있다면 swap사용으로 해당 메모리 Page 접근시마다 늦어진다.
        - 스왑은 디스크에 메모리 페이지를 두고 다시 읽는 과정이 들어서 디스크에 지속적으로 접근하게 된다.
    - maxMemory를 설정하더라도 이보다 더 사용할 가능성이 있음
        - 레디스가 아는 자신의 메모리, jmalloc으로 할당해서 쓰고 있기에 allocate구현에 따라 성능이 왔다갔다하며 실제로 메모리를 잡고 있을 수 있다.
        - 메모리 페이지 단위로 읽다보니 1byte를 달라해도 4096byte를 할당하게 됨 -> 메모리 파편화가 일어날 수 있음
    - 현재 메모리를 사용해서 swap을 사용하고 있다는 걸 모르는 사람이 많음.
    - 적은 메모리 여러 인스턴스로 쓰는게 좋다. master - slave 구조에서 fork가 일어난다. write는 2배를 메모리를 쓸 수 있다.
    - RSS 값을 모니터링 해야함
    - 메모리가 부족할 때는?
        - 메모리가 좀 더 많은 장비로 migration
        - 메모리를 빡빡하게 쓰면 migration에서 문제가 발생할 수 있음
        - swap을 사용중이면 재실행
    - 기존 collection들은 자료구조를 사용함
        - hash -> hashTable 하나 더 사용
        - sortedSet -> skiplist, hashTable을 이용
        - set -> hashTable 사용
        - 해당 자료구조들은 메모리를 많이 사용함
        - ziplist 이용하자..
2. O(N) 관련 명령어는 주의하자
    - redis는 싱글 스레드다.
        - 동시에 처리할 수 있는 명령은 1개다.
        - 단순한 get/set의 경우, 초당 10만 TPS 이상 가능
        - 긴 명령어를 실행하면 안된다.
    - KEYS
        - scan으로 방지할 수 있다. scan은 커서방식으로 동작
    - FLUSHALL, FLUSHDB
    - DELETE Collections
    - GET ALL Collections
        - 매번 10만개 이상을 가져오는 걸 피해라
        - 콜렉션 크기를 쪼개어 여러 collections를 나눠 저장하라
    - 실수 사례
        - Spring Security OAuth ReidsTokenStore
        - 몇만개든 Set, SortedSet, Hash에서 모든 데이터를 조회하는 경우
3. Replication
    - A라는 서버에 B, C의 데이터를 모두 가지고 있을 수 있도록!
    - Async Replication이다. Replication Lag가 발생할 수 있다.
    - 부하에 따라서 slave에서 master와 sync가 안맞는 이슈가 있다.
    - DBMS로 보면 state replication과 유사(쿼리를 날리는 식)
    - 설정과정
        - secondary에 slaveof, replicaof 명령을 전달하면 가능
    - fork가 발생해 메모리 부족이 발생할 수 있음.
    - Redis -cli --rdb 명령은 현재 상태의 메모리 스냅샷을 가져오므로 같은 문제를 발생

#### ziplist구조

in-memory 특정상, 적은 개수라면 선형 탐색을 하더라도 빠르다.
list, hash, sorted set 등을 ziplist로 대체해 처리하는 로직이 존재

#### redis.conf 설정 팁

1. maxClient 50000으로 설정
2. RDB/AOF 설정 off
3. 특정 커멘드 disable
    - keys
    - aws elasticCache는 이미 하고 있음
4. 적절한 ziplist 설정

#### 레디스 데이터 분산
데이터의 특성에 따라서 선택할 수 있는 방법이 달라진다.
1. cache 일때는 우아한 redis(정말?)
2. persistent 해야하면 안 우아한 redis
    - open the hell gate!

1. application
    - consistent hashing
        - 해당하는 서버에 남아있는 값들만 수정이 일어난다.
        - 1/n에만 해당하는 데이터가 움직인다.
    - sharding
        - 데이터를 어떻게 나눌것인가? 어떻게 찾을것인가?
        - Range
            - 특정 범위를 지정하고 거기에 저장
            - 불균형이 발생할 수 있다. 이벤트에 몰리는 상황이 발생할 수 있음
            - 서버의 상황에 따라 놀고있는 것과 아닌게 극심하게 나뉨
            - 데이터를 쉽사리 옮길 수 없음
        - 모듈러
            - 2배만큼 증설하면 기존 모듈러 + 2 만큼 이동하기 쉬움
            - 증설해야할 사람들이 2의 배수로 계속 늘어나야만 가능하다.

2. redis cluster
    - 해시기반으로 이루어짐
    - crc16을 사용해 slot = crc16(key) % 16384가 됨
    - primary 마다 slot range를 가짐
    - 장점
        - 자체적인 primary, secondary failover
        - slot 단위 데이터 처리
    - 단점
        - 메모리 사용량 많음
        - migration 자체는 관리자가 시점을 결정
        - library 구현이 필요

3. redis failover

    - coordinator 기반
        - zookeeper, etcd, consul 등의 coordinator 사용
        - 해당 기능을 이용하도록 개발이 필요
    - vip/dns 기반
        - virtual ip기반
        - 기존 primary에 장애 발생시 health checker가 2번을 primary로 승격시키고 재연결
        - 기존연결은 모두 끊어준다.
        - DNS기반은 cache TTL을 관리해야한다.
        - 언어별 DNS 캐시정책을 알아야한다.

#### 모니터링

1. redis info
    - rss  
        - 사용하는 실제 메모리 양
    - used memory
    - connection 수
    - 초당 처리 요청 수

2. system
    - CPU
        - 100%를 칠 때,
            - CPU를 좋은 걸로 이동
            - O(N) 계열의 특정 명령이 많은 경우
            - 짧게 Monitor 명령을 통해 패턴을 분석하는 게 필요
            - Monitor를 잘못쓰면 부하로 서버에 더 큰 문제를 일으킬 수 있다.
    - Disk
    - Network rx/tx

#### 결론

기본적으로 redis는 좋음

그러나 메모리를 빡빡하게 쓰면 관리가 어려움

client-output-buffer-limit 설정이 필요

##### 레디스를 캐시로 쓸 때,

문제가 적게 발생, redis가 문제가 있을 때, DB등의 부하가 어느정도 증가하는 지 확인 필요

consistent hashing도 실제 부하를 균등하게 나누지는 않음.

##### persistence로 관리할 때,

무조건 primary/ secondary구조로 구성이 필요
- 메모리가 빡빡하면 안됨
    - 정기적인 migration 필요
    - 가능하면 자동화 툴을 만들어 이용
    - rdb/aof가 필요하면 secondary에서만 구동


#### 참고 강의
https://youtu.be/mPB2CZiAkKM