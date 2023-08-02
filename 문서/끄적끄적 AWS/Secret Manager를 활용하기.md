### 작성하게된 계기

local환경에서 AWS 서비스를 이용해야 하는 경우가 발생할 수 있다. AWS Secret Manager를 활용해 배포환경에서 환경변수로 삽입되고 있다고 하자.

### AWS CLI 설치

[AWS CLI 설치](https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/getting-started-install.html)에서 OS에 맞게 다운로드

### AWS Configure 설정하기

aws-cli를 활용해 `구성 설정 지정 및 보기` 단계를 진행하자

[여기](https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/cli-configure-files.html)

### Command 방식으로 해결하기

1. aws configure

    ```bash
    AWS Access Key ID [None]: ${accessKey}
    AWS Secret Access Key [None]: ${secretAccessKey}
    Default region name [None]: ${region | ap-northeast-2}
    Default output format [None]: json
    ```

2. aws에서 받은 권한이 command로 간단하게 read가 가능한지 확인

    ```bash
    aws s3 ls // s3의 버킷 리스트를 출력해주는 명령어
    ```

### NestJS에서 활용하기

```ts
import {
  GetSecretValueCommand,
  SecretsManagerClient,
} from '@aws-sdk/client-secrets-manager';

// secretName은 secretManager에 등록된 이름입니다.
export const awsSecretManagerConfig = async (secretName = '${secretName}') => {

  const client = new SecretsManagerClient({
    region: 'ap-northeast-2', // 서울리전
  });

  try {
    const response = await client.send(
      new GetSecretValueCommand({
        SecretId: secretName,
      }),
    );
    return JSON.parse(response.SecretString);
  } catch (error) {
    console.error(
      `[AwsSecretManagerConfig] can't load config from aws secret manager`,
    );
    return {}; // 로드할 수 없을 땐 기본으로 세팅
  }
};
```