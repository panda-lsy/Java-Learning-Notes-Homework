package Chapter13;
import java.sql.*;
import java.util.Scanner;

public class DeleteDemo {
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

                // DELETE OPERATION - Using Statement
                // 删除操作 - 使用Statement
                System.out.println("DELETE OPERATION - Using Statement");

                // Create Statement object for executing SQL commands
                // 创建Statement对象用于执行SQL命令
                Statement stmt = con.createStatement();

                // Delete passenger with ID 103 from the table
                // 从表中删除ID为103的乘客
                String sql = "delete from passenger where passengerID=103";
                stmt.executeUpdate(sql);
                System.out.println("Deleted passenger with ID 103");
                // Student Task: Delete passenger with ID 102 from the table
                // 学生任务：从表中删除ID为102的乘客
                // TODO: Add code to delete passenger with ID 102
                // 添加代码删除ID为102的乘客
                String sql2 = "delete from passenger where passengerID=102";
                stmt.executeUpdate(sql2);
                System.out.println("Deleted passenger with ID 102");
                stmt.close();
                System.out.println("Delete operations completed");
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