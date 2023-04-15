### 같은 이름의 component 빈이 있을 경우

1) Qualifier를 사용하기
2) Primary 사용하기


### 1) Qualifier 사용하기

![이름이 같은 userService](./IMG/%EC%9D%B4%EB%A6%84%EC%9D%B4%20%EA%B0%99%EC%9D%80%20userService.png)

v2.user에 userService를 테스트하기 위한 상황인데 DI로 두개가 충돌이 발생하는 상황이다.

#### 해결한 방법

```java
/// UserService 코드
@Component(value = "newUserService")
public class UserService {

    @Autowired
    private UserPort userPort;

    public void save(final User user) {
        userPort.save(user);
    }

    public GetUserResponse getUser(long userId) {
        final User user = userPort.getUser(userId);
        return new GetUserResponse(user.getId(), user.getDeposit(), user.getPrize());
    }
}
```

```java
/// UserServiceTest 코드
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
    @Autowired
    @Qualifier("newUserService") // Qualifier로 대상 지정
    private UserService userService;

    @Test
    void 유저생성() {
        // 유저 생성
        User user = 유저생성요청_생성();

        userService.save(user);

        assertThat(userService.getUser(1L)).isNotNull();
    }

    private User 유저생성요청_생성() {
        return new User(1L);
    }


}
```