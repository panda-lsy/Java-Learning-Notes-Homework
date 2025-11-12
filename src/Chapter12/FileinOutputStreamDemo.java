package Chapter12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream Demonstration Program
 * FileOutputStream 演示程序
 */
public class FileinOutputStreamDemo {

    public static void main(String[] args)
    {
        // Define the string to be written to file
        // 定义要写入文件的字符串
        String message = "Welcome to Hainan Normal university";

        // Convert the string to byte array using platform's default charset
        // 使用平台默认字符集将字符串转换为字节数组
        byte[] messageBytes = message.getBytes();

        // Using try-with-resources to automatically close FileOutputStream
        // 使用try-with-resources自动关闭FileOutputStream
        //if it is true file will be written to end of the file.
        try(FileOutputStream fo = new FileOutputStream("src/Chapter12/out.txt")){

        // Write each byte individually to the file
        // 将每个字节单独写入文件
            fo.write(messageBytes);

        // Note: The file will be created if it doesn't exist, or overwritten if it exists
        // 注意：如果文件不存在将会创建，如果存在将会被覆盖
            FileInputStream f2 = new FileInputStream("src/Chapter12/input.png");
            FileOutputStream f3 = new FileOutputStream("src/Chapter12/output.png");
            int i;
            while((i=f2.read())!=-1)
            {
                f3.write(i);
            }

    }
        catch(IOException e)
    {
        // Handle IOException if file writing fails
        // 处理文件写入时的IOException
        System.out.println("Problem Writing to File");
    }
}
}