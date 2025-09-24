if 基础
- 语法: 根据布尔表达式真假执行代码块
- 建议总是加花括号，避免悬挂 else 问题
```java
int x = 10;
if (x > 0) {
    System.out.println("positive");
}
```
f
if...else
```java
int x = -3;
if (x >= 0) {
    System.out.println("non-negative");
} else {
    System.out.println("negative");
}
```

嵌套 if
- 适合先做粗筛，再细分；层级多时可考虑提前返回或改用 else if/switch
```java
int score = 86;
if (score >= 60) {
    if (score >= 85) {
        System.out.println("优秀");
    } else {
        System.out.println("及格");
    }
} else {
    System.out.println("不及格");
}
```

else if 链
- 顺序很重要，从最具体到最宽泛
```java
int score = 86;
if (score >= 90) {
    System.out.println("A");
} else if (score >= 80) {
    System.out.println("B");
} else if (score >= 70) {
    System.out.println("C");
} else if (score >= 60) {
    System.out.println("D");
} else {
    System.out.println("F");
}
```

switch 语句（传统）
- 可用于: byte, short, char, int 及其包装类、String、enum（不支持 long、float、double）
- 需要 break，否则会贯穿执行到下一个 case
- default 可选，建议保留处理未知情况
```java
String day = "MON";
switch (day) {
    case "MON":
    case "TUE":
    case "WED":
    case "THU":
    case "FRI":
        System.out.println("工作日");
        break;
    case "SAT":
    case "SUN":
        System.out.println("周末");
        break;
    default:
        System.out.println("非法输入");
}
```

switch 表达式（Java 14+ 推荐）
- 使用 ->，默认不贯穿；可直接产生值；可合并多个标签
- 需要在所有可能分支覆盖或包含 default
```java
int n = 2;
String text = switch (n) {
    case 1, 3, 5 -> "odd";
    case 2, 4, 6 -> "even";
    default      -> "unknown";
};
System.out.println(text);
```
- 复杂逻辑用 yield 返回值
```java
int month = 2, year = 2024;
int days = switch (month) {
    case 1,3,5,7,8,10,12 -> 31;
    case 4,6,9,11 -> 30;
    case 2 -> {
        boolean leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        yield leap ? 29 : 28;
    }
    default -> throw new IllegalArgumentException("非法月份: " + month);
};
```

String 和 enum 的 switch
```java
String cmd = "start";
switch (cmd) {
    case "start" -> System.out.println("启动");
    case "stop"  -> System.out.println("停止");
    default      -> System.out.println("未知命令");
}

enum Level { LOW, MEDIUM, HIGH }
Level level = Level.HIGH;
switch (level) {
    case LOW, MEDIUM -> System.out.println("普通任务");
    case HIGH        -> System.out.println("紧急任务");
}
```

常见注意
- 比较字符串用 equals/equalsIgnoreCase，不用 ==
- switch 传入为 null 的 String/包装类型会抛出 NullPointerException，先判空
- else if 链适合区间判断；离散值映射优先用 switch（表达式更简洁）
- 逻辑复杂时考虑早返回或拆分方法，提升可读性
- 保证 default 覆盖未知输入；switch 表达式中未覆盖将编译报错或需 default

补充：三元运算符（简写 if-else）
```java
int x = -5;
String sign = (x > 0) ? "positive" : (x == 0 ? "zero" : "negative");
```