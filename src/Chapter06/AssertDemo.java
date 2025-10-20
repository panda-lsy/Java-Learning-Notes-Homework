package Chapter06;

public class AssertDemo {
    public static void main(String[] args) {
        int age = -1;

        // Check if age is non-negative; fail if negative
        // 检查年龄是否为非负数；若为负则断言失败
        assert age >= 0 : "Age cannot be negative";
        // This assertion verifies that age is greater than 0
        // 此断言验证年龄大于0
        assert age > 0 : "Age must be greater than 0";
        // If age is negative, AssertionError will be thrown with the message
        // 如果年龄为负数，将抛出带有消息的AssertionError
        //assertion statement

        // 年龄不能为负数

        System.out.println("Age is: " + age);
        // 年龄是：
    }
}
