# SpringClound 全家桶
此文档列表内容为： 
### 1、sd-eureka-server 注册中心 7900
### 2、两个服务提供者：sd-provider-user（7901） 和sd-provider-user2  (7902)
### 3、sd-zuul API网关  8050
### 4、sd-customer-feign (8010)  实现RESTFUL规范调用,相对于RestTemplate，使用feign不用记API，但需要自己写接口
### 5、sd-customer-client，消费者，@LoadBalanced标签是，Ribbon实现负载均衡 
### 6、sd-jt-sso 实现单点登陆（登陆信息加密放redis）
   ### sd-jt-sso 消费者
   ### sd-jt-sso-provider 生产者

