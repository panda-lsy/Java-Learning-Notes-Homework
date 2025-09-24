package Chapter03.Activity;

class Blueprint{
    String title;
    String author;
    boolean isCheckedOut;
    String dueDate;
    void borrowBook(String dueDate){
        if(!isCheckedOut){
            isCheckedOut = true;
            this.dueDate = dueDate;
            System.out.println("You have borrowed \"" + title + "\". It is due on " + dueDate + ".");
        } else {
            System.out.println("Sorry, this book is already checked out.");
        }
    }
}

public class LibraryBookScenario {
    public static void main(String[] args) {
        Blueprint book1 = new Blueprint();
        book1.title = "The Alchemist";
        book1.author = "Paulo Coelho";
        book1.isCheckedOut = false;

        book1.borrowBook("2024-07-01");  // Successful borrow
        book1.borrowBook("2024-07-15");  // Already checked out
    }
}
