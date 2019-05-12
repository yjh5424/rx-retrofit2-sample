# retrofit2-rx-sample

## HTTP란?  
WWW 상에서 정보를 주고받을 수 있는 프로토콜이다. 즉 HTTP는 클라이언트와 서버 사이에 이루어지는 요청/응답(request/response)을 웹브라우저(url)를 통해 통신한다.

## Android 에서 Http 통신 하는 법
다양한 라이브러리가 존재하지만 Retrofit2이 다른 라이브러리에 비해 성능이 좋고 사용성이 좋음 

## Retrofit2 
REST + OKHTTP  

## 서버 개발자랑 협업 할때 필요한 키워드

GET : 리소스를 조회/검색을 하는 액션

POST : 리소스를 등록하는 액션

DELETE : 리소스를 지우는 액션

PATCH : 리소르를 수정/갱신 하는 액션

PUT : 리소르를 수정/갱신 하는 액션

Query : something 에 해당하는 값을 넣어줌
total url = http://httpbin.org/something?=12 

Path : 해당하는 경로 위치에 해당하는 값을 넣어줌
total url = http://httpbin.org/something/12

Body : url속에 정보를 보여주는게 아니라 속으로 데이터를 넘겨줌 

Header : 서버한테 요청시 부가적인 정보를 담는 곳 
(토큰, 세션, 버전 해당 요청과 큰 관련이 없는 정보들)

Json : 데이터 형식으로써 []이 있다면 배열 {}이 있다면 오브젝트.
대부분의 경우 서버랑 통신할 때 json으로 데이터를 주고 받음.

## http://httpbin.org/get 로 Http통신해보기 

## 메인쓰레드에서 네트워크 통신을 실행하면 어떻게 될까?
안드로이드의 메인쓰레드가 UI를 처리하고 있는 와중에 
비동기 처리 로직(네트워크 등등)을 메인쓰레드에 같이 돌리게 되면 
그 작업이 끝날때 까지는 UI를 변경시킬수 없어서 안드로이드 정책상 
새로운 쓰레드가 필요한 작업들은 메인 쓰레드가 아닌 다른 쓰레드에서 실행하도록 되어있다.

![Android-Thread](https://cdn-images-1.medium.com/max/1200/1*en0HyB8_B8MeruKhFrJ-ew.png)

## Rx 오해
1. 비동기 처리만 하기위해 쓰이는 것이 아님.
2. 러닝커브는 확실히 있지만 잘쓰면 가독성과 퍼포먼스가 올라감 
3. 함수형 프로그래밍과는 다른 개념 하지만 관련은 매우 깊음!
