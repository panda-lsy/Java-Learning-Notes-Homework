# 数组

数组是存储在相邻内存位置的单一数据类型元素集合，可通过指定数组的名称&下标访问

指定数组中元素的位置，成为元素的索引

| 内存地址 | 25001 | 25002 |
| -------- | ----- | ----- |

## 分类

### 一维数组

- 声明一个数组
- 为数组赋值

```java
arraytype arrayname[] = new arraytype[size]
int [] a = new int[3];
String [] jumbledWords = new String[3];
```

| a[0] | a[1] | a[2] |
| ---- | ---- | ---- |
| 101  | 102  | 103  |

### 二维数组

```java
int a[][] = new int[2][2];
int a[][] = {{1,2},{3,4}}
```

# 枚举

```java
enum enum-name{constant1,constant2,....};
enum Mango{Carrie, Fairchild, Haden};
```

# 字符串

- 特点：String 是不可变对象（任何修改都会产生新对象）；字面量会进入字符串常量池；频繁拼接请用 StringBuilder。
- 创建：

```java
String s1 = "hello";              // 字面量
String s2 = new String("hello");  // 显式创建（不走常量池）
```

常见方法

- 长度与判空
  - length()：长度
  - isEmpty()：是否长度为 0
  - isBlank()：是否全为空白（JDK 11+）
- 访问与截取
  - charAt(i)：按索引取字符
  - substring(begin) / substring(begin, end)：子串
- 查找与判断
  - indexOf(x) / lastIndexOf(x)：查找位置
  - contains(seq)：是否包含
  - startsWith(prefix[, offset]) / endsWith(suffix)
- 比较
  - equals(obj) / equalsIgnoreCase(s)
  - compareTo(s) / compareToIgnoreCase(s)
- 大小写与空白
  - toUpperCase() / toLowerCase()
  - trim()：去除前后空白（不含全部 Unicode 空白）
  - strip() / stripLeading() / stripTrailing()（JDK 11+，支持 Unicode 空白）
- 替换与正则
  - replace(old, new)：按字面替换
  - replaceFirst(regex, repl) / replaceAll(regex, repl)：按正则
  - matches(regex)：整体匹配
- 分割与拼接
  - split(regex[, limit])：分割
  - String.join(delimiter, elems...)：拼接
  - String.format(fmt, args...)：格式化
- 其他
  - repeat(n)（JDK 11+）：重复
  - toCharArray() / getBytes([charset])
  - String.valueOf(x)：任意类型转字符串
  - intern()：放入/返回常量池引用

示例

```java
String s = "  Java,Python,Go  ";
String t = s.strip();                  // "Java,Python,Go"
String[] arr = t.split(",");           // ["Java","Python","Go"]
boolean ok = t.startsWith("Java");     // true
String u = t.replace("Python", "Kotlin"); // "Java,Kotlin,Go"
String v = String.join(" | ", arr).toUpperCase(); // "JAVA | PYTHON | GO"
```

可变字符串（高效拼接）

- StringBuilder（非线程安全，快）/ StringBuffer（线程安全，慢）
- 常用方法：append(x), insert(i,x), delete(i,j), deleteCharAt(i), replace(i,j,s), reverse(), toString()

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 3; i++) sb.append("A").append(i).append(' ');
String out = sb.toString(); // "A0 A1 A2 "
```

# 日期和时间

检索当前日期和时间

```java
// 常用类型在 java.time 包
import java.time.*;

LocalDateTime currentDateTime = LocalDateTime.now();
LocalDate currentDate = LocalDate.now();
LocalTime currentTime = LocalTime.now();
Instant nowInstant = Instant.now(); // UTC 瞬时时间
ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
```

核心类型

- LocalDate / LocalTime / LocalDateTime：不含时区
- Instant：从 1970-01-01T00:00:00Z 起的瞬时点（UTC）
- ZoneId / ZonedDateTime / OffsetDateTime：带时区或偏移
- Period（日期量，如年/月/日）/ Duration（时间量，如小时/秒）
- ChronoUnit：通用时间单位

创建指定日期时间

```java
LocalDate d = LocalDate.of(2025, 9, 1);
LocalTime t = LocalTime.of(14, 30, 0);
LocalDateTime dt = LocalDateTime.of(d, t);
ZonedDateTime beijing = ZonedDateTime.of(dt, ZoneId.of("Asia/Shanghai"));
```

加减与调整

```java
LocalDate nextWeek = d.plusWeeks(1);
LocalDate firstDay = d.withDayOfMonth(1);
LocalDate nextMon = d.with(java.time.temporal.TemporalAdjusters.next(DayOfWeek.MONDAY));
```

差值计算

```java
long days = java.time.temporal.ChronoUnit.DAYS.between(d, d.plusMonths(1));
Period p = Period.between(LocalDate.of(2024,1,1), LocalDate.of(2025,3,5)); // Y-M-D
Duration du = Duration.between(LocalTime.NOON, LocalTime.MIDNIGHT);         // 时分秒
```

格式化与解析

```java
import java.time.format.DateTimeFormatter;

DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String s = dt.format(fmt);                          // 格式化
LocalDateTime parsed = LocalDateTime.parse("2025-09-01 14:30:00", fmt); // 解析
```

时区与 Instant/纪元毫秒

```java
Instant i = Instant.now();
long ms = i.toEpochMilli();                         // 转毫秒
Instant i2 = Instant.ofEpochMilli(ms);
ZonedDateTime utc = i2.atZone(ZoneId.of("UTC"));
ZonedDateTime sh = utc.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
```

旧 API 互转

```java
// Date <-> Instant
java.util.Date date = java.util.Date.from(Instant.now());
Instant i3 = date.toInstant();

// Calendar -> Instant
Instant i4 = java.util.Calendar.getInstance().toInstant();
```

实用提示

- 所有 java.time 类型均不可变、线程安全
- 与外部系统交互/存储建议使用 UTC 的 Instant 或 ISO-8601 字符串
- 涉及时区/夏令时的绝对时刻请使用 Instant 或 ZonedDateTime，避免仅用 LocalDateTime
- 默认使用系统时区，可通过 ZoneId 明确指定
