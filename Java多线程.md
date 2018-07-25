#### Java 5前时代



### *  并发实现

 -Java Green Thread

-Java Native Thread



### * 编程模型

-Thread

-Runnable





* 实现局限性

   缺少线程管理的原生支持

  缺少索的API

  缺少执行完成的原生支持

  执行结果获取困难

  Double check locking  不确定性

crtl + o 搜索方法的快捷键



###  

## java 5 时代

* ### 并发框架

  - #### J.U.C = java.util.concurrent



* ######编程模型

* ######Executor 

* runnable、 callble

* Future





​       JUC 凡是抛出  `InterruptedException`  都是阻塞



## java 7 时代



### 并行框架

   ####     - Fork/join

### 编程模型

  #### ForkJoinPool

#### ForkJoinTask

#### RecursiveAction



#### Future 的限制

 ##### - 无法手动完成

##### -阻塞式返回结果

###### - 无法链式多个Future

##### - 无法合并多个Future 结果

##### - 缺少异常处理



### java 8时代

* #### 异步并行框架

   #### - Fork/Join

* #### 编程模型

  #### - CompletionStage

  #### - CompletableFuture

  ​     异步操作不强求立马返回

  现在qps 是100，异步操作qps 10000

  ```ListenableFutureCallback 
  ListenableFutureCallback
  ```

  作为监听器或者订阅者

* StampedLock 邮票锁

* ConcurrentHashMap









