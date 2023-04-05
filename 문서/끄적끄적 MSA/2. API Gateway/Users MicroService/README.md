User 서비스를 만들어보며 h2 데이터 베이스 연동

ModelMapper를 활용한 DTO, VO, ENTITY 간에 전달 방법들 사용

userService를 Eureka 서버에 등록하여 회원가입을 진행함.


#### h2 관련 설정
* jdbc:h2:mem:testdb
    - In-memory DB다. DB를 연결하고 닫으면 해당 DB는 사라진다. 어플리케이션이 동작할 때에만 존재하는 DB인 것이다.
* jdbc:h2:~/dbname
    - Local DB다. 직접 로컬에서 홈디렉토리로 가보면 db들이 생성되있는 것을 확인할 수 있다. 해당 DB는 저장되며 계속 사용할 수 있다.

h2에서 datasource를 잡아주면 자동으로 h2 디비 생성 시, 테이블을 만들어주고 있음. 다만 최신 버전에서는 보안상의 이슈로 디비를 바로 생성하지 않으니 참고할 것.