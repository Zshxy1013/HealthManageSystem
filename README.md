# 疫情防控健康打卡管理系统

#### 介绍
大作业


#### 软件架构

```
│      
├─build
│  └─classes
│      └─core
│          ├─bean
│          │      UserDataBean.class
│          │      CookieBean.class
│          │      AdminBean.class
│          │      
│          ├─dao
│          │      UserDataDao.class
│          │      CookieCacheDao.class
│          │      
│          ├─service
│          │      UserDataUpdate.class
│          │      GenchPlatformAuth.class
│          │      
│          ├─contoller
│          │      LoginServlet.class
│          │      
│          └─util
│                  DBHelp.class
│                  
└─src
    └─main
        ├─java
        │  └─core
        │      ├─bean
        │      │      UserDataBean.java
        │      │      CookieBean.java
        │      │      AdminBean.java
        │      │      
        │      ├─dao
        │      │      UserDataDao.java
        │      │      CookieCacheDao.java
        │      │      
        │      ├─service
        │      │      UserDataUpdate.java
        │      │      GenchPlatformAuth.java
        │      │      
        │      ├─contoller
        │      │      LoginServlet.java
        │      │      
        │      └─util
        │              DBHelp.java
        │              
        └─webapp
            ├─META-INF
            │      MANIFEST.MF
            │      
            └─WEB-INF
                └─lib
                        mysql-connector-java-8.0.28.jar
                        taglibs-standard-impl-1.2.5-migrated-0.0.1.jar
                        taglibs-standard-spec-1.2.5-migrated-0.0.1.jar
```