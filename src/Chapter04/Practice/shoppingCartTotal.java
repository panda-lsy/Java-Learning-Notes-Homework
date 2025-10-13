package Chapter04.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class shoppingCartTotal {
    public static void main(String[] args) {
        System.out.println("请以'x y ...'的形式输入数据");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] inputs = inputLine.split(" ");
        int [] intArray = new int[inputs.length];
        for (int i=0;i<inputs.length;i++){
            intArray[i] = Integer.parseInt(inputs[i]);
        }

        float total = 0;
        for (int num:intArray){
            total += num;
        }

        if (total>=100){
            total*= 0.9F;
        }

        System.out.println("Total Price:"+total);
    }
}
