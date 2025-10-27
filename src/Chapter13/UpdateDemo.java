package Chapter13;
import java.sql.*;
import java.util.Scanner;

public class UpdateDemo {
    public static void main(String[] args) throws SQLException {
        Connection con = null;

        String URL = "jdbc:mysql://localhost:3307/airline";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        try {
            con = DriverManager.getConnection(URL, username, password);

            if (con != null) {
                System.out.println("Connected to database successfully");
                System.out.println("===================================");

                // UPDATE OPERATION - Using Statement
                // 更新操作 - 使用Statement
                System.out.println("UPDATE OPERATION - Using Statement");

                // Create Statement object for executing SQL commands
                // 创建Statement对象用于执行SQL命令
                Statement stmt = con.createStatement();

                // Update passenger name for passenger with ID 102
                // 更新ID为102的乘客姓名
                String sql = "update passenger set name='LIN' where passengerID=102";
                stmt.executeUpdate(sql);
                System.out.println("Updated passenger name for ID 102");

                // Student Task: Update passenger address for passenger with ID 101
                // 学生任务：更新ID为101的乘客地址
                // TODO: Add code to update address for passenger ID 101
                // 添加代码更新ID为101的乘客地址

                stmt.close();
                System.out.println("Update operations completed");
            }

        } catch (SQLException e) {
            System.out.println("Database Operation Failed: " + e.getMessage());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        } finally {
            con.close();
        }
    }
}