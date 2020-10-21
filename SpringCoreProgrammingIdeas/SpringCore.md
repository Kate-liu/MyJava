# Spring Core

![Spring核心特性](SpringCore.assets/Spring核心特性.png)



## Spring Framework Overview

### Spring特性总览

#### 核心特性（core）

• IoC 容器（IoC Container）
• Spring 事件（Events）
• 资源管理（Resources）
• 国际化（i18n）
• 校验（Validation）
• 数据绑定（Data Binding）
• 类型装换（Type Conversion）
• Spring 表达式（Spring Express Language）
• 面向切面编程（AOP） 





#### 数据存储（Data Access）

• JDBC
• 事务抽象（Transactions）
• DAO 支持（DAO Support）
• O/R映射（O/R Mapping）
• XML 编列（XML Marshalling） 



#### Web技术（Web）

• Web Servlet 技术栈
	• Spring MVC
	• WebSocket
	• SockJS

• Web Reactive 技术栈
	• Spring WebFlux
	• WebClient
	• WebSocket 





#### 技术整合（Integration）

• 远程调用（Remoting）
• Java 消息服务（JMS）
• Java 连接架构（ JCA）
• Java 管理扩展（JMX）
• Java 邮件客户端（Email）
• 本地任务（Tasks）
• 本地调度（Scheduling）
• 缓存抽象（Caching）
• Spring 测试（Testing） 





#### 测试（Testing）

• 模拟对象（Mock Objects）
• TestContext 框架（TestContext Framework）
• Spring MVC 测试（Spring MVC Test）
• Web 测试客户端（WebTestClient） 





### Spring版本特性

#### java版本依赖于支持

| Spring Framework 版本 | Java 标准版 | Java 企业版           |
| --------------------- | ----------- | --------------------- |
| 1.x                   | 1.3+        | J2EE 1.3 +            |
| 2.x                   | 1.4.2+      | J2EE 1.3 +            |
| 3.x                   | 5+          | J2EE 1.4 和 Java EE 5 |
| 4.x                   | 6+          | Java EE 6 和 7        |
| 5.x                   | 8+          | Java EE 7             |





### Spring模块化设计

#### Spring模块化设计（Modular）

• spring-aop
• spring-aspects
• spring-context-indexer
• spring-context-support
• spring-context
• spring-core
• spring-expression
• spring-instrument
• spring-jcl
• spring-jdbc
• spring-jms
• spring-messaging
• spring-orm
• spring-oxm
• spring-test
• spring-tx
• spring-web
• spring-webflux
• spring-webmvc
• spring-websocket 



### Spring对java语言特性运用

#### java语法变化

![1603286858698](SpringCore.assets/1603286858698.png)

java-5-2004

- 枚举，泛型，注解，封箱（解箱）

java-6-2006

- @Override接口

java-7-2011

- Diamond语言，多Catch、Try...

java-8-2014

- Lambda语言，可重复注解，类型注解

java-9-2017

- 模块化，接口私有方法

java-10-2018

- 局部变量类型推断



#### Spring对java语言特性运用

• Java 5 语法特性

| 语法特性               | Spring 支持版本 | 代表实现                   |
| ---------------------- | --------------- | -------------------------- |
| 注解（Annotation）     | 1.2 +           | @Transactional             |
| 枚举（Enumeration）    | 1.2 +           | Propagation                |
| for-each 语法          | 3.0 +           | AbstractApplicationContext |
| 自动装箱（AutoBoxing） | 3.0 +           |                            |
| 泛型（Generic）        | 3.0 +           | ApplicationListener        |



• Java 6 语法特性

| 语法特性       | Spring 支持版本 | 代表实现 |
| -------------- | --------------- | -------- |
| 接口 @Override | 4.0 +           |          |



• Java 7 语法特性 

| 语法特性                | Spring 支持版本 | 代表实现                    |
| ----------------------- | --------------- | --------------------------- |
| Diamond 语法            | 5.0 +           | DefaultListableBeanFactory  |
| try-with-resources 语法 | 5.0 +           | ResourceBundleMessageSource |



• Java 8 语法特性 

| 语法特性    | Spring 支持版本 | 代表实现                      |
| ----------- | --------------- | ----------------------------- |
| Lambda 语法 | 5.0 +           | PropertyEditorRegistrySupport |





### Spring对JDK API实践

#### JDK 核心API

![1603287225609](SpringCore.assets/1603287225609.png)



#### Spring对JDK API实践

• < Java 5 API 

| API 类型                  | Spring 支持版本 | 代表实现                   |
| ------------------------- | --------------- | -------------------------- |
| 反射（Reflection）        | 1.0 +           | MethodMatcher              |
| Java Beans                | 1.0 +           | CachedIntrospectionResults |
| 动态代理（Dynamic Proxy） | 1.0 +           | JdkDynamicAopProxy         |



• Java 5 API 

| API 类型               | Spring 支持版本 | 代表实现                   |
| ---------------------- | --------------- | -------------------------- |
| XML 处理（DOM,SAX...） | 1.0 +           | XmlBeanDefinitionReader    |
| Java 管理扩展（JMX）   | 1.2 +           | @ManagedResource           |
| Instrumentation        | 2.0 +           | InstrumentationSavingAgent |
| 并发框架（J.U.C）      | 3.0 +           | ThreadPoolTaskScheduler    |
| 格式化（Formatter）    | 3.0 +           | DateFormatter              |



• Java 6 API 

| API 类型                       | Spring 支持版本 | 代表实现                           |
| ------------------------------ | --------------- | ---------------------------------- |
| JDBC 4.0（JSR 221）            | 1.0 +           | JdbcTemplate                       |
| Common Annotations（JSR 250 ） | 2.5 +           | CommonAnnotationBeanPostProcesso r |
| JAXB 2.0（JSR 222）            | 3.0 +           | Jaxb2Marshaller                    |
| Scripting in JVM（JSR 223）    | 4.2 +           | StandardScriptFactory              |
| 可插拔注解处理 API（JSR 269）  | 5.0 +           | @Indexed                           |
| Java Compiler API（JSR 199）   | 5.0 +           | TestCompiler（单元测试）           |



• Java 7 API 

| API 类型                  | Spring 支持版本 | 代表实现                |
| ------------------------- | --------------- | ----------------------- |
| Fork/Join 框架（JSR 166） | 3.1 +           | ForkJoinPoolFactoryBean |
| NIO 2（JSR 203）          | 4.0 +           | PathResource            |



• Java 8 API 

| API 类型                      | Spring 支持版本 | 代表实现                              |
| ----------------------------- | --------------- | ------------------------------------- |
| Date and Time API（JSR 310）  | 4.0 +           | DateTimeContext                       |
| 可重复 Annotations（JSR 337） | 4.0 +           | @PropertySources                      |
| Stream API（JSR 335）         | 4.2 +           | StreamConverter                       |
| CompletableFuture（J.U.C）    | 4.2 +           | CompletableToListenableFutureAdapt er |





### Spring对java EE API整合

#### Spring对java EE API整合

• Java EE Web 技术相关 

| JSR 规范                  | Spring 支持版本 | 代表实现                           |
| ------------------------- | --------------- | ---------------------------------- |
| Servlet + JSP(JSR 035）   | 1.0 +           | DispatcherServlet                  |
| JSTL(JSR 052)             | 1.0 +           | JstlView                           |
| JavaServer Faces(JSR 127) | 1.1 +           | FacesContextUtils                  |
| Portlet(JSR 168)          | 2.0 - 4.2       | DispatcherPortlet                  |
| SOAP(JSR 067)             | 2.5 +           | SoapFaultException                 |
| WebServices(JSR 109)      | 2.5 +           | CommonAnnotationBeanPostProcesso r |
| WebSocket(JSR 356)        | 4.0 +           | WebSocketHandler                   |



• Java EE 数据存储相关 

| JSR 规范                   | Spring 支持版本 | 代表实现              |
| -------------------------- | --------------- | --------------------- |
| JDO(JSR 12)                | 1.0 - 4.2       | JdoTemplate           |
| JTA(JSR 907)               | 1.0 +           | JtaTransactionManager |
| JPA(EJB 3.0 JSR 220的成员) | 2.0 +           | JpaTransactionManager |
| Java Caching API(JSR 107)  | 3.2 +           | JCacheCache           |



• Java EE Bean 技术相关 

| JSR 规范                               | Spring 支持版本 | 代表实现                              |
| -------------------------------------- | --------------- | ------------------------------------- |
| JMS(JSR 914)                           | 1.1 +           | JmsTemplate                           |
| EJB 2.0 (JSR 19)                       | 1.0 +           | AbstractStatefulSessionBean           |
| Dependency Injection for Java(JSR 330) | 2.5 +           | AutowiredAnnotationBeanPostProcess or |
| Bean Validation(JSR 303)               | 3.0 +           | LocalValidatorFactoryBean             |



• 资源相关 

• JSR 官方网址：https://jcp.org/
• 小马哥 JSR 收藏：https://github.com/mercyblitz/jsr
• Spring 官方文档根路径：https://docs.spring.io/spring 





### Spring编程模型

#### Spring编程模型

- 面向对象编程
- 面向切面编程
- 面向元编程
- 函数驱动
- 模块驱动

![1603287493723](SpringCore.assets/1603287493723.png)





### Spring核心价值

- 生态系统
- API抽象设计
- 编程模型
- 设计思想
- 设计模式
- 用户基础

![Spring核心价值](SpringCore.assets/Spring核心价值.png)



### 面试题

#### 什么是 Spring Framework？ 

答：Spring makes it easy to create Java enterprise applications. It provides everything you need to embrace the Java language in an enterprise environment, with support for Groovy and Kotlin as alternative languages on the JVM, and with the flexibility to create many kinds of architectures depending on an application’s needs. 



#### Spring Framework 有哪些核心模块？ 

答：
spring-core：Spring 基础 API 模块，如资源管理，泛型处理
spring-beans：Spring Bean 相关，如依赖查找，依赖注入
spring-aop : Spring AOP 处理，如动态代理，AOP 字节码提升
spring-context : 事件驱动、注解驱动，模块驱动等
spring-expression：Spring 表达式语言模块 



#### Spring Framework 的优势和不足是什么? 

答：这个问题的答案将贯穿整个系列 





## 重新认识IoC





















































