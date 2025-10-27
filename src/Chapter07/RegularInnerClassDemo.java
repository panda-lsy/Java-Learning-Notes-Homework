package Chapter07;
/**
 * Car class - Outer class
 * 汽车类 - 外部类
 */
class Car {
    private String carName = "My Car";  // Private field of outer class
    // / 外部类的私有字段

    /**
     * Engine class - Inner class
     * 发动机类 - 内部类
     */


    class Engine {
        /**
         * Start engine method
         * 启动发动机方法
         */
        public void start() {
            // Inner class can directly access private members of outer class
            // 内部类可以直接访问外部类的私有成员
            System.out.println(carName);

        }
    }
}

/**
 * RegularInnerDemo - Demonstrating inner class usage
 * 测试类 - 演示内部类的使用
 */
public class RegularInnerClassDemo {
    public static void main(String[] args) {
        // Step 1: Create outer class object
        // 第一步：创建外部类对象
        class Outer {

            static class Inner {
                void talk() {
                    System.out.println("Talking");
                }
            }

            // Step 2: Create inner class object using outer class object
            // 第二步：通过外部类对象创建内部类对象
        }
        // Step 3: Call inner class method
        // 第三步：调用内部类的方法
        Outer.Inner inner = new Outer.Inner();
        inner.talk();
    }
}