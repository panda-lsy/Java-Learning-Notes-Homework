package Chapter06;

class AgeException extends RuntimeException {
    // When someone creates: new AgeException()
    // 当有人创建：new AgeException()
    // This message will automatically be printed
    // 此消息将自动打印
    public AgeException(){
        super("Invalid age");
        System.out.println("Invalid age");
        // 无效年龄
        // Note: This only prints when exception is created, not when caught
        // 注意：这仅在创建异常时打印，而不是在捕获时
    }

    // Second constructor: Takes a custom error message as parameter
    // 第二个构造函数：将自定义错误消息作为参数
    // This is used when we want to give specific details about the age error
    // 当我们想要提供有关年龄错误的具体详细信息时使用
    public AgeException(String message) {
        // Pass the custom message to the parent RuntimeException class
        // 将自定义消息传递给父RuntimeException类
        // This stores the message in the exception object
        // 这会将消息存储在异常对象中
        super(message);
        // When caught, we can get this message using e.getMessage()
        // 当被捕获时，我们可以使用e.getMessage()获取此消息
    }
}


class AgeValidator {

    // Method to check if age is valid for voting
    // 检查年龄是否适合投票的方法
    void checkVotingAge(int age) {
        // Check if age is negative
        // 检查年龄是否为负数
        if (age < 0) {
            // Use custom message constructor for specific error details
            // 使用自定义消息构造函数获取特定的错误详细信息
            throw new AgeException("年龄不能为负数" + age);
            // 年龄不能为负数:
        }

        // Check if under voting age
        // 检查是否低于投票年龄
        if (age < 18) {
            // Use custom message to explain the requirement
            // 使用自定义消息解释要求
            throw new AgeException("投票年龄为18岁以上，但您只有" + age);
            // 投票年龄为18岁以上，但您只有:
        }

        // If all checks pass
        // 如果所有检查都通过
        System.out.println("Eligible for voting! Age: " + age);
        // 符合投票资格！年龄:
    }
}

class CustomizedExceptionDemo{
    public static void main(String[] args) {
        AgeValidator validator = new AgeValidator();

        // Test with negative age
        // 使用负数年龄测试
        try {
            validator.checkVotingAge(-1);
        } catch (AgeException e) {
            System.out.println("错误: " + e.getMessage());
        }

        // Test with underage
        // 使用未成年年龄测试
        // 错误:
        try {
            validator.checkVotingAge(16);
        } catch (AgeException e) {
            System.out.println("错误: " + e.getMessage());
        }

        // Test with valid age
        // 使用有效年龄测试
        try {
            validator.checkVotingAge(25);
        } catch (AgeException e) {
            System.out.println("错误: " + e.getMessage());
        }
    }
}