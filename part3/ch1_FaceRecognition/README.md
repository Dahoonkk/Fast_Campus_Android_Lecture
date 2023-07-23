# 📢 얼굴 인식 서비스

<br>

gif

<br>

---
## 💪🏻 개요 및 학습목표

- 카메라 프리뷰 활성화
- 얼굴 인식 모듈 설치
- 얼굴 인식 범위 Mask 씌우기
- 간단한 요구사항을 통한 상호작용
- 인식 진행 사항 출력

---
## ❗️ 구현에 필요한 기술들

- Module
- CameraX Preview
- Permission
- Google Vision
- CustomView - Paint
- Bezier Curves
- PathMeasure

---
### ⁉️ CameraX

- 더 쉬운 카메라 앱 개발을 위해 빌드된 Jetpack 라이브러리
  - Camera2를 사용하므로 Android 5.0(API level 21)까지만 지원
  - 미리보기, 이미지 분석, 이미지 캡쳐, 동영상 캡쳐 지원
  - 생명주기를 인식
  - 장치 호환성 문제를 해결함으로써 기기별 분기코드 감소
  - 특정 디바이스에 종속되는 Bokeh, HDR 등 지원

---
### ⁉️ 베지에 곡선(Bezier Curve)

- 매끄러운 곡선을 그리기 위한 것
- 조절점을 따라 이은 직선1과 직선1을 따라 이은 직선2
- 직선2 위에서 일정하게 움직이는 점이 그리는 궤적을 의미함

<br>

![img.png](img.png)

--- 
### ⁉️ 얼굴 인식

- 얼굴 특징 인식 및 위치 찾기
- 얼굴 특징의 윤곽 가져오기
- 표정 인식
- 동영상 프레임에서 얼굴 추적
- 동영상 프레임에서 실시간으로 처리
- [ml-kit](https://developers.google.com/ml-kit/vision/face-detection)을 활용