# Java 概览

Java 是一种面向对象、跨平台、广泛应用的编程语言，核心理念是“一次编写，到处运行”（Write Once, Run Anywhere, WORA）。通过将源代码编译为与平台无关的字节码，并由 JVM（Java Virtual Machine）在不同操作系统上解释或即时编译执行，实现平台无关性。Java 生态庞大，适用于企业级应用、移动（Android）、大数据、云原生、金融交易系统、物联网等领域。

## Java 的特点

1. 跨平台（Platform Independent）源代码经 javac 编译成 .class 字节码，由各平台对应的 JVM 执行
2. 面向对象（OOP）支持封装、继承、多态；强调抽象与模块化，提高可维护性与复用性
3. 内存自动管理（GC）垃圾回收器自动回收不再引用的对象，降低内存泄漏风险
4. 健壮性（Robust）严格的编译期检查 + 运行期异常机制；类型检查严格
5. 安全性（Security）类加载器、字节码校验、沙箱模型（早期 Applet），安全管理器（已逐步淡出）
6. 多线程支持（Multithreading）语言级 Thread + java.util.concurrent（Executor, Future, Lock, Atomic 等）
7. 即时编译与性能优化（JIT + HotSpot）热点代码经 C1/C2 编译，配合逃逸分析、内联、锁消除等优化
8. 丰富标准库与生态 覆盖集合、IO/NIO、网络、反射、并发、加密、序列化、JDBC、JSON/XML 等；生态有 Spring, Maven, Gradle, MyBatis 等
9. 模块化（Java 9+ JPMS）module-info.java 明确依赖与封装边界
10. 新特性迭代快 record、sealed、pattern matching、text block、switch 增强、虚拟线程（Java 21 GA）
11. 开源与社区 OpenJDK 主线，发行版：Oracle JDK, Temurin, Corretto, Zulu 等
12. 云原生友好 GraalVM Native Image、CDS、分层 JAR、启动/内存占用优化

## Java 运行机制概览

源文件(.java) -> 编译器(javac) -> 字节码(.class) -> 类加载器 -> 字节码校验 -> 解释执行/即时编译(JIT) -> OS/硬件
HotSpot 通过 Profiling 识别热点方法，触发分层编译（C1/C2），并做逃逸分析、栈上分配等优化。

## 典型应用领域

- 企业后台（互联网、电商、金融）
- 分布式与微服务（Spring Cloud, Dubbo）
- 大数据与流处理（Hadoop 生态、Flink、Kafka 客户端）
- Android（Kotlin 常用，但 JVM 生态共享）
- 金融高并发撮合、风控
- 中间件（MQ、网关、搜索、RPC 框架）

## 简单示例

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

编译：javac HelloWorld.java
运行：java HelloWorld

## 版本节奏概念

- LTS：8, 11, 17, 21
- 每 6 个月一个特性版本
- 现代生产：17/21 主流，逐步使用虚拟线程、模式匹配

## Java 程序组成

- 类（class）
- 接口（interface）
- 方法（method）
- 字段（field）
- 包（package）
- 模块（module, 9+ 可选）

## 数据类型

Java 基本类型（primitive）共 8 种：byte, short, int, long, float, double, char, boolean
引用类型（reference）包括类、接口、数组、枚举、记录（record）等。

### 整数 (Integer)

| 类型  | 大小 | 范围           | 备注           |
| ----- | ---- | -------------- | -------------- |
| byte  | 8位  | -128 ~ 127     | 2^7            |
| short | 16位 | -32768 ~ 32767 | 2^15           |
| int   | 32位 | -2^31 ~ 2^31-1 | 默认整型       |
| long  | 64位 | -2^63 ~ 2^63-1 | 需 L 或 l 后缀 |

### 浮点 (Floating point)

| 类型   | 大小 | 精度（有效位） | 备注         |
| ------ | ---- | -------------- | ------------ |
| float  | 32位 | ~6–7 位       | 需 F/f 后缀  |
| double | 64位 | ~15–16 位     | 默认浮点类型 |

### 布尔 (Boolean);

只有 true / false

### 字符 (Character)

char 占 16 位，存储 UTF-16 代码单元
例：char c = '中'; char x = '\n'; char u = '\u4F60';

### 变量声明与赋值

```java
int count = 10;      // 声明并初始化
int c = 0b1010;
String name = "Name";
char a = 'a';
long id;             // 声明
id = 123L;           // 赋值

<类型><变量名>=<值>   //声明前
<变量名>=<值>		//声明后
```

不可使用未初始化的局部变量。

## 类型字面量（Literals）

字面量 = 源代码中直接写出的常量值。

1. 整数字面量

   - 十进制：int n = 42;
   - 二进制（0b/0B）：int b = 0b1010;
   - 八进制（0 前缀）：int o = 077;
   - 十六进制（0x/0X）：int h = 0x2A;
   - long 后缀：long big = 9_000_000_000L;
   - 下划线分隔（增强可读性，不能出现在开头/结尾/小数点旁）：int num = 1_000_000;
2. 浮点字面量

   - 普通小数：double d = 3.14;
   - 科学计数法：double e = 6.02e23;
   - float 需后缀：float f = 3.14F;
   - 特殊值：Double.NaN, Double.POSITIVE_INFINITY
3. 布尔字面量

   - true / false
4. 字符字面量（单引号）

   - 普通：'A'
   - 转义：'\n' '\t' '\\' '\'' '\"' '\r' '\b' '\f'
   - Unicode：'\u4E2D'
5. 字符串字面量（双引号）

   - String s = "Hello";
   - 支持转义序列
   - Java 15+ 文本块（Text Block，三个双引号）：
     ```java
     String json = """
         {
           "key": "value"
         }
         """;
     ```
6. null 字面量

   - 表示“无引用”：String ref = null;
7. 类型后缀/前缀汇总

   - long: L
   - float: F
   - 二进制: 0b / 0B
   - 十六进制: 0x / 0X
   - 八进制: 0 前缀（不推荐混淆）

## 定义一个类

类可以包含方法、变量、对象、内部类

```java
class ClassName {
    // 成员变量（字段）
    // 方法

    public static void main(String[] args) {
    //主函数声明
    }
}
```

命名规则：

- 首字母大写的驼峰（PascalCase）
- 不能与关键字重复
- 只能使用字母、数字、下划线、$（不建议频繁使用 _ 和 $）
- 不含空格

### 关键字

具有特殊语义的保留字（如 class, if, else, for, while, return, static, public, void 等），全部小写。不能作为标识符。

### 定义方法

一组旨在执行特定任务的语句，提供封装，对于引用数据成员和访问是不可少的

由方法声明和方法体组成

```java
修饰符 返回值类型 方法名(参数类型 参数名){
    ...
    方法体
    ...
    return 返回值;
}
```

#### 命名规则

- 方法名称应为动词-名词对
- 第一个字母应为小写
- 除第一个单词，每个开头字母应该大写（驼峰命名法）

#### 调用方法

```java
方法名 (参数列表);
```

### 内部类

### 创建类成员

通过 `new` 进行对象实例化

```java
student s1 = new student();
s1.age = 30;
student s2 = new student();
s2.age = 35;
```

## 访问修饰符

访问修饰符用于控制类、方法和变量的访问范围。

### `public`

公共访问修饰符，表示类、方法或变量可以被任何其他类访问。

```java
public class MyClass {
public int myVar;
public void myMethod() {
// 方法体
}
}
```

### `private`

私有访问修饰符，表示类、方法或变量只能在所属类内部访问。

### `protected`

受保护的访问修饰符，表示类、方法或变量可以在同一包内的类和所有子类中访问。

### `default`

如果没有指定任何访问修饰符，则默认为包级别访问修饰符，表示类、方法或变量只能在同一包内访问。

### `final`

当设置此关键字，数据成员的定义或值无法再修改。

声明为 final 的类不能用于继承目的，方法不能被重写。

### `static`

只要任意一个实例化对象修改变量的值，其他实例化对象都会访问到修改后的值

### `abstract`

抽象类不能直接实例化。用于给其他类型继承。

### `native`

`native` 只能与方法一起制定

### `synchronized`

仅用于方法，控制在多线程编程环境中的访问

### `transient`

值每次访问都会更新

### `volatile`

### `strictfp` JDK 17-

## 包

包是一个类的集合，提供用于组织彼此相关类的空间，确保同名无关类之间不会冲突。

```java
package <package_name>;
```

## 命名 Java 文件

- 若含有 public 类，文件名必须与该类同名
- 一个文件可包含多个非 public 类
- 建议一类一文件，提升可读性
