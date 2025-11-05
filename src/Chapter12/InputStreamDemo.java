package Chapter12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Import packages to read file and handle exceptions / 导入读取文件和异常处理的包
// FileInputStream - for reading bytes from files / 用于从文件读取字节
// FileNotFoundException - when file doesn't exist / 当文件不存在时
// IOException - for general input/output errors / 用于一般输入/输出错误

public class InputStreamDemo {
    static void main() {

        // Stores byte value (0-255) returned by read() method
        // 存储read()方法返回的字节值(0-255)

        int i;
        char c;

        // Used to convert byte to character for display / 用于将字节转换为字符进行显示

       File file=new File("src/Chapter12/test.txt");

        // Try-with-resources: Automatically closes FileInputStream / 自动关闭FileInputStream
        // This is better than manual closing in finally block / 这比在finally块中手动关闭更好

        try (FileInputStream f1 = new FileInputStream(file))
        {

            // Read bytes until End Of File (EOF) indicated by -1 / 读取字节直到文件末尾(返回-1)
            // f.read() reads single byte and returns as int / f.read()读取单个字节并以int形式返回
            // Returns -1 when no more bytes to read / 当没有更多字节可读时返回-1

            while((i=f1.read())!=-1){

                // Convert the byte (0-255) to character / 将字节(0-255)转换为字符
                // WARNING: This works only for ASCII characters / 警告：这仅适用于ASCII字符

                c=(char)i;

                // Print character without newline / 打印字符（不换行）

                System.out.print(c);
            }

            // FileInputStream 'f' automatically closed here due to try-with-resources
            // 由于try-with-resources，FileInputStream 'f' 在这里自动关闭
        } catch (FileNotFoundException e) {

            // Exception when file path is wrong or file doesn't exist / 当文件路径错误或文件不存在时的异常

            System.out.println("File not found");

            // Consider printing the actual file path for debugging / 考虑打印实际文件路径用于调试

        }catch (IOException e){
            // Exception for read errors, disk problems, etc. / 读取错误、磁盘问题等的异常

            throw new RuntimeException(e);

            // I/O error during reading operation / 读取操作期间的I/O错误
        }

        // Program continues here after try-catch block / 程序在try-catch块后继续执行

    }
}
