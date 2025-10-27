// java
package Chapter13;

import java.sql.*;
import java.util.Scanner;

public class DatabaseDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/sample?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password:");
        String password = sc.nextLine(); // mysql password here

        // 可选：显式加载驱动（JDBC4+ 通常不需要）
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return;
        }

        // 使用 try-with-resources 自动关闭连接/语句/结果集
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database.");

            String sql = "SELECT id, name, email FROM users LIMIT 5";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                System.out.println("Query results:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.printf("id=%d, name=%s, email=%s%n", id, name, email);
                }
            }

        } catch (SQLException e) {
            System.err.println("Connection or query failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
