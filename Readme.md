## 다중 도메인, 다중 모듈 스프링 기반 샘플웹 프로젝트

### 프로젝트 구조

```
multi-domain-web-demo
├── commons : 공통모듈
│   ├── logs
│   └── src
│       ├── main
│       └── test
├── db
├── domains-mybatis : 도메인 모듈 (mybatis)
│   ├── logs
│   └── src
│       ├── main
│       └── test
├── domains-orm : 도메인 모듈 (orm)
│   ├── logs
│   └── src
│       ├── generated
│       ├── main
│       └── test
├── gradle
│   └── wrapper
├── logs
└── public-web : 웹 모듈 (jsp, api 서비스)
    ├── logs
    └── src
        ├── main
        └── test
```

#### 1. 공통 모듈 (commons)

#### 2. 도메인 모듈

**ORM 모듈 (domains-orm)**

main 폴더에는 Querydsl query type class를 위한 generated 폴더, java, resources 폴더로 구성됨.
```
├── generated : entities 폴더의  Querydsl query type 클래스 생성
│   └── com
│       └── domain
│           └── orm
│               └── entities
│                   ├── QBook.java
│                   ├── QHistory.java
│                   └── QUser.java
├── java
│   └── com
│       └── domain
│           └── orm
│               ├── configs : datasource, entities, jpa, querydsl javaconfig 설정파일
│               │   └── DomainConfiguration.java
│               ├── entities : 엔티티 소스 폴더
│               │   ├── Book.java
│               │   ├── BookStatus.java
│               │   ├── History.java
│               │   ├── HistoryActionType.java
│               │   ├── User.java
│               │   └── UserLevel.java
│               ├── repositories : jpa 소스 폴더
│               │   ├── BookRepository.java
│               │   ├── HistoryRepository.java
│               │   └── UserRepository.java
│               └── services : service 소스 폴더
│                   ├── BookService.java
│                   ├── BookServiceImpl.java
│                   └── HelloString.java
└── resources
    ├── connect.properties : 데이터베이스 접속 프로퍼티 파일
    └── logback.xml : 로그백 설정 XML 파일
```

**MyBatis 모듈 (domain-mybatis)**

main 폴더내 java와 resources 폴더의 구조를 아래와 같이 구성함.
```
java/com.domain.mybatis
├── configs
│   └── MybatisConfiguration.java : datasource, mybatis javaconfig 설정파일
├── core
│   └── Mapper.java : Mapper @interface
├── entities : data Model 클래스
│   ├── Book.java
│   ├── BookStatus.java
│   ├── User.java
│   └── UserLevel.java
├── modules : Mybatis Mapper 소스
│   ├── BookMapper.java
│   └── UserMapper.java
└── services : 서비스 소스
    ├── Book2Service.java
    └── Book2ServiceImpl.java

```

```
resources
├── META-INF
│   └── mybatis : 설정파일 및 메퍼 XML 파일
│       ├── configuration.xml
│       └── mappers
│           ├── BookMapper.xml
│           └── UserMapper.xml
├── connect.properties : 데이터베이스 접속 프로퍼티 파일
└── logback.xml : 로그백 설정 XML 파일
```

#### 3. 웹 모듈 (public-web)

1. REST API 서비스 제공
2. JADE JSP 서비스 제공

웹서비스 모듈 소스 구조
```
├── java
│   └── com
│       └── web
│           ├── aops : REST방식의 경우 ResponseBody 어노테이션을 이용해 ResultData를 레퍼시켜 활용.
│           ├── configs : 웹 환경 JavaConfig 파일
│           ├── controllers
│           │   ├── mybatis : mybatis를 이용한 컨트롤러
│           │   │   ├── api : REST 방식
│           │   │   └── pub : 웹페이지 방식, Jade Sample
│           │   ├── orm : orm를 이용한 컨트롤러
│           │   │   ├── api : REST 방식
│           │   │   └── pub : 웹페이지 방식, Jade Sample
│           │   └── test : 테스트 컨트롤러
│           │       ├── api
│           │       └── pub
│           └── vo
├── resources : 리소스 폴더
└── webapp : 웹 리소스
    └── WEB-INF
        ├── jade
        │   └── book
        └── jsp

```

### 데이터베이스 

MySql 데이터베이스를 활용하였으며, DB 폴더에 bookstore.sql bookstore-data.sql을 MySql Client Tool을 이용해서 생성.
