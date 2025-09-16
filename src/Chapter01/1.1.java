package Chapter01;

import java.util.Scanner; //用于从控制台获取输入
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); //创建Scanner对象
        System.out.println("Enter an integer:");
        int num=sc.nextInt(); //读取整数输入
        System.out.println("The integer you entered is: "+num);
    }
}
