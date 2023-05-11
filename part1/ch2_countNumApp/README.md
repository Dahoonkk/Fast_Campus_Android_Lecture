# 숫자세기(계수기) 앱
- LinearLayout을 이용하여 화면 그리기
- 유저 인터페이스 구성

<br>

![img.png](../ch2_countNumApp/result.gif)

<br>

### 구현 기능
- (+) 버튼 클릭시 숫자를 1씩 올리기
- 초기화 버튼을 클릭 시, 숫자를 0으로 변경하기

<br>

---
# Chapter 1. 학습 목표
- 간단한 기능을 구현하고, UI를 그릴 수 있음
  - LinearLayout을 이용하여 간단한 UI를 그릴 수 있음
  - Activity를 통해 사용자 입력에 대한 출력을 보여줄 수 있음
- UI
  - LinearLayout
  - TextView
  - Button
- Kotlin
  - val, var
  - null
  - 복합대입 연산자 +=
- Android
  - Activity
  - R 파일
  - findViewById
  - setOnClickListener
  - log

---

##  한 걸음 더
1. 화면의 방향이 변경된다면 어떻게 해야할까?
   2. 값을 유지하려면 어떻게 해야할까? 
   3. 화면 방향에 상관없이 버튼을 보이게 하려면 어떻게 해야할까?
      4. numberTextView의 height 값을 지정하지 않고, weight를 이용


2. weight를 넣을 때 dimension에 왜 0dp를 넣으라고 했을까?
   3. LinearLayout의 weight 값이 적용되기 위해선, orientation에 따라, width 도는 height의 값이 0dp 여야 함
      4. orientation : vertical -> layout_height = "0dp"
      5. orientation : horizontal -> layout_width = "0dp"