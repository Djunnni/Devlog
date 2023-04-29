### RestAssured 사용기

1. springbootTest를 랜덤포트로 주어 RestAssured에서 쓸 수 있게 조성한다.

```gradle
 testImplementation 'io.rest-assured:rest-assured:4.4.0'
```

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        if(RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port;
        }
    }
}
```

```java
private static ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return RestAssured.given().log().all() // given.log.all 요청에 대한 로그를 남기겠다.
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }
```

#### 시간 비교를 위한 테스트
```java
/**
 * data : { token, createdAt, expiredAt } 
 */
@Test
public void 토큰갱신() {
    final var response = 토큰생성요청();
    String token = response.body().jsonPath().get("data.token");
    LocalDateTime expiredAt = LocalDateTime.parse(response.body().jsonPath().get("data.expiredAt"));

    final var nextResponse = 토큰갱신요청(token);
    LocalDateTime nextExpiredAt = LocalDateTime.parse(nextResponse.body().jsonPath().get("data.expiredAt"));

    assertTrue(expiredAt.isBefore(nextExpiredAt), () -> "토큰 갱신 시, expiredAt이 더 늘어납니다.");
    // 토큰 제거
    토큰삭제요청(token);
}
```
