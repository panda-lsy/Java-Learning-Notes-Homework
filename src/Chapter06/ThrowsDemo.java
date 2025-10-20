package Chapter06;

public class ThrowsDemo {
    public static void checkAge(int age) {
        if (age < 0) {
// USING throw: Create exception object and throw it
// 使用 throw：创建异常对象并抛出它
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Must be 18 or older!");
        }
        System.out.println("Age is valid: " + age);
    }
    public static void main(String[] args) {
        try {
            checkAge(25);  // This works - 这个正常工作
            checkAge(-5);  // This throws exception - 这个抛出异常
        }
        catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}