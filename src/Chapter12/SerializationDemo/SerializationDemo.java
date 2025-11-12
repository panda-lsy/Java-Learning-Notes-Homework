package Chapter12.SerializationDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SerializationDemo class demonstrates object serialization
 * 序列化演示类，展示对象序列化过程
 *
 * Serialization: Converting Java objects to byte stream for storage/transmission
 * 序列化：将Java对象转换为字节流以便存储或传输
 */
public class SerializationDemo {
    public static void main(String[] args) {
        // Create a User object 创建用户对象
        User user1 = new User("tom123", "hello@123", "xyz@live.com");
        try {
            // Create FileOutputStream to write to file 创建文件输出流以写入文件
            FileOutputStream o1 = new FileOutputStream("src/Chapter12/SerializationDemo/output.ser");
            // Create ObjectOutputStream for object serialization 创建对象输出流进行对象序列化
            ObjectOutputStream ob = new ObjectOutputStream(o1);

            // Serialize and write the User object to file 序列化并将用户对象写入文件
            ob.writeObject(user1);

            // Important: Close streams to release resources and ensure data is flushed
            // 重要：关闭流以释放资源并确保数据被刷新
            ob.close();

            System.out.println("Object serialized successfully!");
            System.out.println("对象序列化成功！");
        }catch (Exception e){
            System.out.println();
        }

    }
}