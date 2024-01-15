## 📃 프로젝트 구조
```
📦 
├─ .gitignore
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ settings.gradle
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ umc
   │  │     └─ easyexcel
   │  │        ├─ apiPayload               --> api 응답 정보를 정하는 코드 저장 폴더
   │  │        │  ├─ code
   │  │        │  │  └─ status             --> 에러 상태 코드 저장하는 폴더
   │  │        │  └─ exception             --> 예외 폴더
   │  │        │     └─ handler            
   │  │        ├─ config
   │  │        │  └─ SwaggerConfig.java
   │  │        ├─ converter
   │  │        ├─ domain
   │  │        │  ├─ common                --> 기본 엔티티 클래스 저장하는 폴더
   │  │        │  ├─ enums                 --> enum 저장하는 폴더
   │  │        │  └─ mapping               --> 매핑 테이블 엔티티 클래스 저장하는 폴더
   │  │        ├─ repository
   │  │        ├─ service               
   │  │        ├─ validation
   │  │        │  ├─ annotation            --> 커스텀 어노테이션 저장하는 폴더
   │  │        │  └─ validator             --> 어노테이션에서 사용하는 유효성 로직 코드를 저장하는 폴더
   │  │        └─ web
   │  │           ├─ controller           
   │  │           └─ dto                   
   │  └─ resources
   │     └─ application.yml
   └─ test
      └─ java
         └─ umc
            └─ easyexcel
               └─ EasyExcelApplicationTests.java
```
