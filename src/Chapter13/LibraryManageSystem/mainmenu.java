package Chapter13.LibraryManageSystem;

import java.sql.*;
import java.util.Scanner;

public class mainmenu {
    static void main() throws SQLException {
        Scanner sc = new Scanner(System.in);

        Connection con = null;

        String URL = "jdbc:mysql://localhost:3307/books";
        String username = "root";
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        try {
            con = DriverManager.getConnection(URL, username, password);

            if (con != null) {
                System.out.println("Connected to database successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
        while (true) {
            System.out.println("=== SIMPLE LIBRARY SYSTEM ===");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Remove Book");
            System.out.println("6. Exit");
            System.out.println("Choose option (1-6):");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case (1):
                    System.out.println("Enter Book Title: ");
                    String bookTitle = sc.nextLine();
                    System.out.println("Enter Author Name: ");
                    String authorName = sc.nextLine();
                    String addQuery = "insert into books(title, author, is_available) values(?,?,?)";
                    try (PreparedStatement ps1 = con.prepareStatement(addQuery)) {
                        ps1.setString(1, bookTitle);
                        ps1.setString(2, authorName);
                        ps1.setBoolean(3, true);
                        int insertedRows = ps1.executeUpdate();
                        System.out.println("Inserted " + insertedRows + " Rows:");
                        System.out.println("Book: " + bookTitle);
                        System.out.println("Author: " + authorName);
                    } catch (SQLException e) {
                        System.out.println("Database Operation Failed: " + e.getMessage());
                    }
                    break;
                case (2):
                    String selectQuery = "SELECT * FROM books";
                    try (PreparedStatement ps2 = con.prepareStatement(selectQuery);
                         ResultSet rs = ps2.executeQuery()) {
                        System.out.println("BookID      | Book Title     | Author Name       | Is Available ");
                        while (rs.next()) {
                            int bookID = rs.getInt("book_id");
                            String book = rs.getString("title");
                            String author = rs.getString("author");
                            boolean state = rs.getBoolean("is_available");
                            String statement = state ? "Yes" : "No";
                            System.out.printf("%-11d   |   %-9s    |   %-33s   |   %s\n", bookID, book, author, statement);
                        }
                    } catch (SQLException e) {
                        System.out.println("Database Operation Failed: " + e.getMessage());
                    }
                    break;
                case (3):
                    System.out.println("Enter Book ID: ");
                    int bookID = sc.nextInt();
                    if (!bookExists(con, bookID)) {
                        System.out.println("Book ID not found.");
                        break;
                    }
                    if (!isAvailable(con, bookID)) {
                        System.out.println("Book is already borrowed (not available).");
                        break;
                    }
                    String borrowQuery = "update books set is_available=? where book_id=?";
                    try (PreparedStatement ps3 = con.prepareStatement(borrowQuery)) {
                        ps3.setBoolean(1, false);
                        ps3.setInt(2, bookID);
                        int rows = ps3.executeUpdate();
                        if (rows > 0) {
                            System.out.println("Borrow Success!");
                        } else {
                            System.out.println("Borrow failed: no rows updated.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Database Operation Failed: " + e.getMessage());
                        System.out.println("Error Code: " + e.getErrorCode());
                        System.out.println("SQL State: " + e.getSQLState());
                    }
                    break;
                case (4):
                    System.out.println("Enter Book ID: ");
                    bookID = sc.nextInt();
                    if (!bookExists(con, bookID)) {
                        System.out.println("Book ID not found.");
                        break;
                    }
                    String returnQuery = "update books set is_available=? where book_id=?";
                    try (PreparedStatement ps4 = con.prepareStatement(returnQuery)) {
                        ps4.setBoolean(1, true);
                        ps4.setInt(2, bookID);
                        int rows = ps4.executeUpdate();
                        if (rows > 0) {
                            System.out.println("Return Success!");
                        } else {
                            System.out.println("Return failed: no rows updated.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Database Operation Failed: " + e.getMessage());
                        System.out.println("Error Code: " + e.getErrorCode());
                        System.out.println("SQL State: " + e.getSQLState());
                    }
                    break;
                case (5):
                    System.out.println("Enter Book ID: ");
                    bookID = sc.nextInt();
                    if (!bookExists(con, bookID)) {
                        System.out.println("Book ID not found.");
                        break;
                    }
                    String removeQuery = "delete from books where book_id=?";
                    try (PreparedStatement ps5 = con.prepareStatement(removeQuery)) {
                        ps5.setInt(1, bookID);
                        int rows = ps5.executeUpdate();
                        if (rows > 0) {
                            System.out.println("Remove Success!");
                        } else {
                            System.out.println("Remove failed: no rows deleted.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Database Operation Failed: " + e.getMessage());
                        System.out.println("Error Code: " + e.getErrorCode());
                        System.out.println("SQL State: " + e.getSQLState());
                    }
                    break;
                case (6):
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }

    static boolean bookExists(Connection con, int bookID) throws SQLException {
        String query = "SELECT 1 FROM books WHERE book_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bookID);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    static boolean isAvailable(Connection con, int bookID) throws SQLException {
        String query = "SELECT is_available FROM books WHERE book_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bookID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("is_available");
                } else {
                    return false;
                }
            }
        }
    }
}