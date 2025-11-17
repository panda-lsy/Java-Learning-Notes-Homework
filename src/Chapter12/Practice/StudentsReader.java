package Chapter12.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StudentsReader {
    public static void main(String[] args) {
        Path path = Paths.get("src/Chapter12/Practice/students.txt");
        if (!Files.exists(path)) {
            System.err.println("文件不存在: " + path);
            return;
        }

        int count = 0;
        try (BufferedReader b1 = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            int lineNo = 0;
            while ((line = b1.readLine()) != null) {
                lineNo++;
                if (line == null) {
                    continue;
                }
                line = line.trim();
                if (line.isEmpty()) {
                    continue; // 跳过空行
                }
                String[] parts = line.split(",", 2);
                if (parts.length < 2) {
                    System.err.println("第 " + lineNo + " 行格式错误，期望 '姓名,分数'，内容: " + line);
                    continue;
                }
                String name = parts[0].trim();
                String mark = parts[1].trim();
                System.out.println("Name: " + name + " Mark: " + mark);
                count++;
            }
            System.out.println("Total Students: " + count);
        } catch (IOException e) {
            System.err.println("读取文件时出错: " + e.getMessage());
        }
    }
}