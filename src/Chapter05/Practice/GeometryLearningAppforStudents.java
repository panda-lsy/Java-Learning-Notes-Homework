package Chapter05.Practice;

import java.util.Scanner;

abstract class Shape{
    String shapeName;
    String shapeColor;
    String shapeID;

    double calculateArea(){
        return 0;
    }

    double calculatePerimeter(){
        return 0;
    }

    void displayShapeInfo(){
    }
}

class Circle extends Shape{
    double radius;

    @Override
    double calculateArea() {
        return radius*radius*3.14;
    }

    @Override
    double calculatePerimeter(){
        return 2*3.14*radius;
    }
}

class Rectangle extends Shape{
    double length;
    double width;

    @Override
    double calculateArea(){
        return length*width;
    }

    @Override
    double calculatePerimeter(){
        return length*2+width*2;
    }
}

class Triangle extends Shape{
    double base,height,side1,side2,side3;

    @Override
    double calculateArea(){
        return side1+side2+side3;
    }

    @Override
    double calculatePerimeter(){
        return 0.5*base*height;
    }
}

public class GeometryLearningAppforStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geometry Learning App");
        System.out.println("1.Circle");
        System.out.println("2.Rectangle");
        System.out.println("3.Triangle");
        int choice = sc.nextInt();
        switch (choice){
            case(1):
                Circle circle = new Circle();
                circle.shapeID = "1001";
                circle.shapeColor = "Red";
                circle.radius = 10;
                System.out.println("Shape: Circle (ID:"+circle.shapeID+")|Color:"+circle.shapeColor);
                System.out.println("Area:"+circle.calculateArea()+"| Perimeter:"+circle.calculatePerimeter());
                break;
            case (2):
                Rectangle rectangle = new Rectangle();
                rectangle.shapeID = "1002";
                rectangle.shapeColor = "Red";
                rectangle.width = 10;
                rectangle.length = 8;
                System.out.println("Shape: Rectangle (ID:"+rectangle.shapeID+")|Color:"+rectangle.shapeColor);
                System.out.println("Area:"+rectangle.calculateArea()+"| Perimeter:"+rectangle.calculatePerimeter());
                break;
            case (3):
                Triangle triangle = new Triangle();
                triangle.shapeColor = "Yellow";
                triangle.shapeID = "1003";
                triangle.base = 6;
                triangle.height = 10;
                triangle.side1 = 5;
                triangle.side2 = 8;
                triangle.side3 = 10;
                System.out.println("Shape: Triangle (ID:"+triangle.shapeID+")|Color:"+triangle.shapeColor);
                System.out.println("Area:"+triangle.calculateArea()+"| Perimeter:"+triangle.calculatePerimeter());
                break;
        }
    }
}
