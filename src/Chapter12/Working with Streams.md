# 使用流

## 输入流线程

### FileInputStream Class

用于以原始字节读取文件；从任何文件类型读取数据，将字节从0-255之间的数字返回：可以得到文件的确切二进制数据。

```java
FileInputStream fin = new FileInputStream("data.txt");

File file = new File("data.txt"); 
FileInputStream fin2 = new FileInputStream(file);

FileDescriptor fd = new FileDescriptor(); 
FileInputStream fin3 = new FileInputStream(fd);
```

#### 主要方法

##### Read() 读取一个字节

```java
int byteData = fis.read(); 
```

##### FileDescriptor getFD() 获取文件描述符

这个方法返回正在读取文件的文件描述符。

```java
FileDescriptor fdObj = fin.getFD();
```

### BufferedInputStream Class

BufferedInputStream 是一个包装器，为其他输入流添加缓冲功能。它以块的形式读取数据，而不是一次一个字节。这使得读取速度更快、更高效。

#### 构造函数

##### BufferedInputStream(InputStream in)

创建具有默认缓冲区大小的缓冲流。

```java
FileInputStream fis = new FileInputStream("file.txt"); 
BufferedInputStream bis = new BufferedInputStream(fis);
```

##### BufferedInputStream(InputStream in, int size)

创建具有自定义缓冲区大小的缓冲流。

```java
FileInputStream fis = new FileInputStream("file.txt"); 
BufferedInputStream bis = new BufferedInputStream(fis, 8192); // 8KB buffer 
```

#### 主要方法

##### read() 读取一个字节

##### read(byte[] b) 读取到字节数组

```java
byte[] buffer = new byte[10]; 
int bytesRead = bis.read(buffer);
```

##### read(byte[] b, int off, int len) 读取部分

```java
byte[] a = new byte[10]; 
int bytesRead = bis.read(buffer, 2, 5); // Read into position 2, max 5 bytes 
```

##### skip(long n) 跳过字节

```java
long skipped = bis.skip(5); // Skip 5 bytes
```

##### available() 检查可用字节

```java
int available = bis.available(); 
System.out.println(available + " bytes available in buffer");
```

##### mark(int readlimit) 标记位置

```java
bis.mark(1000); // Remember current position, allow 1000 bytes before reset
```

##### reset() 返回到标记

```java
bis.reset(); // Go back to marked position
```

##### markSupported() 检查标记支持

```java
if (bis.markSupported()) { 
	System.out.println("Mark/reset is supported!"); 
} else { 
	System.out.println("Mark/reset NOT supported"); 
}
```

##### close() 关闭流

```java
bis.close(); // Always close when done!
```

#### 读取字节 & 字符

##### 通过字节读取

计算机看到的是数字，不是字母；每个字符 = 一个字节

例子：

| H  | e   | l   | l   | o   |
| -- | --- | --- | --- | --- |
| 72 | 101 | 108 | 108 | 111 |

##### 通过字符读取

计算机将字节转换为可读文本，使用编码规则

### FileReader

专门读取文本文件，直接读取字符

#### 构造方法

```java
//使用文件名
FileReader reader = new FileReader("myfile.txt");
//使用文件对象
File file = new File("myfile.txt"); 
FileReader reader = new FileReader(file);
//使用文件描述符
FileDescriptor fd = someInputStream.getFD(); 
FileReader reader = new FileReader(fd); 
```

#### 内置函数

##### read() 读取一个字符

```java
FileReader reader = new FileReader("story.txt"); 
int character; 
while ((character = reader.read()) != -1) { 
System.out.print((char) character); 
} 
reader.close(); 
```

### BufferedReader

一次性读取大量文本以提高读取速度，一次读取整行

#### 工作原理

##### 无 BufferReader

Program → FileReader → Disk → 1 char → Program → Disk → 1 char → ...

每个字符读取都直接到磁盘；一次性读取一个字符

##### 使用 BufferReader

Program → Buffer (8192 chars) → FileReader → Disk (big reads)

文本在缓冲区聚集，从内存提供字符；一次性读取8192字符

#### 构造方法

```java
//使用其他Reader
FileReader fileReader = new FileReader("myfile.txt"); 
BufferedReader reader = new BufferedReader(fileReader); 
//自定义缓冲区大小
FileReader fileReader = new FileReader("myfile.txt"); 
BufferedReader reader = new BufferedReader(fileReader, 16384); // 16KB buffer
```

简短方式

```java
BufferedReader reader = new BufferedReader(new FileReader("myfile.txt"));
```

#### 内置函数

##### readLine() 读取一行

```java
String line = reader.readLine(); 
// Returns null when end of file 
// 文件结束时返回 null 
```

可视化预览

```
Buffer: [H][e][l][l][o][\n][W][o][r][l][d][\n][E][O][F] 
↑ 
Position 
String line1 = reader.readLine();  // "Hello" 
Buffer: [H][e][l][l][o][\n][W][o][r][l][d][\n][E][O][F] 
↑ 
Position (after \n) 
String line2 = reader.readLine();  // "World" 
Buffer: [H][e][l][l][o][\n][W][o][r][l][d][\n][E][O][F] 
↑ 
Position 
String line3 = reader.readLine();  // null (EOF) 
```

##### read() 读取一个字符

```java
int charData = reader.read(); 
// Returns -1 when end of file 
// 文件结束时返回 -1
```

可视化预览

```
Buffer: [H][e][l][l][o][ ][W][o][r][l][d] 
↑ 
Position 
int data = reader.read();  // data = 72 ('H') 
Buffer: [H][e][l][l][o][ ][W][o][r][l][d] 
↑ 
Position 
data = reader.read();      // data = 101 ('e')
```

##### read(char[] cbuf)读取到字符数组

```java
char[] buffer = new char[100]; 
int charsRead = reader.read(buffer);
```

可视化预览

```java
Buffer: [H][e][l][l][o][ ][W][o][r][l][d][!] 
↑ 
Position 
char[] array = new char[5]; 
int count = reader.read(array); 
Result: 
array = [H][e][l][l][o] 
count = 5
```

##### read(char[] cbuf, int off, int len) 读取部分

```java
char[] buffer = new char[10]; 
int charsRead = reader.read(buffer, 2, 5); // Read into position 2, max 5 chars
```

可视化预览

```
buffer: [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ] 
Index:   0  1  2  3  4  5  6  7  8  9 
Buffer: [H][e][l][l][o] 
reader.read(buffer, 2, 5); 
Result: 
buffer: [ ][ ][H][e][l][l][o][ ][ ][ ] 
0  1  2  3  4  5  6  7  8  9
```

##### skip(long n) 跳过字符

```java
long skipped = reader.skip(10); // Skip 10 characters
```

可视化预览

```
Buffer: [H][e][l][l][o][ ][W][o][r][l][d][!] 
↑ 
Position 
reader.skip(5); 
Buffer: [H][e][l][l][o][ ][W][o][r][l][d][!] 
↑ 
Position (skipped 5 chars)
```

##### ready() 检查是否准备好读取

```java
if (reader.ready()) { 
String line = reader.readLine();} 
```

可视化预览

```
Buffer has data: [H][e][l][l][o]... 
↑ 
Position 
reader.ready() → true  
Buffer empty: [ ][ ][ ][ ][ ]... (waiting for refill) 
↑ 
Position   
reader.ready() → false   
End of file: [ ][ ][ ][ ][ ]... (no more data) 
↑ 
Position 
reader.ready() → false   
```

##### mark(int readAheadLimit) 标记位置

```java
reader.mark(1000); // Remember position, allow 1000 chars before reset
```

可视化预览

```
Buffer: [L][i][n][e][1][\n][L][i][n][e][2][\n][L][i][n][e][3] 
Mark position 
// Read some lines... 
String line1 = reader.readLine(); // "Line1" 
String line2 = reader.readLine(); // "Line2" 
Buffer: [L][i][n][e][1][\n][L][i][n][e][2][\n][L][i][n][e][3] 
↑ 
Current position
```

##### reset() 返回到标记

```java
reader.reset(); // Go back to marked position
```

可视化预览

```
Buffer: [L][i][n][e][1][\n][L][i][n][e][2][\n][L][i][n][e][3] 
↑ 
Current position 
reader.reset(); 
Buffer: [L][i][n][e][1][\n][L][i][n][e][2][\n][L][i][n][e][3] 
Back to mark position
```

## 输出流线程

将数据作为0-255的原始字节写入文件

### 创建方法

使用文件名

```java
FileOutputStream fos = new FileOutputStream("data.txt");
```

使用文件名追加模式

```java
// true = append to the end of existing file 
// true = 追加到现有文件 
FileOutputStream fos = new FileOutputStream("data.txt", true); 
```

使用文件对象

```java
File file = new File("data.txt"); 
FileOutputStream fos = new FileOutputStream(file); 
```

使用文件描述符

```java
FileDescriptor fd = someStream.getFD(); 
FileOutputStream fos = new FileOutputStream(fd); 
```

### 所有方法

#### write() 写入一个字节

```java
fos.write(65); // Writes 'A' (ASCII 65)
```

可视化预览

```
File: [ Empty ] 
fos.write(72);  // 'H' 
fos.write(101); // 'e' 
fos.write(108); // 'l' 
fos.write(108); // 'l' 
fos.write(111); // 'o' 
File: [H][e][l][l][o]
```

#### write(byte[] b) 写入字节数组

```java
byte[] data = {72, 101, 108, 108, 111}; // "Hello" 
fos.write(data);
```

可视化预览

```
File: [ Empty ] 
byte[] data = [72][101][108][108][111]  // "Hello" 
↓    ↓   
fos.write(data); 
File: [H][e][l][l][o] 
↓   
```

#### write(byte[] b, int off, int len) 写入部分

```java
byte[] data = {65, 66, 67, 68, 69, 70}; // "ABCDEF" 
fos.write(data, 2, 3); // Write from position 2, length 3
```

可视化预览

```text
data array: [A][B][C][D][E][F] 
Index:  
0   1   2   3   4   5 
fos.write(data, 2, 3); 
Writes: [C][D][E] to file 
File: [C][D][E]
```

#### flush() 强制写入磁盘

```java
fos.flush(); // Immediately write buffered data to disk
```

可视化预览

```
Memory Buffer: [H][e][l][l][o] (waiting to be written) 
↓ 
fos.flush() → Forces immediate write 
↓ 
Disk File: [H][e][l][l][o] (now safely on disk)
```

#### close() 关闭流

```java
fos.close(); // Always close when done!
```

# 序列化与反序列化

## 序列化/反序列化

将 Java 对象作为字节保存至文件/从文件加载 Java 字节

## 准备工作

在类中添加 implements Serializable

```java
public class Student implements Serializable { 
private String name; 
private int age; 
// You can have any constructors 
// 你可以有任意构造函数 
public Student() {} 
public Student(String name, int age) { 
this.name = name; 
this.age = age; 
} 
// You can have any methods 
// 你可以有任意方法 
public String getName() { return name; } 
public void setName(String name) { this.name = name; } 
}
```

储存对象至文件

- 创建文件 (FileOutputStream)
- 创建对象写入器 (ObjectOutputStream)
- 写入对象 (writeObject(yourObject))
- 关闭 (try-with-resources)

从文件加载对象
