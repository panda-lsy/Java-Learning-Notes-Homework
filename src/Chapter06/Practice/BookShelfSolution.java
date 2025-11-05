package Chapter06.Practice;

public class BookShelfSolution {
    public static void main(String[] args) {
// Our bookshelf with 5 books
// 我们的书架有5本书
        String[] books = {"Math", "Science", "English", "Art", "Music"};
        try {
// Try to get book from position 10
// 尝试从位置10获取书
            String book = books[10];
            System.out.println("Found book: " + book);
        } catch (ArrayIndexOutOfBoundsException e) {
// This runs if position doesn't exist
// 如果位置不存在，这里会运行
            System.out.println("No book found at that position!");
            System.out.println("Books are only at positions 0 to 4");
        }
// This line always runs - program doesn't crash!
// 这行代码总是会运行 - 程序不会崩溃！
        System.out.println("Program executed successfully!");
    }
}
