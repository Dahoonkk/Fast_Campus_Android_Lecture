# 📢 쇼핑몰 앱

<br>

gif

<br>

- 여러 뷰타입의 Json을 동적으로 List에 표현
- List 공통화
  - 거의 모든 페이지에 대해 특별한 개발없이 리스트 출력 가능
  - View 타입이 추가되거나 삭제될 때도 한 쪽에서만 수정 가능하기 때문에 유지보수 측면에서도 이점
- DI 적용
  - Dependency Injection
  - Hilt 사용
- Coroutine, Paging3 적용

---
## 💪🏻구현에 필요한 기술들

- MVVM
- Hilt
- Coroutine
- Flow
- Paging3
- JsonDeserializer

<br>

- 완성 기술
  - CoordinatorLayout으로 AppBar 접히는 부분 구현
  - 복잡한 ViewType의 Json 파싱
  - 파싱한 데이터를 동적으로 처리
  - API 내용의 변화에 클라이언트 코드 수정 X
  - Coroutine, Flow 사용
  - DI(Hilt) 사용

---
## 📌 [Hilt란?](https://developer.android.com/training/dependency-injection/hilt-android?hl=ko)

Google Dagger를 기반으로 만든 Dependency Injeciton 라이브러리

Android App에 특화된 DI
- Android class에 의존성 주입을 지원하고 생명 주기를 자동으로 관리

---
## 📌 Coroutine이란?



---
## 📌 Flow란?



---
## 📌 Paging3이란?



---
### 📌 List Item을 동적으로 서버로부터 받아와서 그려주려면 어떻게 해야할까?