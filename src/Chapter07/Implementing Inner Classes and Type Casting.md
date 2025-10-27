# 内部类

Java 中的内部类是在另一个类的内部定义的类，用于更好地封装和就近组织逻辑。

- 分类：成员内部类、静态内部类、方法局部内部类、匿名内部类
- 优点：增强封装、简化回调/事件、便于访问外部类成员

## 成员内部类

- 定义在外部类的成员位置，依附外部类实例，持有隐式的外部类引用 Outer.this
- 可访问外部类的所有成员（包括 private）
- 不能包含静态成员（除非是 static final 常量）

示例与创建方式：

```java
class Outer {
    private int x = 1;
    class Inner {
        void print() { System.out.println(x); } // 直接访问外部类成员
    }
    void use() { new Inner().print(); }
}

Outer outer = new Outer();
Outer.Inner inner = outer.new Inner(); // 需要外部类实例
inner.print();
```

注意：

- 在静态上下文中不能直接 new Inner()，必须先有外部类实例
- 容易导致泄漏：长生命周期的内部类实例会持有外部类引用

## 静态内部类

- 用 static 修饰，称为静态嵌套类，不依附外部类实例，不持有 Outer.this
- 可以包含静态成员
- 只能直接访问外部类的静态成员

示例与创建方式：

```java
class Outer {
    static int s = 10;
    static class Inner {
        static final String TAG = "Inner";
        void print() { System.out.println(s + " " + TAG); }
    }
}

Outer.Inner in = new Outer.Inner(); // 不需要外部类实例
in.print();
```

使用场景：

- 作为仅服务于外部类的“私有”辅助类型
- 避免隐式外部类引用以降低开销与泄漏风险

## 方法局部内部类

在方法内定义，作用域仅限该方法。可访问方法参数与局部变量，但它们必须是“有效 final”（effectively final）。

要点：

- 不能有访问修饰符，不能是 static
- 常用于临时封装小逻辑、回调或策略

示例：

```java
void foo() {
    int base = 3; // 有效 final
    class Local {
        void print() { System.out.println(base); }
    }
    new Local().print();
}
```

## 匿名内部类

- 没有名字的局部内部类，一次性实现接口或继承抽象类
- Java 8 起，若目标是函数式接口，优先使用 lambda

示例：

```java
Runnable r = new Runnable() {
    @Override public void run() { System.out.println("hi"); }
};

Runnable r2 = () -> System.out.println("hi"); // 推荐（函数式接口）
```

## 访问规则与 this 解析

- 访问外部类成员：Outer.this.member
- 解决同名遮蔽：

```java
class Outer { int v = 1;
    class Inner { int v = 2;
        void p(int v) {
            System.out.println(v);           // 形参
            System.out.println(this.v);      // Inner.v
            System.out.println(Outer.this.v);// Outer.v
        }
    }
}
```

## 类型转换（Type Casting）

- 上转型：内部类实现接口或继承父类时，可向上转为接口/父类
- 下转型：需配合 instanceof 检查
- 静态内部类与普通顶级类一样参与类型系统；成员内部类在语法上以 Outer.Inner 表示

示例：

```java
interface I { void f(); }
class Outer {
    class Impl implements I { public void f() {} }
    static class SImpl implements I { public void f() {} }
}

// 上转型
I i1 = new Outer().new Impl();
I i2 = new Outer.SImpl();

// 下转型（先判断）
if (i1 instanceof Outer.Impl impl) {
    impl.f();
}
if (i2 instanceof Outer.SImpl s) {
    s.f();
}

// 静态内部类的对象判断与强转
Object o = new Outer.SImpl();
if (o instanceof Outer.SImpl s) { s.f(); }
```

注意：

- 非静态内部类类型名为 Outer.Inner，创建时需外部类实例
- 成员内部类包含对外部类实例的隐式引用，序列化/缓存时需谨慎

## 编译产物与实践建议

- 编译后类名形如 Outer$Inner.class、Outer$1Local.class（方法局部/匿名内部类带序号）
- Android/长生命周期场景优先使用静态内部类，必要时改为弱引用
- 若仅供外部类使用且不暴露给外部，考虑设为 private/protected
- 能用 lambda 时尽量替代匿名内部类（函数式接口）
- 避免在内部类中持有不必要的大对象引用，减少泄漏风险
