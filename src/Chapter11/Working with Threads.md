# 在 Java 中使用线程

## 线程概述

线程是程序执行的最小单位，Java 中的线程通常映射为操作系统线程。多线程能并发执行任务、提高资源利用率，但也带来同步、竞态条件和可见性问题。

## 创建线程（常用方式）

- 继承 Thread：

```java
class MyThread extends Thread {
    public void run() { /* 任务 */ }
}
new MyThread().start();
```

- 实现 Runnable（推荐）：

```java
Runnable r = () -> { /* 任务 */ };
new Thread(r).start();
```

- Callable + Future（可返回结果并抛出异常）：

```java
Callable<Integer> c = () -> 42;
Future<Integer> f = Executors.newSingleThreadExecutor().submit(c);
```

## 线程池（推荐生产环境使用）

- 使用 ExecutorService 管理线程：

```java
ExecutorService pool = Executors.newFixedThreadPool(4);
pool.submit(() -> { /* 任务 */ });
pool.shutdown();
```

- 使用合适大小的线程池、避免无限队列和不关闭池。

## 主要方法

### start()

使线程进入可运行状态

### run()

定义线程的任务

### sleep()

单位为毫秒，让线程进入等待状态

### join()

让其他线程等待 `join`线程完成

### isAlive()

检查线程是否还在运行

### getName()/setName()

设置线程名字

### getPriority()/setPriority()

设置/获取线程优先级

## 同步与可见性

- synchronized：保证互斥和内存可见性（方法或代码块）。
- volatile：保证可见性，适用于单个变量的状态标记，不保证复合操作原子性。
- 原子类（AtomicInteger 等）和显式锁（ReentrantLock）用于更复杂的并发控制。

## 等待与通知

- 使用 Object.wait()/notify()/notifyAll() 或 Condition（与 Lock 搭配）。
- 始终在循环中检查条件：while (!condition) wait();

## 线程生命周期与状态

常见状态：NEW、RUNNABLE、BLOCKED、WAITING、TIMED_WAITING、TERMINATED。了解这些状态有助于调试死锁和性能问题。

## 常见问题与建议

- 避免共享可变状态，优先使用不可变对象或线程局部数据（ThreadLocal）。
- 使用高级并发工具（Executors、ForkJoinPool、并发集合）代替手写线程管理。
- 小心死锁、竞态和活锁；使用代码审查与并发测试。
- 不要使用 Thread.stop()/suspend()/resume()（已废弃且不安全）。

简短示例（Executor + Callable）：

```java
ExecutorService es = Executors.newFixedThreadPool(2);
Future<String> f = es.submit(() -> "result");
System.out.println(f.get());
es.shutdown();
```
