package Chapter13;

// Import Java database connection related classes
// 导入Java数据库连接相关的类
import java.sql.*;
import java.util.Scanner;

// Define Select Operation Class
// 定义查询操作类
public class SelectDemo{

    // Main method - starting point of program execution
    // 主方法 - 程序执行的起点
    public static void main(String[] args) throws SQLException {

        // Declare Connection variable outside try block to access in finall block
        // 在try块外部声明Connection变量以便在finally块中访问
        Connection con = null;

        // Step 1: Store database connection information
        // 第一步：存储数据库连接信息

        // Database URL - specifies database server address and database name
        // 数据库URL - 指定数据库服务器地址和数据库名称
        String URL = "jdbc:mysql://localhost:3307/airline";
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        // Use try-catch-finally block to handle database connection and exceptions
        // 使用try-catch-finally块来处理数据库连接和异常
        try {
            // Step 2: Establish connection to the database
            // 第二步：建立到数据库的连接

            // Use DriverManager to get database connection
            // 使用DriverManager获取数据库连接
            con = DriverManager.getConnection(URL, username, password);

            // Check if connection was successfully established
            // 检查连接是否成功建立
            if (con != null) {
                // Message displayed when connection is successful
                // 连接成功时显示的消息
                System.out.println("Connected to database successfully");
                System.out.println("===================================");

                //=================================================================
                // STEP 3: SELECT OPERATION - Using PreparedStatement
                // 第三步：查询操作 - 使用PreparedStatement
                //=================================================================

                System.out.println("STEP 3: RETRIEVING PASSENGER DATA");

                // Retrieve all passenger records from the table
                // 从表中检索所有乘客记录
                String sql6 = "SELECT * FROM passenger";
                // Create PreparedStatement for SELECT operation
                // 为查询操作创建PreparedStatement
                PreparedStatement ps6 = con.prepareStatement(sql6);
                // Execute SELECT query and get ResultSet
                // 执行SELECT查询并获取ResultSet
                ResultSet rs = ps6.executeQuery();

                // Display column headers for better readability
                // 显示列标题以提高可读性
                System.out.println("PassengerID | Name      | Address | Seat_Number");

                        // Iterate through the ResultSet to display all records
                        // 遍历ResultSet以显示所有记录
                while (rs.next()) {
                    // Retrieve values from current row in ResultSet
                    // 从ResultSet的当前行检索值
                    int passengerID = rs.getInt("passengerID");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    int seatNumber = rs.getInt("Seat_Number");

                    // Display the passenger record
                    // 显示乘客记录
                    System.out.printf("%-11d | %-9s | %-33s | %d%n",
                            passengerID, name, address, seatNumber);
                }

                // Close ResultSet and PreparedStatement
                // 关闭ResultSet和PreparedStatement
                rs.close();
                ps6.close();

                //*******Student Task:****************************
                //Display details of passenger with passengerID 102
                //显示乘客ID为102的详细信息


                // Final status message after all operations
                // 所有操作完成后的最终状态消息
                System.out.println("All database operations completed successfully!");

            }

        } catch (SQLException e) {
            // If any database operation fails, catch SQL exception
            // 如果任何数据库操作失败，捕获SQL异常

            // Display detailed error information
            // 显示详细的错误信息
            System.out.println("Database Operation Failed: " + e.getMessage());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            e.printStackTrace(); // Print stack trace for debugging - 打印堆栈跟踪用于调试
        } finally {
            // Step 4: finally block - close database connection to release resources
                    // 第四步：finally块 - 关闭数据库连接以释放资源

                    // Check if connection exists before closing to avoid NullPointerException
            // 在关闭前检查连接是否存在以避免NullPointerException
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Database connection closed - 数据库连接已关闭");
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}
