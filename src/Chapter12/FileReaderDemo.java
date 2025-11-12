package Chapter12;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader Demonstration Program
 * FileReader 演示程序
 */
public class FileReaderDemo {

    public static void main(String[] args) {

        // Using try-with-resources to automatically close the FileReader
        // 使用try-with-resources自动关闭FileReader
        try(FileReader f1 = new FileReader("src/Chapter12/test.txt"))
        // Create a character array buffer of size 50 to store read characters
        // 创建大小为50的字符数组缓冲区来存储读取的字符
        {
            char [] a = new char[15];

        // Read characters from file into the array
        // Returns the number of characters read, or -1 if end of file
        // 从文件中读取字符到数组中
        // 返回读取的字符数，如果到达文件末尾则返回-1
            f1.read(a);

        // Iterate through each character in the array and print it
        // 遍历数组中的每个字符并打印
        for (char c:a){
            System.out.println(c);
        }

    } catch (IOException e) {
        // Handle IOException if file reading fails
        // 处理文件读取时的IOException
        System.out.println("Error while reading file");
    }

}
}