# Banking-Server
Spring으로 뱅킹 서버 구축하기

## Feature
- 친구 추가 API
- 내 친구 목록 조회 API
- **계좌 이체 API**
    - 계좌 이체는 친구끼리만 가능
    - 계좌 이체는 트랜잭션 원자성이 보장
    - 하나의 계좌에 동시에 돈이 입금되는 상황이 발생 가능
        - 이러한 상황의 동시성 문제를 해결
    - 계좌 이체가 완료된 이후에는 알람 전송
        - 알람은 따로 서버가 있다고 가정하고 외부 API를 호출하는 Mocking 로직 작성
        - 예시 : numbleAlarmService.notify(userId, message);
            - 실제 동작 : Thread.sleep(500);
- 계좌 조회 API (내 계좌만 조회 가능)
- 회원가입 API

<br>

## Project Environment
- Language 
  - Java 17
- Framework
  - Spring Boot 3.0
- Library
  - Lombok
  - Spring Web
  - Spring Data Jpa
  - Spring Security
  - Thymeleaf
  - MySQL Driver
- Database
  - MySQL 8.0
- VCS
  - GitHub

## Decription
