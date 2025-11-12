package Chapter12;

import java.io.*;

/**
 * BufferedOutputStream Demonstration Program
 * BufferedOutputStream 演示程序
 */
public class BufferedOutputStreamDemo {
    /**
     * Main method - program entry point
     * 主方法 - 程序入口点
     */
    public static void main(String[] args) {
        String message = "Welcome to Hainan Normal University";

        // Using try-with-resources to automatically close both FileOutputStream and BufferedOutputStream
        // 使用try-with-resources自动关闭FileOutputStream和BufferedOutputStream
        try (FileOutputStream f1 = new FileOutputStream("src/Chapter12/output1.txt");
             BufferedOutputStream bs = new BufferedOutputStream(f1)) {

            // Convert string to byte array
            // 将字符串转换为字节数组
            byte[] byteArray = message.getBytes();

            // Write bytes to buffered output stream
            // 将字节写入缓冲输出流
            bs.write(byteArray);

            // flush() is called
            System.out.println("Data written and flushed successfully using BufferedOutputStream!");

        } catch (IOException e) {
            System.out.println("Problem Writing to File: " + e.getMessage());
        }

        // Note: The close() method automatically calls flush() before closing the stream.
    }
}