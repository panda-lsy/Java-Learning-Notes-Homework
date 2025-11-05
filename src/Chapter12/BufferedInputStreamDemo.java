package Chapter12;

import java.io.*;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        int i;  // Stores byte value read from stream / 存储从流读取的字节值 
        char c; // Converts byte to character for display / 将字节转换为字符用于显示
        File file = new File("src/Chapter12/test.txt");
        // Try-with-resources: Automatically closes both streams / 自动关闭两个流
        try(FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis)){

        // Check if mark/reset is supported / 检查是否支持标记/重置功能

        // Read first 10 characters / 读取前10个字符
        System.out.println("Reading first 10 characters:");
        for (int j=0;j<10;j++){
            i = bis.read();
            System.out.print((char) i);
        }

        System.out.println(); // New line after printing characters / 打印字符后换行

        // Mark current position with read limit of 10 bytes / 标记当前位置，读取限制为10字节
        // This allows us to reset back to this position later / 这允许我们稍后重置回此位置..user mark()

        System.out.println("\nMark set at current position.");
        bis.mark(20);
        // Skip 2 characters / 跳过2个字符---use skip();
        bis.skip(2);
        System.out.println("Skipped 2 characters.");

        // Read next 7 characters after skipping / 跳过之后读取接下来的7个字符
        for (int j=0;j<7;j++){
            i = bis.read();
            System.out.print((char) i);
        }
            System.out.println();

        // Reset stream back to marked position / 将流重置回标记的位置
        bis.reset();
        // Read 6 characters from reset position / 从重置位置读取6个字符
        for (int j=0;j<6;j++){
            i = bis.read();
            System.out.print((char) i);
        }
        System.out.println();
        // Final new line / 最后换行

        System.out.println("\n=== Demo Completed ===");

    } catch (FileNotFoundException e) {
        // Handle file not found exception / 处理文件未找到异常
        System.out.println("File not found: " + e.getMessage());
        System.out.println("Please check the file path: src/Chapter12/test.txt");

    } catch (IOException e) {
        // Handle general I/O exceptions / 处理㇐般I/O异常
        System.out.println("I/O Error: " + e.getMessage());
        e.printStackTrace(); // Print stack trace for debugging / 打印堆栈跟踪用于调试
    }
}
} 