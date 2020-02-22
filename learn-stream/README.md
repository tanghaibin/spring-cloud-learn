描述

`对于spring integration项目的封装，简化了对于消息的使用`
核心概念

1.发布-订阅
    
    `对于rabbitmq与kafka两个概念不一样，在rabbitmq中对应的是exchange(交换机类型为topic，每个消费者对应着一个队列，队列名称根据 '交换机名称.随机字符串'生成，所以能分发到所有消费者端)，而在kafka是对应topic主题`
2. 消息分组
    
    `避免同一应用多台机器部署从而造成消息重复消费, 使用了消息分组会轮询一台机器来消费`
3. 消息分区
   
    `为了保证同一类型的消息被同一台机器消费`
### 使用概念
1. interface source

    `定义消息发送者`
2. interface sink

    `定义消息接收者`
3. interface Processor 

    `继承了source与sink 接口`
    
最佳实践
1. 使用source发送端
2. 使用sink接收端
3. processor继承sink与source

binder
1. 解耦应用与具体消息组件的交互,
2. stream中只实现了rabbitmq与kafka两种消息组件的binder

binging
1. 由绑定器把output与input绑定到具体的交换器上的两个通道叫做绑定通道
2. output与input 通道属性可配置化