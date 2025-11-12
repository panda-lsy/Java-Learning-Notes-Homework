package Chapter12.SerializationDemo;

import java.io.Serializable;

/**
 * User class representing a user with account credentials
 * 用户类，表示具有账户凭证的用户
 *
 * Implements Serializable to allow object serialization
 * 实现Serializable接口以支持对象序列化
 */
public class User implements Serializable {
    // Fixed serialVersionUID to prevent version mismatch during deserialization
    // 固定的序列化版本ID，防止反序列化时的版本不匹配问题
    private static final long serialVersionUID = -7364037216122078291L;

    private String account;    // User account name 用户账户名
    private String password;   // User password 用户密码
    private String email;      // User email address 用户邮箱地址

    /**
     * Constructor to initialize User object
     * 构造函数，初始化用户对象
     *
     * @param account  user account name 用户账户名
     * @param password user password 用户密码
     * @param email    user email address 用户邮箱地址
     */
    public User(String account, String password, String email) {
        this.account = account;
        this.password = password;
        this.email = email;
    }

    // Getter methods 获取方法
    public String getAccount() {
        return account;
    }

    public String getpassword() {
        return password;
    }

    public String getemail() {
        return email;
    }

    // Setter method for password 密码设置方法
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    // Note: Consider overriding toString() method for better object representation
    // 注意：建议重写toString()方法以便更好地表示对象
}
