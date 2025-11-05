package Chapter13;
import java.sql.*;
import java.util.Scanner;

public class AirlineReservationDemo {
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

                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                // =================================================================
                // ACTIVITY 1: DISPLAY ALL PASSENGER INFORMATION
                // 活动1：显示所有乘客信息
                // =================================================================

                System.out.println("\n=== ACTIVITY 1: DISPLAY ALL PASSENGERS ===");
                System.out.println("=== 活动1：显示所有乘客 ===");

                String sql6 = "select * from passenger;";
                ResultSet rs = stmt.executeQuery(sql6);

                // Display formatted header
                // 显示格式化标题
                System.out.println("PassengerID | Name      | Address                           | Seat_Number");


                while (rs.next()) {
                    //formatting output
                    //- left align
                    //11 no of characters
                    // d-inteeger
                    System.out.printf("%-11d | %-9s | %-33s | %d%n",
                            rs.getInt("passengerID"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getInt("Seat_Number")
                    );
                }
                rs.close();

                System.out.println("\n=== ACTIVITY 2: FIND PASSENGER BY NAME ===");
                //find passenger details where name starts with lette a
                String query1 = "select * from passenger where name like '%a'";
                ResultSet rs0 = stmt.executeQuery(query1);
                while (rs0.next()) {
                    //formatting output
                    //- left align
                    //11 no of characters
                    // d-inteeger
                    System.out.printf("%-11d | %-9s | %-33s | %d%n",
                            rs0.getInt("passengerID"),
                            rs0.getString("name"),
                            rs0.getString("address"),
                            rs0.getInt("Seat_Number")
                    );
                }
                rs0.close();


                System.out.println("\n=== ACTIVITY 3: FIND PASSENGER BY ID ===");





                // Student Task: Display details of passenger with passengerID 101
                // 学生任务：显示ID为101的乘客详细信息
                // TODO: Add code to find and display passenger with ID 101
                // 添加代码查找并显示ID为101的乘客



                stmt.close();
                System.out.println("All activities completed successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Database Operation Failed: " + e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}