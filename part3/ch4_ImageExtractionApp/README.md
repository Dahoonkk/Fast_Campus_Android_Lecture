# 📢 이미지 추출 앱

<br>

gif 

<br>

- Open API를 활용한 랜덤 이미지 불러오기 구현
- MVC, MVP, MVVM, MVI 패턴으로 코드 작성

---
## 💪🏻 이 챕터에서 사용한 기술
- [Retrofit2](https://square.github.io/retrofit/)
- [Coil](https://coil-kt.github.io/coil/)
- [MVC](https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC)
- [MVP](https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%ED%94%84%EB%A6%AC%EC%A0%A0%ED%84%B0)
- [MVVM](https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EB%B7%B0%EB%AA%A8%EB%8D%B8)
- [MVI](https://jaehochoe.medium.com/%EB%B2%88%EC%97%AD-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C%EB%A5%BC-%EC%9C%84%ED%95%9C-mvi-model-view-intent-%EC%95%84%ED%82%A4%ED%85%8D%EC%B3%90-%ED%8A%9C%ED%86%A0%EB%A6%AC%EC%96%BC-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-165bda9dfbe7)

---
## 📌 MVC 패턴이란?
- Model
  - 데이터를 관리
  - 비즈니스 로직 수행
- View
  - 유저에게 보일 화면을 표현
  - 어떠한 데이터나 로직이 있으면 안됨
- Controller
  - Model과 View를 연결
  - 유저의 입력을 받고 처리

![img.png](img.png)

- 장점
  - 가장 구현하기 쉽고 단순함
  - 개발기간이 짧아짐
  - Model과 View를 분리
  - Model의 비종속성으로 재사용 가능
- 단점
  - Controller에 많은 코드가 생김
  - 유지보수의 어려움
  - View와 Model의 결합도 상승
  - 테스트코드 작성의 어려움
  - 현재는 많이 사용하지는 않지만 규모가 작고 빠르게 어플을 만들어야 하는 경우 사용