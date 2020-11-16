# Microservices Architecture

## 微服务架构核心

### 什么是微服务架构？

> 马丁·福勒（Martin Fowler) 

- 一组小的服务
- 独立的进程
- 轻量级通信
- 基于业务能力
- 独立部署
- 无集中式管理
- 一种架构风格，将单体应⽤划分成一组⼩的服务，服务之间相互协作，实现业务功能
- 每个服务运行在独⽴的进程中，服务间采用轻量级的通信机制协作（通常是HTTP/JSON）
- 每个服务围绕业务能力进行构建，并且能够通过⾃动化机制独立地部署
- 很少有集中式的服务管理，每个服务可以使用不同的语⾔言开发，使用不同的存储技术
- 参考： https://www.martinfowler.com/articles/microservices.html 

> Adrian Cockcroft （Netflix，网飞）

- Loosely coupled service oriented architecture with bounded context
- 基于有界上下⽂文的， 松散耦合的⾯面向服务的架构 



### 微服务的利弊

- 利
  - 强模块化边界
  - 可独立部署
  - 技术多样性 
- 弊
  - 分布式系统复杂性
  - 最终一致性
  - 运维复杂性
  - 测试复杂性 

> 如果你搞不定一个单块应用，别指望微服务能够拯救你！ 



### 康威法则

- Organizations which design systems … are constrained to produce designs which are copies of the communication structures of these organizations.
- 设计系统的组织，其产生的架构设计等价于组织间的沟通结构 
- 为什么架构师需要，了解技术架构与组织架构？

![1605531509297](MicroserviceArchitecture.assets/1605531509297.png)





### 微服务的适用性 

> 企业应该在什么时候开始考虑引入微服务？
>
> 业务团队发展到百人的时候，就可以开始引入微服务。

![1605531737651](MicroserviceArchitecture.assets/1605531737651.png)



#### 单块优先 

> 一开始不需要直接走微服务，风险高！

![1605531840007](MicroserviceArchitecture.assets/1605531840007.png)



### 微服务组织架构 

- 从传统职能型到跨职能产品型 

![1605532145228](MicroserviceArchitecture.assets/1605532145228.png)

- 端到端，闭环（End-end ownership）
- who buid it, who run it ！
- 两个披萨原则！

![1605532286843](MicroserviceArchitecture.assets/1605532286843.png)





### 中台战略和微服务 

- 技术中台
- 业务中台
- 业务前台
- 大中台，小前台

![1605532433884](MicroserviceArchitecture.assets/1605532433884.png)





### 服务分层概念 

- 基础服务
- 聚合服务

![1605532838876](MicroserviceArchitecture.assets/1605532838876.png)





### 微服务总体技术架构体系图 

- 接入层
- 网关层
- 业务服务层
- 支撑服务
- 平台服务
- 基础设施层

![1605533233587](MicroserviceArchitecture.assets/1605533233587.png)





### 服务发现 LB

#### 独立LB 

- 硬件 F5
- 软件 Nginx
- LB，(Load Balancer)

![1605533558883](MicroserviceArchitecture.assets/1605533558883.png)



#### 进程内LB 

![1605533693374](MicroserviceArchitecture.assets/1605533693374.png)



#### 主机独立进程LB 

- 运维成本比较高

![1605533778803](MicroserviceArchitecture.assets/1605533778803.png)



### 微服务网关 

#### API Gateway

- 屏蔽内部服务的细节，对外展示一个接口
- 反向路由
- 认证安全
- 限流熔断
- 日志监控

![1605533993845](MicroserviceArchitecture.assets/1605533993845.png)



![1605534058593](MicroserviceArchitecture.assets/1605534058593.png)



#### Netflix Zuul 网关架构 

![1605534297358](MicroserviceArchitecture.assets/1605534297358.png)



![1605534497967](MicroserviceArchitecture.assets/1605534497967.png)



### Netflix 微服务服务发现路路由体系 

- Eurka(服务注册中心) + Zuul(网关层)

![1605534606840](MicroserviceArchitecture.assets/1605534606840.png)



### 微服务配置中心原理 

- 一般都是自己写的配置文件，到处都是，无法追溯
- 非常重要的微服务组件

![1605534807381](MicroserviceArchitecture.assets/1605534807381.png)



#### 携程 Apollo 配置中心

- 保证高可用，设计周到
- 定时拉取与实时推送配置

![1605535018697](MicroserviceArchitecture.assets/1605535018697.png)





### RPC vs REST 

- 通信协议

![1605535259078](MicroserviceArchitecture.assets/1605535259078.png)



### 服务框架和治理 

> Alibaba的 Dubbo框架。

- 服务注册发现
- 服务负载均衡
- 服务路由（软路由）
- 日志监控
- 延迟监控
- 调用链监控
- 限流熔断措施
- 安全和访问控制
- RPC和REST通讯调用
- 序列化
- 代码生成，契约开发
- 统一异常处理
- 文档
- 配置中心集成
- 后台服务集成

![1605535662796](MicroserviceArchitecture.assets/1605535662796.png)



### 五层监控体系和监控分类 

- 基础设施监控
- 系统层监控
- 应用层监控
- 业务监控
- 端用户体验监控

![1605536003938](MicroserviceArchitecture.assets/1605536003938.png)





#### 监控架构和主流技术栈 

- 一般监控架构
- 时间序列数据库：InfluxDB和Grafana

![1605536222832](MicroserviceArchitecture.assets/1605536222832.png)



### 调用链监控

#### Trace调用链监控原理 

- 启动一个Span,生成 Span ID, trace ID。

![1605536452307](MicroserviceArchitecture.assets/1605536452307.png)



#### 调用链监控选型 

- Cat
- Zipkin
- Pinpoint

![1605536532233](MicroserviceArchitecture.assets/1605536532233.png)







### Netflix Hystrix 断路器原理 

- 限流，熔断，隔离，降级
- 雪崩效应

![1605536788543](MicroserviceArchitecture.assets/1605536788543.png)





### 基于镜像治理和多环境的持续交付流水线 

- 容器部署技术
- Docker，环境一致性和镜像部署
- 镜像治理中心，docker registry。

![1605537191482](MicroserviceArchitecture.assets/1605537191482.png)



#### 蓝绿、金丝雀和灰度发布 

- 蓝绿部署，依赖网关，进行新老版本切换
- 灰度发布，保证蓝绿部署，渐进过渡

![1605537391795](MicroserviceArchitecture.assets/1605537391795.png)





### 资源调度框架 Mesos 架构 

- Mesos 最早来自谷歌，后来开源
- Mesos 将所有的资源集合起来，成为大型计算机，只作为资源调度
- Framework 进行任务的运行

![1605537618686](MicroserviceArchitecture.assets/1605537618686.png)





### 基于容器云发布体系 

![1605537801145](MicroserviceArchitecture.assets/1605537801145.png)





## 微服务架构实战



























