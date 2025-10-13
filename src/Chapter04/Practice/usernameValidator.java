package Chapter04.Practice;

import java.util.Scanner;

public class usernameValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        if (username.length()>=6){
            if (!username.contains(" ")){
                if (Character.isLetter(username.charAt(0))){
                    System.out.println("Valid username");
                }else{
                    System.out.println("Invalid username: Not start with a letter");
                }
            }else{
                System.out.println("Invalid username: Contains Space!");
            }
    }else{
            System.out.println("Invalid username: Length is too short!");
        }
    }
}
