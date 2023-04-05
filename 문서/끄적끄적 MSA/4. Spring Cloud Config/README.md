### Spring Cloud Config

분산 시스템에서 서버 클라이언트 구성에 필요한 설정 정보를 외부 시스템에서 관리

하나의 중앙화 된 저장소에서 구성요소 관리 가능

각 서비스를 다시 빌드하지 않고, 바로 적응 가능

애플리케이션 배포 파이프라인을 통해 DEV - UAT - PROD 환경에 맞는 구성정보 사용

#### 방법

1. git repository 생성 (local환경)
    - master브랜치라면 cloud-config에서 main에 대한 에러가 발생할 수 있다.

2. spring cloud config server 레포 생성

3. spring.cloud.config.server.git.uri에 레포 위치 등록

4. 레포에 등록한 파일명.yml이 /[파일명]/default가 됨


#### 학습 내용

```gradle
    implementation 'org.springframework.cloud:spring-cloud-starter-config'
    implementation 'org.springframework.cloud:spring-cloud-starter-bootstrap'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

1. bootstrap을 통해서 어플리케이션 서버 실행 시, application.yml 보다 먼저 설정을 읽을 수 있음.

2. `spring-cloud-starter-config` 통해서 cloud config server로 부터 가져올 수 있음.

3. `spring-cloud-starter-bootstrap`을 넣어야 하는 이유는 최근 cloud에서는 자동 옵션이 빠져있음.
    - 꼭 설치하지 않고도 `spring.cloud.bootstrap.enabled=true`로  설정가능

4. actuator를 통해서 서버의 상태, 설정 리프레시, 빈 상태, httpTrace 등을 확인 가능


5. bootstrap을 통해서 읽을 때, `spring.cloud.config.[uri|name]` 설정을 하기!

6. `spring.cloud.profiles.active`를 통해서 prod, dev, default 설정이 가능하다.

7. config 파일 읽기 순서는 application.yml < application-name.yml < application-name-[profile].yml 순으로 설정파일 이 없으면 그의 왼쪽 파일을 확인해 읽는다.

예를 들면 다음과 같다.

```
user-service-prod.yml를 읽으려 한다. 
없을 경우 user-service.yml을 이마저 없으면 application.yml이다.
```
