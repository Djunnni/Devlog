# 들어가며,

AWS S3에 올린 객체가 특정 날짜에 삭제되거나 몇일이 지나 삭제가 됐으면 좋겠다고 생각할 때가 있다.

이 경우 어떻게 해야 되는지 살펴보자



## 1. S3 Bucket LifeCycle Rule을 설정

S3 LifeCycle Rule은 객체 자체에 Rule을 설정할 수 없어 Bucket 단위로 설정이 가능하다.

batch 작업으로 유저가 등록한 파일을 자동 제거하는 규칙을 설정한 rule이 있다.



1. 생명주기 이름을 기입한다.

2. 규칙 범위를 선택한다.

    - 하나 이상의 필터로 이 규칙을 범위 제한

    - 버킷의 모든 객체에 적용

3. 필터 유형 설정

    - 객체 태그 추가

4. 객체 크기 제한 가능

5. 수명 주기 규칙 작업 설정

    - 스토리지 간 현재/이전 버전 이동

    - 객체에 현재 버전 만료

        - 설정하고 싶은 기간의 일 수를 기입합니다. ex) 7

    - 객체의 이전버전 영구 삭제

        - 객체가 최신이 아닌 버전이 된 후 경과한 일수 필드에 "1"을 입력합니다.

        - 모든 버전을 삭제하고 싶다면 유지할 최신 버전 수 필드를 비우세요.

    - 만료된 객체 삭제 마커 또는 완료되지 않은 멀티파트 업로드 삭제 현재 버전 만료와 함께 사용 불가

추가적인 내용은 [여기](https://repost.aws/ko/knowledge-center/s3-empty-bucket-lifecycle-rule)서 볼 수 있습니다.

## NestJS에서는 어떻게 사용할 수 있을까?

1. 권한 여부 확인

-  s3PutObject

- s3DeleteObject

- s3PutObjectTagging

- s3RequestObjectTag



## 2. c3api에 적용된 Upload 방법을 이용해서 설명함

- tagging을 통해 추가가 가능하다. tagging은 key=value 형태로 여러개를 넣고 싶으면 &을 추가해야한다.

- ex) expiration_day=7&delete=force

```ts
const upload = new Upload({
      client: this.s3Client,
      params: {
        Bucket: bucketName,
        Key: key,
        Body: Readable.from(file.buffer),
        ContentType: file.mimetype,
        ACL: acl ?? 'private',
        ...(expires && { Expires: expires }),
        ...(tagging && { Tagging: tagging }), // TAG 설정 'expiration_day=7'
      },
    });
```


참고

https://repost.aws/ko/knowledge-center/s3-empty-bucket-lifecycle-rule 

https://medium.com/@dnorth98/using-s3-batch-to-tag-data-for-removal-a569fef7ac0