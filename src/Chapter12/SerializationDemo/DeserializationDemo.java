package Chapter12.SerializationDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * DeserializationDemo class demonstrates object deserialization
 * 反序列化演示类，展示对象反序列化过程
 *
 * Deserialization: Reconstructing Java objects from byte stream
 * 反序列化：从字节流重建Java对象
 */
public class DeserializationDemo {
    public static void main(String[] args) {
        try {
            // Create FileInputStream to read from file 创建文件输入流以读取文件
            FileInputStream f1 = new FileInputStream("src/Chapter12/SerializationDemo/output.ser");

            // Create ObjectInputStream for object deserialization 创建对象输入流进行对象反序列化
            ObjectInputStream o1 = new ObjectInputStream(f1);
            // Deserialize and read the User object from file 反序列化并从文件读取用户对象
            // Explicit casting required 需要显式类型转换
            User user1 = (User)o1.readObject();
            // Display user information 显示用户信息
            System.out.println("User object deserialized successfully!");
            System.out.println(user1.getAccount());
            System.out.println(user1.getemail());
            System.out.println(user1.getpassword());

            // Important: Close streams to release resources
            // 重要：关闭流以释放资源
            f1.close();

        } catch (IOException e) {
            // Improved error message 改进的错误信息
            System.out.println("File read error: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());

        }
    }
}
