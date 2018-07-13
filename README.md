# 利用ThreadLocal 实现多数据源切换

主要应用于读写分离，以及分库时的应用。

## 具体过程

1. 在Spring-mybatis中 配置多个数据源，定义唯一id。
2. 集成框架中的AbstractRoutingDataSource 类实现提供key的方法，框架源码会在每次访问数据库时都会调用这个方法获得数据源的key，再通过key获得具体数据源。
3. 通过AOP和注解 拦截访问数据库方法，在访问前调用set key的方法。

核心在于ThreadLocal, 通过在每个线程中保存一个本地变量，由ThreadLocal内部是由Thread 内部的ThreadLocalMap来维护。
ThreadLocalMap是当前线程的属性，map的key是当前ThreadLocal对象，value 即为存储的对象。