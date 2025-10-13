package Chapter04.Practice;

import java.util.Scanner;

public class emailFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String emailAddress = sc.nextLine();
        emailAddress = emailAddress.toLowerCase().trim();
        if (emailAddress.contains("@")){
            System.out.println("Formatted Address:"+emailAddress);
        }else{
            System.out.println("Invalid Address: Not have '@'");
        }
    }
}
