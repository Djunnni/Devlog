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

