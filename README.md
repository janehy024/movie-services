## **프로젝트 소개**
  jpa 기반 영화예매 시스템 DB 설계 v2
<br><br>

#### 개발 기한
  2024.01

#### 변경 사항
  초기 프로젝트는 단일 디렉토리 구조에서 모든 개발과 테스트가 이루어졌다. 이 방식은 빠른 개발을 가능하게 했지만, MVC 패턴을 학습하는 과정에서 구조의 비효율성과 유지보수 및 확장성의 한계를 깨닫게 되었다. 이 문제를 해결하기 위해 리팩토링을 진행했다. 시스템 내의 각 기능을 독립적인 도메인, 서비스, 리포지토리 구조로 분리하여 아키텍처를 재정비했다. 또한, 별도의 테스트 코드를 작성하여 기능별로 세분화된 단위 테스트와 통합 테스트를 통해 기능이 정상적으로 동작하는지 확인할 수 있도록 했다.


## 구현 기능
**1. 회원 관련 기능**
  - 회원 등록 및 삭제
  - 회원 정보 수정

**2. 영화 예매**
   - 상영 정보 조회
   - 좌석 선택
   - 영화 예매/취소
   - 영화 예매 내역 조회

**3. 영화 관련 기능**
   - 영화 등록
   - 영화 수정
   - 영화 정보 조회
   - 배우 정보 조회
   - 감독 정보 조회

**4. 데이터 관련**
   - 배우 및 감독 정보 등록
   - 상영 정보 등록
<br>

## 기술 스택
|분류|기술|
| :-: |:- |
|Language| <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> |
|IDE| <img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white"> |
|Framework| <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=black"> <img src="https://img.shields.io/badge/jpa-ffffff?style=for-the-badge&logo=jpa&logoColor=black">  <img src="https://img.shields.io/badge/hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white"> 
|Build Tool| <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> |
|DB| <img src="https://img.shields.io/badge/H2-0019f4?style=for-the-badge&logo=h2&logoColor=white"> |
|Collaboration| <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> |
<br>

## **프로젝트 구조**
```
📦 
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ libs
├─ settings.gradle
└─ src
   ├─ main
   │  ├─ generated
   │  │  └─ movie
   │  │     └─ domain
   │  │        ├─ QActor.java
   │  │        ├─ QAddress.java
   │  │        ├─ QBaseEntity.java
   │  │        ├─ QDirector.java
   │  │        ├─ QMovie.java
   │  │        ├─ QMovieWorker.java
   │  │        ├─ QScreen.java
   │  │        ├─ QScreenSeat.java
   │  │        ├─ QSeat.java
   │  │        ├─ QTheater.java
   │  │        ├─ QTicket.java
   │  │        ├─ QUser.java
   │  │        └─ QWorker.java
   │  └─ java
   │     └─ movie
   │        ├─ MovieServiceApplication.java
   │        ├─ api
   │        │  ├─ ApiClient.java
   │        │  ├─ MovieApiController.java
   |        |  ├─ MovieApiService.java
   │        │  └─ vo
   │        │     ├─ ActorVO.java
   │        │     ├─ BoxOfficeResultVO.java
   │        │     ├─ BoxOfficeVO.java
   │        │     ├─ DirectorVO.java
   │        │     ├─ Genrevo.java
   │        │     └─ SearchMovieInfoVO.java
   │        ├─ domain
   │        │  ├─ Actor.java
   │        │  ├─ Address.java
   │        │  ├─ BaseEntity.java
   │        │  ├─ Director.java
   │        │  ├─ Genre.java
   │        │  ├─ Movie.java
   │        │  ├─ MovieWorker.java
   │        │  ├─ Screen.java
   │        │  ├─ ScreenSeat.java
   │        │  ├─ Seat.java
   │        │  ├─ Theater.java
   │        │  ├─ Ticket.java
   │        │  ├─ User.java
   │        │  └─ Worker.java
   │        ├─ dto
   │        │  ├─ MovieSearchDTO.java
   │        │  └─ TicketDTO.java
   │        ├─ repository
   │        │  ├─ MovieRepository.java
   │        │  ├─ ScreeningRepository.java
   │        │  ├─ TheaterRepository.java
   │        │  ├─ TicketRepository.java
   │        │  ├─ UserRepository.java
   │        │  └─ WorkerRepository.java
   │        └─ service
   │           ├─ InitDb.java
   │           ├─ MovieService.java
   │           ├─ ScreeningService.java
   │           ├─ TheaterService.java
   │           ├─ TicketService.java
   │           └─ UserService.java
   └─ test
      └─ java
         └─ movie
            └─ service
               └─ TheaterServiceTest.java
```
©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)

## **DB 설계 (ERD)**
![영화예매시스템](https://github.com/seoy316/movie_ticket/blob/main/img/영화예매시스템v1_erd.png)
<br><br>

## 역할
### 장서윤
- 회원 관련 기능
- 영화 관련 기능
- ERD 설계
- 영화 api로 영화 정보 자동 등록
- 패키지 구조 설계

### 장현영
- 영화 예매 기능
- 데이터 관련
- ERD 설계
- 프로젝트 세팅
