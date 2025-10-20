package Chapter05.Assignment;

import java.awt.print.Book;
import java.util.Scanner;

    abstract class Furniture {
    String furnitureName;
    double furnitureLength;
    double furnitureWidth;
    double furniturePrice;
    void displayFurnitureInfo(){
        System.out.println("Name:"+furnitureName);
        System.out.println("Length:"+furnitureLength);
        System.out.println("Width:"+furnitureWidth);
        System.out.println("Price:"+furniturePrice);
    }
}

class Bookshelf extends Furniture {
        public Bookshelf(String furnitureName, double furnitureLength, double furnitureWidth, double furniturePrice){
            this.furnitureName = furnitureName;
            this.furnitureLength = furnitureLength;
            this.furnitureWidth = furnitureWidth;
            this.furniturePrice = furniturePrice;
        }
}

class Chair extends Furniture{
    public Chair(String furnitureName, double furnitureLength, double furnitureWidth, double furniturePrice){
        this.furnitureName = furnitureName;
        this.furnitureLength = furnitureLength;
        this.furnitureWidth = furnitureWidth;
        this.furniturePrice = furniturePrice;
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Order Processing System");
        System.out.println("1.Bookshelf");
        System.out.println("2.Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Input Length:");
        double length = sc.nextDouble();
        sc.nextLine();
        System.out.print("Input Width:");
        double width = sc.nextDouble();
        sc.nextLine();
        System.out.print("Input Price:");
        double price = sc.nextDouble();
        sc.nextLine();
        switch (choice) {
            case (1):
                Bookshelf bs = new Bookshelf("Bookshelf",length,width,price);
                System.out.println("Furniture: " + bs.furnitureName + "Price:" + bs.furniturePrice);
                System.out.println("Width:" + bs.furnitureWidth + " Length:" + bs.furnitureLength);
                break;
            case (2):
                Chair chair = new Chair("Chair",length,width,price);
                System.out.println("Furniture: " + chair.furnitureName + "Price:" + chair.furniturePrice);
                System.out.println("Width:" + chair.furnitureWidth + " Length:" + chair.furnitureLength);
                break;
        }
    }
}
