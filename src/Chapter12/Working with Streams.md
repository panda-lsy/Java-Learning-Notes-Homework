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
