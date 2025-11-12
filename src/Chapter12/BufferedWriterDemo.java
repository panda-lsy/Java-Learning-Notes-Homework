package Chapter12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) {
        System.out.println("Different fruits:");

        // Using try-with-resources to automatically close BufferedWriter 
        // 使用try-with-resources自动关闭BufferedWriter 
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/Chapter12/output3.txt"))) {
            String[] fruits = {"apple", "banana", "orange", "grape", "grape fruit"};

            // Write each fruit to the file 
            // 将每个水果写入文件 
            for(String f : fruits) {
                bw.write(f);        // Write fruit name 写入水果名称 
                bw.newLine();       // Add new line after each fruit 每个水果后添加新行
                System.out.println("Written: " + f); // Display in console 在控制台显示
            }

            // Optional: Flush to ensure data is written immediately 
            // 可选：刷新确保数据立即写入 
            bw.flush();

            System.out.println("All fruits written to file successfully!"); 
 
        } catch(IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }