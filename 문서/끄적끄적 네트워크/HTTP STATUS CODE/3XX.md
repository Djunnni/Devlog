# 3XX

## 300 [Multiple Choices]

HTTP 리다이렉션 상태 응답 코드는 응답이 2군데 이상이 있다는 걸 의미
사용자 Agent, 사용자는 둘 중하나를 선택해야하는데 응답중 하나를 선택하는 표준 방법이 없기에 응답코드는 거의 사용되지 않는다.

ex) test.djunnni.com/tt1 -> `test-api.djunnni.com/tt1`, `test.djunnni.com/v1/tt1` 2가지로 모두 처리가 가능하다는 의미

## 301 [Moved Permanently]

요청한 리소스가 `Location 헤더`에 지정된 URL로 완전히 옮겨짐을 의미

페이지로 리다이렉트하고 검색엔진은 해당 리소스로 연결되는 링크를 갱신한다.

301 코드는 'GET', 'HEAD' 메소드의 응답으로 답하고 'POST' 메서드는 메소드 변경이 명시적으로 금지된 `308 Permanent Redirect`을 쓴다.

## 302 [FOUND]

요청한 리소스가 `Location 헤더`에 지정된 URL로 일시적으로 이동됨을 나타낸다. 

리다이렉션이 되지만 검색엔진은 리소스에 대한 링크를 업데이트하지 않는다. -> 새롭게 클릭하면 결국 처음의 URL에게 재 질의한다는 것.

`GET`, `HEAD` Method를 제외한 나머지의 경우는 `307 Temporary Redirect`, `308 Permanent Redirect`를 사용할 것
> 307이 302와 다른점은 Method와 Body를 변경하지 않고 리다이렉트 요청을 하도록 보장

## 303 [See Other]

리다이렉션이 요청한 리소스 자체에 연결되지 않고 다른 페이지(확인 페이지 or 업로드 진행률 페이지)에 연결됨을 나타낸다.

> 경험이 없어 https://kinsta.com/knowledgebase/http-303/ 여기를 바탕으로 좀 더 찾아보고 분석

## 304 [Not Modified]

요청된 리소스를 재전송할 필요가 없음을 의미, 캐시된 자원의 암묵적인 리다이렉션이다.

> 추가 내용 보강필요.

## 307 [Temporary Redirect]

요청한 리소스가 `Location 헤더`에 주어진 URL로 임시로 옮겨졌다는 걸 의미한다.

원래 요청한 메소드와 Body를 재사용해 요청을 Redirect 한다. GET 메소드로 변경하고 싶을 땐 `303 See Other`를 사용한다. (Put 요청에 업로드된 리소스가 아닌 `처리결과`) 같은 확인 메시지 응답을 제공하는데 유용

## 308 [Permanent Redirect]

`Location 헤더`에 지정된 URL로 확실히 이동되었음을 나타냄. -> 리다이렉션이 발생하고 검색엔진 리소스에 대한 링크를 업데이트 함.