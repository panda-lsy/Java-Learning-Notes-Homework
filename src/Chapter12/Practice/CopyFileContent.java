package Chapter12.Practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFileContent {
    static void main() throws IOException {
        Path src = Paths.get("src/Chapter12/Practice/data.txt");
        Path dst = Paths.get("src/Chapter12/Practice/backup.txt");

        if (!Files.exists(src)) {
            System.err.println("文件未找到: " + src);
            return;
        }

        try (InputStream in = new BufferedInputStream(Files.newInputStream(src));
             OutputStream out = new BufferedOutputStream(Files.newOutputStream(dst))) {

            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("拷贝时发生 I/O 错误: " + e.getMessage());
        }
    }
}