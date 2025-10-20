# 异常处理

## 常见异常

- 分类
  - 受检异常 Checked: IOException, SQLException 等，必须捕获或声明 throws
  - 非受检异常 RuntimeException: NullPointerException, IndexOutOfBoundsException, NumberFormatException, IllegalArgumentException 等
- 原则
  - 能预防就预防；必要时捕获并记录；避免空 catch；向上抛出要加语义

### 空指针 NullPointerException

- 原因: 尝试使用不存在的东西
- 预防: 参数校验、Objects.requireNonNull、Optional

```java
String name = null;
// name.length(); // NPE
int len = (name != null) ? name.length() : 0;

void setUser(String id) {
        this.id = java.util.Objects.requireNonNull(id, "id 不能为空");
}
```

### 数组越界 ArrayIndexOutOfBoundsException

- 原因: 索引 < 0 或 >= length（访问不存在的数组位置）
- 预防: 使用 length 做边界检查，或使用 for-each

```java
int[] a = {1, 2, 3};
// int v = a[3]; // 越界
for (int i = 0; i < a.length; i++) { /* ... */ }
for (int v : a) { /* 更安全 */ }
```

### 字符串越界 StringIndexOutOfBoundsException

- 原因: charAt/substring 的 index/start/end 不合法（访问不存在的字符串位置）

```java
String s = "abc";
// s.charAt(3); // 越界
int i = 2;
if (i >= 0 && i < s.length()) {
        char c = s.charAt(i);
}

int start = 0, end = 2;
if (0 <= start && start <= end && end <= s.length()) {
        String t = s.substring(start, end);
}
```

### 字符串转换

- 数字解析 NumberFormatException

```java
try {
        int n = Integer.parseInt("12a"); // 抛 NumberFormatException
} catch (NumberFormatException e) {
        // 记录并给出友好提示
}
```

- 安全解析

```java
java.util.Optional<Integer> safeParseInt(String s) {
        try { return java.util.Optional.of(Integer.parseInt(s.trim())); }
        catch (NumberFormatException e) { return java.util.Optional.empty(); }
}
```

- 日期解析 DateTimeParseException

```java
java.time.format.DateTimeFormatter f =
        java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
try {
        java.time.LocalDate d = java.time.LocalDate.parse("2025-10-15", f);
} catch (java.time.format.DateTimeParseException e) {
        // 处理
}
```

### 抛出异常

- throw: 主动抛异常；throws: 方法声明可能抛出
- 参数/状态校验常用 IllegalArgumentException/IllegalStateException

```java
void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("age 必须 >= 0");
}

String read(java.nio.file.Path p) throws java.io.IOException {
        return java.nio.file.Files.readString(p); // 受检异常需声明或捕获
}
```

### 资源释放与 try-with-resources

- 优先使用 try-with-resources 自动关闭 AutoCloseable 资源

```java
try (java.io.BufferedReader br =
                 java.nio.file.Files.newBufferedReader(path, java.nio.charset.StandardCharsets.UTF_8)) {
        String line = br.readLine();
} catch (java.io.IOException e) {
        // 记录并处理
}
```

- finally 示例

```java
java.io.InputStream in = null;
try {
        in = java.nio.file.Files.newInputStream(path);
        // ...
} catch (java.io.IOException e) {
        // ...
} finally {
        if (in != null) try { in.close(); } catch (java.io.IOException ignored) {}
}
```

当发生运行时错误时，JVM会抛出异常

## 处理异常

- 优先捕获具体异常，其次再捕获更通用的异常；不要直接捕获 Exception/Throwable（除非作为最后兜底）
- 在 catch 中只做“能做的事”：补偿、降级、提示、记录日志；无法处理就向上抛出
- 记录日志避免重复；不要同时在多层连续记录同一异常
- 尽量在抛出时补充上下文信息，并保留原始 cause
- 使用多重 catch 或 multi-catch（|）；有顺序要求：子类在前，父类在后
- 不要吞异常；不要在 finally 中 return/throw，避免覆盖原始异常
- 能用 try-with-resources 优先用它（资源关闭已在前文）

示例：按异常类型分别处理
```java
try {
        String text = java.nio.file.Files.readString(path);
        int n = Integer.parseInt(text.trim());
        // ...
} catch (java.nio.file.NoSuchFileException e) {
        // 文件不存在：给出明确提示或创建默认文件
} catch (NumberFormatException e) {
        // 输入格式错误：提示用户修正
} catch (java.io.IOException e) {
        // 其他 I/O 问题：记录并根据场景恢复或上抛
}
```

示例：multi-catch 与顺序
```java
try {
        service.process(cmd);
} catch (IllegalArgumentException | IllegalStateException e) {
        // 参数/状态问题：一般属于可预期的客户端错误
} catch (RuntimeException e) {
        // 其他运行时错误：统一兜底
}
```

示例：异常转换（添加上下文并保留 cause）
```java
try {
        repo.save(user);
} catch (java.sql.SQLException e) {
        throw new RuntimeException("保存用户失败: id=" + user.getId(), e);
}
```

示例：部分处理后再上抛（仅当需要补充日志/清理）
```java
String read(java.nio.file.Path p) throws java.io.IOException {
        try {
                return java.nio.file.Files.readString(p);
        } catch (java.io.IOException e) {
                // 添加上下文或打点
                System.err.println("读文件失败: " + p);
                throw e; // 保持异常类型不变
        }
}
```

反例：吞异常
```java
try {
        doWork();
} catch (Exception e) {
        // 忽略 // 坏：异常被静默，难以排查
}
```

## 断言

- 用于校验“永远应为真”的内部不变式与不可达分支；只在启用时生效
- 启用：java -ea 或 -enableassertions；禁用：-da；可按包/类粒度开启
- 不用于对外部输入的参数校验（对外接口用异常），不依赖断言执行业务逻辑

语法与示例
```java
assert x >= 0 : "x 必须非负: x=" + x;

void setRange(int start, int end) {
        assert start <= end : "start > end: " + start + "," + end;
        // ...
}

switch (kind) {
        case A: /* ... */ break;
        case B: /* ... */ break;
        default: assert false : "未知 kind=" + kind;
}
```

注意事项
- 断言表达式勿产生副作用（断言关闭后将不执行）
```java
// 坏例：关闭断言时行为改变
assert list.remove(0);
```
- 仅在开发/测试中辅助定位问题，生产问题处理依赖异常与监控
