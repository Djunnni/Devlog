### 암호화

평문으로 전돨되는 application.yml, bootstrap.yml을 암호화해서 난독화하기

#### JCE

Java8에서는 상위버전의 암호화 알고리즘을 사용하기 위해서는 추가 설치가 필요하나 Java11이상부터는 필요가 없다.


#### 명령어 모음

1. keytool 명령어를 이용해 키를 하나 생성한다. (*비밀번호는 기억할 것!)

```shell
keytool -genkeypair -alias apiEncryptionKey -keyalg RSA -dname "CN=Daniel Lee, OU=API Development, O=djunnni.site, C=KR" -keypass "test1234" -keystore apiEncryptionKey.jks -storepass "test1234"
```

2. 만들어진 키 정보를 확인한다.

```shell
keytool -list -keystore apiEncryptionKey.jks -v
```

3. trustServer 인증서를 만든다.

```shell
keytool -export -alias apiEncryptionKey -keystore apiEncryptionKey.jks -rfc -file trustServer.cer
```