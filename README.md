# 🧑🏻‍💻 InterviewPrep 
### 👥  팀원
|                                         Backend                                          |                                         Backend                                          |                                         Backend                                          |                                       Frontend                                        |                                        Frontend                                         |
| :--------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------: | 
| [이종복](https://github.com/LeeJongbokz) | [진은혜](https://github.com/Jineh) | [임정택](https://github.com/wjdxor) | [도윤](https://github.com/N3theri9N) | [이지홍](https://github.com/lee-ji-hong) |
<br>

### 📖 개요
- **기술면접을 준비하는 개발자를 위한 플랫폼입니다.** <br>
- 답변을 공유하고 다른 답변과 비교할 수 있습니다. <br>
- 마음에 드는 답변을 추천하고, 최고의 답변을 공부할 수 있습니다. <br><br>
### 🛠️ 기술 스택
#### 백엔드
Java 11, SpringBoot 2.3, Gradle, MySql, Redis, AWS EC2, Docker
#### 프론트엔드
React


### 브랜치 관리 전략

### ERD
<img width="1074" alt="스크린샷 2022-10-30 오전 10 40 29" src="https://user-images.githubusercontent.com/38105420/198858782-139341d1-c8c7-4001-b506-6749f8df0b16.png">

<br>


### API 명세
https://tarry-minibus-78a.notion.site/API-38be066e369744c186225d11f64a0f71

<br>

| URL | Method | request | response | 설명 |
| --- | --- | --- | --- | --- |
| /question/{type} | get |  | Page<QuestionDTO> | 특정 타입의 문제들을 조회한다. |
| /question/single/{id} | get |  | QuestionDTO | 한 문제를 조회한다. |
| /question | post | QuestionDTO |  | 문제를 작성한다. |
| /question/{id} | put | QuestionDTO | Question | 문제를 수정한다. |
| /question/{id} | delete |  |  | 문제를 삭제한다. |
| /answer | post | AnswerRequestDTO |  | 답변을 작성한다. |
| /answer/{id} | get |  | AnswerResponseDTO | 답변을 조회한다. |
| /answer/{id} | delete |  |  | 답변을 삭제한다. |
| /heart/{id} | post |  |  | 답변을 추천한다. |
| /heart/{id} | delete |  |  | 답변추천을 취소한다. |
| /member/login | post |  |  | 로그인 시도한다. |

<br><br>
### 📝 프로젝트 구성도(백엔드)
![스크린샷 2022-10-29 오후 10 10 33](https://user-images.githubusercontent.com/38105420/198833377-6eca4782-1bc7-4f20-9f88-8047158be694.png)
<br>
### ⚠️ 기술적 issue 해결 과정
좋아요(추천) 기능 구현 및 동시성이슈
해결 : https://github.com/LeeJongbokz/interviewPrep/pull/100
