package Chapter04.Practice;

import java.util.Scanner;

public class employeeIDFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID for Search:");
        String searchID = sc.nextLine();
        String [] IDs = {"11300","110"};
        for (String ID:IDs){
            if (ID.equals(searchID)){
                System.out.println("ID "+searchID+" found");
                break;
            }
            else if (ID.equals(IDs[IDs.length-1])){
                System.out.println("ID "+searchID+" not found");
                break;
            }
        }
    }
}
