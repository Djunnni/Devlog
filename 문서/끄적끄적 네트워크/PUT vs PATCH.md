# PUT vs PATCH

PUT과 PATCH 모두 리소스에 변화를 주고 있다. 따라서 resource 관점에서는 safe하지 않은 메서드다.

2가지 방식에 대해 다음 관점들로 이해해 볼 필요가 있다.

### 3가지 관점

#### 1. update

> 리소스에 대해 직접적으로 접근할 수 있는 Key 값이 있다고 해야한다. 
> ex) products?id=2

- PUT : resource에 대해 전체 내용을 바꾸며, 리소스에서 지원하는 필드가 비어있다면 nullable 하다.
- PATCH : resource에서 일부분을 수정하며, 리소스에서 정의된 필드만 바꾼다.

```
ex) PUT
{ item: '아이폰 XS', price: 100000, color: 'spaceGray' } 가 있다.

put를 통해 API를 수정해보자.

{ item: '아이폰 XS', price: 4000, color: 'spaceGray' } -> { item: '아이폰 XS', price: 4000, color: 'spaceGray' }
{ item: '아이폰 XS' } -> { item: '아이폰 XS', price: null, color: null }

ex) PATCH
{ item: '아이폰 XS', price: 100000, color: 'spaceGray' } 가 있다.

patch를 통해 API를 수정하자.

{ item: '아이폰 X' } -> { item: '아이폰 X', price: 100000, color: 'spaceGray' }
{ item: '아이폰 XS', price: 100000, color: 'white' } -> { item: '아이폰 XS', price: 100000, color: 'white' }
```

#### 2. resource가 없을 시,

> 리소스에 대해 직접적으로 접근할 수 있는 Key 값이 있다고 해야한다. 
> ex) products/iphone

- PUT: 리소스가 없다고 판단해 새롭게 추가한다.
- PATCH: 리소스가 없다고 판단하고 생성하지 않는다.

#### 3. 멱등성

1. PUT -> resource에 대한 changed resource를 변경하는 것
2. PATCH -> resource에 대해 변경을 request하는 것 

그렇기 때문에 patch는 resource를 다루지 않는다는 의미에서 idempotent(멱등)하지 않다라고 보는 것이지 resource 타입으로 보면 멱등하다고도 볼 수 있다. 즉 멱등하게 운영해도 된다.

### 참고

https://www.qu3vipon.com/idempotence-of-patch
https://datatracker.ietf.org/doc/html/rfc5789#section-2