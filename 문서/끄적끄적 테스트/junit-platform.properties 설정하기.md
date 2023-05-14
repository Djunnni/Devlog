### junit-platform.properties 설정하기

| TestClass에서 어노테이션을 이용해, 설정도 가능하지만 매번하기 번거로울 수 있다. 이번엔 junit-platform.properties를 만들고 설정해보자.

1. junit-platform.properties를 사용하기 위해서는 test 폴더에 resources를 만들어야 한다. 

2. resources 폴더가 test 환경 설정파일 폴더로 인식하지 못하니 intellij 프로젝트 > Modules > 해당 폴더를 test resources로 지정해준다.

```properties
# 클래스마다 라이프사이클이 돌도록 설정
junit.jupiter.testinstance.lifecycle.default= per_class
# 확장팩 자동 감지
junit.jupiter.extentions.autodetection.enabled=true
# @Disabled 무시하고 실행하기
junit.jupiter.conditions.deactive = org.junit.*DisabledCondition

# 테스트 이름 표기 전략 설정
junit.jupiter.displayname.generator.default = \
    org.junit.jupiter.api.DisplayNameGenerator$ReplaceUnderScores
```
