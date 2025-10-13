package Chapter05;
//Create an abstract class Shape with following variables and methods 创建一个具有以下变量和方法的抽象类 Shape
//variable name-Shape_Name 变量名-Shape_Name
//Method-Display name of the Shape 方法-形状的显示名称
//Abstract methods CalculateArea and CalculatePerimeter without implementation  and it must be implemented in sub classes. 抽象方法 CalculateArea 和 CalculatePerimeter 没有实现，必须在子类中实现。
abstract class Shape{
    //variables 变量
    String name;
    // Constructor - abstract classes can have constructors 构造函数 - 抽象类可以有构造函数
    Shape (String name){
        this.name=name;
    }
    // Concrete method - this method has complete code ready to use 具体方法 - 此方法已准备好完整代码可直接使用
    // All child classes will get this method for free 所有子类都将免费获得此方法
    public void display(){
        System.out.println("Shape Name is"+name);
    }
    // Abstract method - this is just an idea without code 抽象方法 - 这只是一个没有代码的想法
    //CalculateArea
    // Child classes MUST write the actual code for this method 子类必须编写此方法的具体代码
    public abstract double calculateArea();
    // Abstract method - another idea that needs implementation 抽象方法 - 另一个需要实现的想法
    //CalculatePerimeter
    // Each shape will calculate perimeter in its own way 每个形状将以自己的方式计算周长
    public abstract double calculatePerimeter();
}
//Create a class Circle inherits abstract class Shape 创建一个名为 Circle 的类，继承自抽象类 Shape
class Circle extends Shape{
    //Declare Variables 声明变量
    double radius;
    // Constructor - calls parent constructor and sets circle properties  构造函数 - 调用父构造函数并设置圆属性
    Circle(String name,double radius){
        super(name);
        this.radius = radius;
    }
    // Implementing abstract method - telling HOW circle calculates area 实现抽象方法 - 说明圆如何计算面积
    // We MUST write this method because it's abstract in parent class 我们必须编写此方法，因为它在父类中是抽象的\
    public double calculateArea(){
        return 3.14*radius*radius;
    }
    // Implementing abstract method - telling HOW circle calculates perimeter 实现抽象方法 - 说明圆如何计算周长
    // We MUST write this method because it's abstract in parent class 我们必须编写这个方法，因为它在父类中是抽象的
    public double calculatePerimeter(){
        return 3.14*radius*2;
    }
}
// Create Rectangle class - another real shape that follows the Shape rules 创建矩形类 - 另一个遵循形状规则的实体形状
class Rectangle extends Shape {
    //Declare Variables length and width 声明变量长度和宽度
    double length;
    double width;
    // Constructor - calls parent constructor and sets rectangle properties 构造函数 - 调用父类构造函数并设置矩形属性
    Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }
    // Implementing abstract method - telling HOW rectangle calculates area 实现抽象方法 - 说明矩形如何计算面积
    // Different from circle - rectangle has its own formula 与圆形不同 - 矩形有自己的公式
    public double calculateArea() {
        return length * width;
    }
    // Implementing abstract method - telling HOW rectangle calculates perimeter 实现抽象方法 - 说明矩形如何计算周长
    // Different from circle - rectangle has its own formula 与圆形不同 - 矩形有自己的公式
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
//Create the Main Class 创建主类
public class abstractClassDemo {
    public static void main(String[] args) {
        // Create a Circle object with name "Circle" and radius 5.0 创建一个名为 "Circle" 的 Circle 对象，半径为 5.0
        Circle circle = new Circle("Circle", 5.0);
        Rectangle rectangle = new Rectangle("Rectangle", 4.0, 6.0);
        // Create a Rectangle object with name "Rectangle", length 4.0 and width 6.0  创建一个名为 "Rectangle" 的 Rectangle 对象，长度为 4.0，宽度为 6.0

        // Test Circle object 测试 Circle 对象
        System.out.println("=== CIRCLE ===");
        // Call display method from Shape class 从 Shape 类调用 display 方法
        circle.display();
        // Call calculateArea method implemented in Circle class 调用 Circle 类中实现的 calculateArea 方法
        System.out.println("Area: " + circle.calculateArea());
        // Call calculatePerimeter method implemented in Circle class 调用 Circle 类中实现的 calculatePerimeter 方法
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        // Test Rectangle object 测试矩形对象
        System.out.println("\n=== RECTANGLE ===");
        // Call display method from Shape class 调用 Shape 类中的 display 方法
        rectangle.display();
        // Call calculateArea method implemented in Rectangle class 调用 Rectangle 类中实现的 calculateArea 方法
        System.out.println("Area: " + rectangle.calculateArea());
        // Call calculatePerimeter method implemented in Rectangle class 调用 Rectangle 类中实现的 calculatePerimeter 方法
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    }
}

