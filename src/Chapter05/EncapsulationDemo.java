package Chapter05;

import java.util.Scanner;

class BankAccount {
    // Step 1: Make data private (hidden from outside world) 第 1 步：将数据设为私有（隐藏于外部世界）
    // Private means these variables can only be accessed within this class 私有意味着这些变量只能在类内部访问
    // No other class can directly read or modify these variables 其他类不能直接读取或修改这些变量
    private final String accountNumber;
    private String password;

    // Constructor - used to create objects and initialize private variables 构造函数 - 用于创建对象和初始化私有变量
    // This is the only place where we can directly set the initial values 这是我们唯一可以直接设置初始值的地方
    public BankAccount(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    // Step 2: Provide GETTER methods for controlled read access 第 2 步：提供 GETTER 方法以实现受控的读取访问
    // Getter methods allow other classes to READ private variables safely GETTER 方法允许其他类安全地读取私有变量
    // Getter for account number - allows reading but not modifying 账号 GETTER - 允许读取但不允许修改
    // This is a public method that returns the private accountNumber 这是一个公开的方法，用于返回私有账户号码
    // Other classes can call this method to get the account number  其他类可以调用此方法来获取账户号码
    public String getAccountNumber() {
        // Important: We do NOT provide a setter for account number 重要：我们不提供账户号码的设置器
        // This means once an account is created, its number cannot be changed 这意味着一旦创建了一个账户，其编号就不能更改
        // This provides security - account numbers should be permanent 这提供了安全性——账户编号应该是永久的
        return accountNumber;
        // Important: We do NOT provide a getter for password 重要：我们不提供密码的获取器
        // This means no other class can ever read the password 这意味着其他任何类都无法读取密码
        // The password remains completely hidden and secure 密码保持完全隐藏和安全
    }
        // Step 3: Provide SETTER methods for controlled write access 第 3 步：提供 SETTER 方法以实现受控的写访问
        // Setter methods allow other classes to MODIFY private variables safely -  SETTER 方法允许其他类安全地修改私有变量

        // Setter for password - allows changing password with validation 密码的 SETTER - 允许在验证后更改密码
        // This method provides controlled access to modify the private password 此方法提供对修改私有密码的受控访问
        // We can add rules and validation before allowing the change 我们可以在允许更改之前添加规则和验证
    public void setPassword(String newPassword,String inputPassword) {
        // Validation: Check if new password meets security requirements 验证：检查新密码是否符合安全要求

        // Only if validation passes, we update the private password 只有验证通过时，我们才更新私有密码
        if (checkPassword(inputPassword)){
            this.password = newPassword;
        }else{
            System.out.println("Wrong Old Password!");
        }
        // If validation fails, we reject the change and show error message 如果验证失败，我们拒绝更改并显示错误信息

    }

    // Method to validate password without exposing it 验证密码的方法，不暴露密码
    // This method allows checking if a given password matches without revealing the actual password 此方法允许检查给定的密码是否匹配，而不透露实际密码
    // It returns true or false, but never shows the password itself 返回 true 或 false，但永远不会显示密码本身
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
        // Compare the input password with our private password 将输入密码与我们的私有密码进行比较
        // Return true if they match, false if they don't 如果匹配则返回 true，不匹配则返回 false
        // The actual password remains hidden throughout this process 实际密码在整个过程中都保持隐藏
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {

        // Create a bank account object 创建一个银行账户对象
        BankAccount b1 = new BankAccount("123456","hello@123");
        // Using getter to read account number 使用 getter 读取账号
        System.out.println(b1.getAccountNumber());
        // Checking password without seeing it  检查密码而不看到它
        Scanner sc = new Scanner(System.in);
        System.out.println("[Change Password]Input Old Password:");
        String inputPassword = sc.nextLine().trim();
        System.out.println("[Change Password]Input New Password:");
        String newPassword = sc.nextLine().trim();
        // Using setter to change password with validation 使用设置器更改密码并进行验证
        b1.setPassword(newPassword,inputPassword);
        // Verify password was changed 验证密码已更改

    }
}
