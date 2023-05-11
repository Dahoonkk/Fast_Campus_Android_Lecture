# 📢 2. 단위 변환기

---
### 📌 개요
- 입력, 출력 단위를 선택할 수 있음
- 입력 ↔️ 출력 단위를 반대로 변경할 수 있음
- 입력창에 값을 입력하면 바로 결과창에 단위가 변환딘 값이 노출

<br>

![](result.gif)

<br>

#### 💪🏻 구현 기능
- cm를 m로 변환
- 값을 입력하면, 바로 변환된 값이 노출
  - 입력값은 자연수로 한정
- 단위를 반대로 변경
- 단위 변환 연산
  - cm ➡️ m (x 0.01)
  - m ➡️ cm (x 100)
  
 <br>

---
### ❗️ 학습 목표 ❗
- 간단한 기능을 구현하고, UI를 그릴 수 있음
  - ConstraintLayout을 이용하여 간단한 UI를 그릴 수 있음
  - 키보드로 사용자가 입력한 값을 받을 수 있음
  - 사용자의 입력값이 변경되면, 바로 변환된 값을 보여줄 수 있음
  - 방향이 변경됐을 때, 값을 유지하는 방법
- UI
  - ConstraintLayout
  - EditText
- Android
  - ViewBinding -> findViewById를 대체
  - onSaveInstanceState

<br>

---
### 💬 활동 수명 주기에 관한 이해
- 사용자가 앱을 탐색하고, 앱에서 나가고, 앱으로 다시 돌아가면, 앱의 Activity 인스턴스는 수명 주기 안에서 서로 다른 상태를 통해 전환됨
- Activity 클래스는 활동이 상태 변화를 알아차릴 수 있는 여러 콜백을 제공
- 적시에 알맞은 작업을 하고 적절하게 전환을 처리하면 앱이 더욱 안정적으로 기능할 수 있음
- 수명 주기 콜백을 잘 구현하면 앱에서 다음과 같은 문제가 발생하지 않도록 예방하는 데 도움이 될 수 있음
  - 사용자가 앱을 사용하는 도중에 전화가 걸려오거나 다른 앱으로 전환할 때 비정상 종료되는 문제
  - 사용자가 앱을 활발하게 사용하지 않는 경우 귀중한 시스템 리소스가 소비되는 문제
  - 사용자가 앱에서 나갔다가 나중에 돌아왔을 때 사용자의 진행 상태가 저장되지 않는 문제
  - 화면이 가로 방향과 세로 방향 간에 회전할 경우, 비정상 종료되거나 사용자의 진행 상태가 저장되지 않는 문제

<br>

#### 💬 구성 변경 발생
- 가장 눈에 잘 띄는 예시는 세로 모드와 가로 모드 간 방향 변경일 것
  - 구성 변경이 발생하면 활동이 제거되고 다시 생성됨
  - 원래 활동 인스턴스에서는 onPause(), onStop() 및 onDestroy() 콜백이 트리거 됨
  - 그리고 활동의 새 인스턴스가 생성되고 이 인스턴스에는 onCreate(), onStart() 및 onResume() 콜백이 트리거 됨

<br>

---
## 💬 UI 상태 저장 및 복원하는 방법은?
- 회전 또는 멀티 윈도우 모드로의 전환가 같은 구성 변경사항이 발생하더라도 동일하게 유지하는 방법
  - 구성 변경이 발생하면 기본적으로 활동을 소멸시켜 활동 인스턴스에 저장된 모든 UI 상태를 제거
    - 다시 불러올 경우 UI 상태 재생성
  - **ViewModel**, **onSaveInstanceState()** 를 활용하면 해결할 수 있음

<br>

---
# 🚶🏻 한 걸음 더
1. 소수점이 정확하지 않은 이유는 뭘까?
   2. Java에서는 실수를 표현할 때는 부동 소수점 방식을 사용하는데 이때, 오차가 생길 수 있음 -> (why? 근사값을 이용하기 때문)
   3. 부정확성을 해결하기 위해, BigDecimal이라는 자료형을 사용하면 됨
      4. 상세한 이유는 이해하지 못하더라도, 소수점이 정확하지 않을 수 있다는 점을 인지하고, 정확한 계산을 필요로 할 때 다른 자료형 활용
      5. [About](https://ko.wikipedia.org/wiki/%EB%B6%80%EB%8F%99%EC%86%8C%EC%88%98%EC%A0%90)
2. Activity Lifecycle을 충분히 이해해보자