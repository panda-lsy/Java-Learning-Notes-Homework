package Chapter12.Practice;

import java.io.*;
import java.util.Scanner;

public class LibraryFileManagement {
    static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Library File Management");
            System.out.println("1.Add book");
            System.out.println("2.View all Book.");
            System.out.println("3.Exit");
            System.out.println("Input your choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case (1):
                    try(BufferedWriter b1 = new BufferedWriter(new FileWriter("src/Chapter12/Practice/books.txt",true))){
                        System.out.println("Input:BookID,Title,Author");
                        String Line = sc.nextLine();
                        String [] revert = Line.split(",");
                        String bookID = revert[0];
                        String title = revert[1];
                        String author = revert[2];
                        b1.write(bookID+","+title+","+author+"\n");
                        break;
                    }
                case(2):
                    try(BufferedReader b2 = new BufferedReader(new FileReader("src/Chapter12/Practice/books.txt"))){
                        String line;
                        while ((line = b2.readLine())!= null){
                            String [] revert = line.split(",");
                            String bookID = revert[0];
                            String title = revert[1];
                            String author = revert[2];
                            System.out.println(bookID+","+title+","+author);
                        }
                        break;
                    }
                case(3):
                    System.exit(0);
            }
        }
    }
}
