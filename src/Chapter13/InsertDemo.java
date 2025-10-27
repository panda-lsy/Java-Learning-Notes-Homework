package Chapter13;
import java.sql.*;
import java.util.Scanner;

public class InsertDemo {
    public static void main(String[] args) throws SQLException {
        Connection con = null;

        String URL = "jdbc:mysql://localhost:3307/airline?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        try {
            con = DriverManager.getConnection(URL, username, password);

            if (con != null) {
                System.out.println("Connected to database successfully");
                System.out.println("===================================");

                // INSERT OPERATION - Using Statement
                // 插入操作 - 使用Statement
                System.out.println("INSERT OPERATION - Using Statement");

                // Create Statement object for executing SQL commands
                // 创建Statement对象用于执行SQL命令
                Statement stmt = con.createStatement();

                // Insert first passenger record with ID 101
                // 插入第一个乘客记录，ID为101
                String sql1 = "insert into passenger(passengerID, name, address, Seat_Number) values(101, 'Paul', 'Hainan University,Haikou', 25)";
                stmt.executeUpdate(sql1);
                System.out.println("Inserted passenger with ID 101");

                // Insert second passenger record with ID 102
                // 插入第二个乘客记录，ID为102
                String sql2 = "insert into passenger(passengerID, name, address, Seat_Number) values(102, 'Carter', 'Hainan Normal University,Haikou', 26)";
                stmt.executeUpdate(sql2);
                System.out.println("Inserted passenger with ID 102");
                
                // Student Task: Insert third passenger record with ID 103
                // 学生任务：插入第三个乘客记录，ID为103
                // TODO: Add code to insert passenger with ID 103
                // 添加代码插入ID为103的乘客
                String sql3 = "insert into passenger(passengerID, name, address, Seat_Number) values(103, 'Emma', 'Haikou College of Economics,Haikou', 27)";
                stmt.executeUpdate(sql3);
                stmt.close();
                
                System.out.println("Insert operations completed");
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