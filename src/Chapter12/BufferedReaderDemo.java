package chapter12;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader Demonstration Program
 * BufferedReader 演示程序
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {

        // Using try-with-resources to automatically close both FileReader
        and BufferedReader
        // 使用try-with-resources自动关闭FileReader和BufferedReader

        // Read line by line until end of file (returns null)
        // 逐行读取直到文件末尾（返回null）

        // Print each line
        // 打印每一行

    }

} catch (IOException e) {
        // Handle IOException if file reading fails
        // 处理文件读取时的IOException
        System.out.println("Error while reading file: " +
                           e.getMessage());
        }
        }
        }