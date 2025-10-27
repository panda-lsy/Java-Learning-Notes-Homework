package Chapter13;
import java.sql.*;
import java.util.Scanner;

public class TableCreationDemo {
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

                Statement stmt = con.createStatement();

                // =================================================================
                // ACTIVITY 1: CREATE PASSENGER TABLE
                // 活动1：创建乘客表
                // =================================================================

                System.out.println("\n=== ACTIVITY 1: CREATE PASSENGER TABLE ===");
                System.out.println("=== 活动1：创建乘客表 ===");

                String sql = "create table passenger(passengerID int PRIMARY KEY, name varchar(20) NOT NULL, address varchar(50) NOT NULL, Seat_Number int NOT NULL);";
                stmt.execute(sql);
                System.out.println("Passenger table created successfully");



                stmt.close();
                System.out.println("\nAll table creation activities completed!");
            }

        } catch (SQLException e) {
            System.out.println("Database Operation Failed: " + e.getMessage());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}