package Chapter12.Practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FeedbackWriter {
    static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter f1 = new FileWriter("src/Chapter12/Practice/feedback.txt",true);
        String input = new String();
        do{
            System.out.print("Enter feedback:");
            input = sc.nextLine();
            if (input.isEmpty()){
                System.out.println("Can't submit blank content.");
                break;
            }
            f1.write(input);
        }while (!input.isEmpty());
        System.out.println("Feedback saved successfully.");
        f1.close();
    }
}
