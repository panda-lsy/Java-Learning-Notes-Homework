# 对象创建

## 无构造函数

```java
class Student {
    int id;
    String name; //没有构造函数，初始值为 0
}

public class Main {
    public static void main(String[] args) {
        // 使用编译器提供的默认无参构造器
        Student s1 = new Student();
        s1.id = 1001;
        s1.name = "Alice";
        System.out.println(s1.id + " - " + s1.name);
    }
}
```

## 有构造函数

```java

class Student {
    int id;
    String name;

    // 自定义构造函数
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main2 {
    public static void main(String[] args) {
        // 通过构造器一次性完成初始化
        Student s2 = new Student(1002, "Bob");
        System.out.println(s2.id + " - " + s2.name);
    }
}
```

区别：

- 无构造函数：使用默认无参构造器，先创建对象再逐个赋值，易出现未完全初始化。
- 有构造函数：创建时强制传入必要参数，集中初始化并可做校验；一旦定义了任何构造函数，默认无参构造器将不再自动提供。

# 类的继承

Java 中的类可以继承另一个类的特性。

在单级继承中，单个子类派生现有超类的功能。

在多级继承中，一个子类继承另一个子类的属性。

在层次继承中，一个或多个子类派生自一个超类。

# 抽象类

- 定义：使用 abstract 修饰，不能被实例化，可包含构造器、字段、普通方法与抽象方法。
- 作用：提供“部分实现 + 必须实现的抽象方法”，用于复用通用逻辑并约束子类。

示例：

```java
abstract class Animal {
    String name;

    Animal(String name) { // 构造器可供子类 super 调用
        this.name = name;
    }

    void breathe() { System.out.println(name + " is breathing"); } // 具体方法
    abstract void sound(); // 抽象方法：无方法体
}

class Dog extends Animal {
    Dog(String name) { super(name); }
    @Override
    void sound() { System.out.println("Woof"); }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog("Buddy"); // 多态：父类引用指向子类对象
        a.breathe();
        a.sound();
    }
}
```

注意：

- 抽象类不能被实例化；抽象方法不能为 private/static/final。
- 子类必须实现所有抽象方法，否则子类也需声明为 abstract。
- 抽象类可以有状态（实例字段）与受保护的公用逻辑，适合模板方法等场景。

# 继承接口

- 定义：interface 描述“能力契约”，默认方法体为空；常量为 public static final，抽象方法为 public（省略时也是）。
- 实现：class 使用 implements 实现接口；可多实现。
- 接口继承：interface 可 extends 其他接口（可多继承）。

示例：实现与默认方法

```java
interface Movable {
    int DEFAULT_SPEED = 10; // 常量：public static final
    void move();            // 抽象方法：public
    default void stop() {   // Java 8+ 默认方法
        System.out.println("Stopped");
    }
    static void info() {    // 静态方法（接口级）
        System.out.println("I am Movable");
    }
}

class Car implements Movable {
    @Override
    public void move() { // 实现时必须是 public
        System.out.println("Car moving at " + DEFAULT_SPEED);
    }
}

public class Demo {
    public static void main(String[] args) {
        Movable m = new Car();
        m.move();
        m.stop();
        Movable.info();
    }
}
```

示例：接口的多继承与类的多实现

```java
interface A { void a(); }
interface B { void b(); }
interface C extends A, B { void c(); } // 接口多继承

class X implements A, B {               // 类多实现
    public void a() {}
    public void b() {}
}
```

对比与选型：

- 抽象类：适合“is-a”且需共享状态/通用实现；只能单继承。
- 接口：适合“能力契约”、解耦与多实现；无实例字段，可有默认/静态方法。
- 若需要多重行为组合，用接口；需要基类状态与公共骨架，用抽象类。
- 默认方法冲突时，必须在实现类中显式重写解决。

# 静态多态性（编译期多态：方法重载）

- 定义：同一类中存在多个同名方法，但参数列表不同（个数、类型、顺序）；编译期根据“引用的静态类型 + 实参”选择最匹配的方法。
- 规则与要点：
    - 不能仅靠返回类型区分重载。
    - 可与访问修饰符/返回类型/抛出异常不同，但不影响重载判定。
    - 会参与装箱/拆箱、可变参数匹配与“最具体方法”选择。
    - 子类也可重载父类的方法（签名不同），注意这不是“重写”。

示例：重载选择与二义性
```java
class OverloadDemo {
        void f(int x)        { System.out.println("int"); }
        void f(long x)       { System.out.println("long"); }
        void f(Integer x)    { System.out.println("Integer"); }
        void f(Object x)     { System.out.println("Object"); }
        void f(int... xs)    { System.out.println("varargs"); }

        void g(String s)     { System.out.println("String"); }
        void g(Integer i)    { System.out.println("Integer"); }

        public static void main(String[] args) {
                OverloadDemo d = new OverloadDemo();
                d.f(1);           // int（最精确匹配）
                d.f(1L);          // long
                d.f(Integer.valueOf(1)); // Integer
                d.f("hi");        // Object（无更具体的重载）
                d.f();            // varargs
                // d.g(null);     // 编译错误：String 与 Integer 均可匹配 => 二义性
                d.g((String) null); // 通过显式强转消除二义性
        }
}
```

对比：重载 vs 继承交互（易误判）
```java
class Base { void m(Object o) { System.out.println("Base:Object"); } }
class Sub  extends Base {
        void m(String s) { System.out.println("Sub:String"); } // 重载（非重写）
        @Override
        void m(Object o) { System.out.println("Sub:Object"); } // 重写
}
```

注意：
- 优先选择“更具体”的形参类型；若同为最具体，可能产生二义性。
- 重载分派在编译期确定，与对象“实际类型”无关。
- 可变参数优先级最低；必要时用显式强转或重构 API 避免歧义。


# 动态多态性（运行期多态：方法重写）

- 定义：子类提供与父类/接口“相同签名”的实现（可协变返回类型），调用时按对象“实际类型”进行动态分派。
- 重写规则：
    - 使用 @Override 校验签名正确。
    - 访问性不可变窄（可放宽），受检异常类型范围不可扩大。
    - final/private 方法不可被重写；static 方法是“隐藏”，不参与多态；字段不具备多态性（看引用类型）。
    - 可用 super 调用父类实现。

示例：典型运行期分派
```java
class Shape {
        double area() { return 0; }
}

class Circle extends Shape {
        double r;
        Circle(double r) { this.r = r; }
        @Override double area() { return Math.PI * r * r; }
}

class Rect extends Shape {
        double w, h;
        Rect(double w, double h) { this.w = w; this.h = h; }
        @Override double area() { return w * h; }
}

class Demo {
        public static void main(String[] args) {
                Shape s1 = new Circle(2);
                Shape s2 = new Rect(3, 4);
                System.out.println(s1.area()); // Circle.area
                System.out.println(s2.area()); // Rect.area

                Shape[] arr = { s1, s2 };
                for (Shape s : arr) System.out.println(s.area()); // 统一调用，按实际类型分派
        }
}
```

对比演示：重载是编译期决定，重写是运行期决定
```java
class Animal {}
class Dog extends Animal {}

class Dispatch {
        static void greet(Animal a) { System.out.println("Animal"); } // 重载 #1
        static void greet(Dog d)    { System.out.println("Dog"); }    // 重载 #2

        public static void main(String[] args) {
                Animal x = new Dog();
                greet(x); // 输出 "Animal"：选择在编译期按“引用静态类型”决定（重载）
        }
}
```

最佳实践与陷阱：
- 在可能被子类重写的方法中避免在构造函数里调用（对象可能尚未完全初始化）。
- 总是标注 @Override，避免“想重写却误成重载”的错误。
- 编程面向抽象（接口/抽象类）以利用多态；必要时使用 instanceof + 强转安全地下转：
```java
void printShape(Shape s) {
        if (s instanceof Circle c) {
                System.out.println("r=" + c.r);
        } else {
                System.out.println("area=" + s.area());
        }
}
```
- static/字段访问不具备运行期多态性；尽量用实例方法表达可变行为。
