# 循环

## 使用循环
- 初始化语句只在循环开始前执行一次，更新语句在每次迭代末尾执行
- 条件表达式在 for/while 中先判断，在 do-while 中后判断
- 已知迭代次数通常用 for；未知次数（取决于运行时条件）用 while；至少执行一次用 do-while
- 循环变量的作用域通常仅限于循环内部，避免名称冲突
- 谨慎处理可能导致死循环的条件

### for 循环
```java
for (初始化; 条件; 更新) {
    // 循环体
}
```
- 示例：求 1..10 的和
```java
int sum = 0;
for (int i = 1; i <= 10; i++) {
    sum += i;
}
System.out.println(sum);
```
- 倒序与多重初始化/更新
```java
for (int i = 10; i >= 1; i--) { /* ... */ }

for (int i = 0, j = 10; i < j; i++, j--) { /* ... */ }
```
- 省略项与无限循环
```java
for (;;) { /* 无限循环，务必在内部 break */ }
```
- 嵌套循环（99 乘法表）
```java
for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print(j + "*" + i + "=" + (i*j) + "\t");
    }
    System.out.println();
}
```

## while 循环
- 适合次数不确定、以条件驱动
```java
int count = 0;
int n = getNext(); // 自定义获取方法
while (n != 0) {
    count++;
    n = getNext();
}
```

## do-while 循环
- 至少执行一次，再判断条件
```java
int option;
do {
    option = readOption(); // 自定义读取方法
    handle(option);        // 自定义处理方法
} while (option != 0);
```

## break
- 立即结束最近一层循环剩余迭代
```java
for (int n : new int[]{1, 3, 5, 7}) {
    if (n == 5) break;
    System.out.println(n); // 输出 1、3
}
```

## continue
- 跳过本次循环剩余语句，直接进入下一次迭代
```java
for (int i = 1; i <= 5; i++) {
    if (i % 2 == 0) continue;
    System.out.print(i + " "); // 1 3 5
}
```

## 增强 for（for-each）
- 用于数组、实现 Iterable 的集合，简洁安全；无法直接获取索引，也不适合在遍历中修改集合结构
```java
int[] arr = {1, 2, 3};
for (int v : arr) {
    System.out.println(v);
}

// 遍历并删除请用迭代器
List<Integer> list = new ArrayList<>(List.of(1,2,3,4));
for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
    if (it.next() % 2 == 0) it.remove();
}
```

## 标签语句（labeled break/continue）
- 结束或跳过外层循环，提升可读性但需谨慎使用
```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) break outer; // 直接跳出 outer
    }
}

rowLoop:
for (int[] row : matrix) {
    for (int v : row) {
        if (v < 0) continue rowLoop; // 跳过含负数的整行
    }
    process(row);
}
```

## 常见注意事项
- 避免死循环：确保循环变量/状态会朝终止条件推进
- 浮点误差：不要用浮点数作为精确的循环计数器，改用整数或 BigDecimal
- 性能：避免在循环中反复创建不必要对象；字符串拼接用 StringBuilder
- 作用域：for(int i=...){...} 外部不可访问 i；需要外部访问请在循环外声明
- 可读性优先：能用 for-each 就不用下标；需要索引或原地修改时用普通 for
