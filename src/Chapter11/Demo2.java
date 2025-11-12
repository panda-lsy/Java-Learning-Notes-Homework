package Chapter11;
// Step 1: Make a class for even numbers that uses Runnable interface 
// 第一步：创建一个用于偶数的类，使用Runnable接口 
class Even1 implements Runnable {
    @Override
    public void run() {
        // Step 2: Make a loop that goes 2,4,6,8...20 
        // 第二步：创建一个循环，输出2,4,6,8...20 
        for (int i=2;i<=20;i+=2){
        // Step 3: Print each even number
        // 第三步：打印每个偶数
        System.out.println("Even Number is:" + i);
        }
    }
}

// Step 4: Make a class for odd numbers that uses Runnable interface 
// 第四步：创建一个用于奇数的类，使用Runnable接口 
class Odd1 implements Runnable {
    @Override
    public void run() {
        // Step 5: Make a loop that goes 1,3,5,7...19 
        // 第五步：创建一个循环，输出1,3,5,7...19 
        for (int i=1;i<=20;i+=2){
        // Step 6: Print each odd number
        // 第六步：打印每个奇数
        System.out.println("Odd Number is:" + i);
        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        // Step 7: Create the even number task object 
        // 第七步：创建偶数任务对象 
        Even1 even1 = new Even1();

        // Step 8: Create the odd number task object 
        // 第八步：创建奇数任务对象 
        Odd1 odd1 = new Odd1();

        // Step 9: Make a Thread for even numbers 
        // 第九步：为偶数创建一个线程 
        // We pass the even1 object to Thread constructor 
        // This tells the thread what work to do 
        // 我们将even1对象传递给Thread构造函数 
        // 这告诉线程要做什么工作 
        Thread thread1 = new Thread(even1);

        // Step 10: Make a Thread for odd numbers 
        // 第十步：为奇数创建一个线程 
        // We pass the odd1 object to Thread constructor 
        // This tells the thread what work to do 
        // 我们将odd1对象传递给Thread构造函数 
        // 这告诉线程要做什么工作 
        Thread thread2 = new Thread(odd1);
        // Step 11: Start the even number thread 
        // 第十一步：启动偶数线程 
        thread1.start();

        // Step 12: Start the odd number thread 
        // 第十二步：启动奇数线程 
        thread2.start();
    }
} 