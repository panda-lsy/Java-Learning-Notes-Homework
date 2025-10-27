package Chapter13;
// 导入Java数据库连接相关的类
// Import Java database connection related classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

// 定义航空公司预订演示类
// Define DBConnection Demo class
public class DBConnection {
    // 主方法 - 程序执行的起点
// Main method - starting point of program execution
    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);

        // 声明Connection变量，在try块外部以便在finally块中访问
        // Declare Connection variable outside try block to access in finally block
        Connection con = null;

        // 第一步：存储数据库连接信息
        // Step 1: Store database connection information

        // 数据库URL - 指定数据库服务器地址和数据库名称
        // Database URL - specifies database server address and database name
        String URL = "jdbc:mysql://localhost:3307/airline";
        // 数据库用户名
        // Database username
        String username = "root";
        // 数据库密码
        // Database password
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        // 使用try-catch-finally块来处理数据库连接
        // Use try-catch-finally block to handle database connection
        try {
            // 第二步：建立到数据库的连接
            // Step 2: Establish connection to the database

            // 使用DriverManager获取数据库连接
            // Use DriverManager to get database connection
            con = DriverManager.getConnection(URL, username, password);

            // 检查连接是否成功建立
            // Check if connection was successfully established
            if (con != null) {
                // 连接成功时显示的消息
                // Message displayed when connection is successful
                System.out.println("Connected to database successfully");
                // 成功连接到数据库
            }

        } catch (SQLException e) {
// 如果连接失败，捕获SQL异常
// If connection fails, catch SQL exception
// 连接失败时显示的消息
// Message displayed when connection fails
            System.out.println("Connection Failed: " + e.getMessage());
// 连接失败，显示具体错误信息
        } finally {
// 第三步：finally块 - 只包含con.close()
// Step 3: finally block - only contains con.close()
            if (con != null) {
                con.close();
            }
        }
    }
}