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
