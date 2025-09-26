package Chapter01.Homework.Additional;

class Bank{
    String bankID; // 分支唯一ID
    String branchName; // 分支名称
    // 客户账户内部类
    static class CustomerAccount{
        String customerName;
        String accountNumber;
        String customerAddress;
        String customerPhoneNumber;
        String customerEmail;
        AccountType accountType; // 储蓄/活期
        double balance; // 账户余额
    }
    // 员工账户内部类
    static class EmployeeAccount{
        String employeeName;
        String employeeID;
        String employeeAddress;
        String employeePhoneNumber;
        String employeeEmail;
    }
    // 账户类型枚举
    enum AccountType {
        SAVINGS, CURRENT
    }
}

public class ServeYourMoney {
    public static void main(String[] args) {
        // 创建一个客户账户示例
        Bank.CustomerAccount customer = new Bank.CustomerAccount();
        customer.customerName = "张三";
        customer.accountNumber = "100200300";
        customer.customerAddress = "北京市朝阳区";
        customer.customerPhoneNumber = "13800000000";
        customer.customerEmail = "zhangsan@email.com";
        customer.accountType = Bank.AccountType.SAVINGS;
        customer.balance = 10000.0;

        // 创建一个员工账户示例
        Bank.EmployeeAccount employee = new Bank.EmployeeAccount();
        employee.employeeName = "李四";
        employee.employeeID = "E12345";
        employee.employeeAddress = "上海市浦东新区";
        employee.employeePhoneNumber = "13900000000";
        employee.employeeEmail = "lisi@email.com";
    }
}
