# SpringClound 全家桶
![SpringCloud架构图](https://github.com/fuhongyu/SpringClound/blob/master/Springboot%E6%9E%B6%E6%9E%84%E5%9B%BE.jpg)
#### 此文档列表内容为： 
### 1、sd-eureka-server 注册中心 7900
### 2、两个服务提供者：sd-provider-user（7901） 和sd-provider-user2  (7902)
### 3、sd-zuul API网关  8050
### 4、sd-customer-feign (8010)  实现RESTFUL规范调用,相对于RestTemplate，使用feign不用记API，但需要自己写接口
### 5、sd-customer-client，消费者，@LoadBalanced标签是，Ribbon实现负载均衡 
### 6、sd-jt-sso 实现单点登陆
   ### sd-jt-sso 消费者
   ### sd-jt-sso-provider 生产者
###   单点登录实现的原理是：将用户登录信息，MD5+sault加密后，以<K,V>格式放入redis中，此后用户在其他地方登录都从redis中查询登录信息。本项目中redis为centos7中docker拉取镜像的方式创建。
本人csdn博客地址：https://blog.csdn.net/fhy569039351，欢迎交流！
