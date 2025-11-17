package Chapter11;

// Step 1: Make a class that extends Thread
// 第一步：创建一个继承Thread的类
class NumberThread1 extends Thread {

    // Step 2: Make a constructor that takes a name
    // 第二步：创建一个接受名称的构造函数
    public NumberThread1(String name) {
        // Step 3: Call parent Thread constructor with the name
        // 第三步：使用名称调用父类Thread的构造函数
        super(name);
    }

    @Override
    public void run() {
        // Step 4: Make a loop from 0 to 10
        // 第四步：创建一个从0到10的循环
        for (int i = 0; i <= 10; i++) {
            try {
                // Step 5: Make the thread sleep for 1000 milliseconds (1second)
                // 第五步：让线程睡眠1000毫秒（1秒）
                Thread.sleep(1000);

                // Step 6: Print the thread name and current number
                // 第六步：打印线程名称和当前数字
                System.out.println(Thread.currentThread().getName() + ": " + i);

            } catch (InterruptedException e) {
                // Step 7: Handle if sleep is interrupted
                // 第七步：处理睡眠被中断的情况
                System.out.println("Sleep interrupted");
            }
        }
    }
}

public class Demo3 {
    public static void main(String[] args) {
        // Step 8: Create first thread with name "Thread1"
        // 第八步：创建名为"Thread1"的第一个线程
        NumberThread1 thread1 = new NumberThread1("Thread1");

        // Step 9: Create second thread with name "Thread2"
        // 第九步：创建名为"Thread2"的第二个线程
        NumberThread1 thread2 = new NumberThread1("Thread2");

        // Step 10: Create third thread with name "Thread3"
        // 第十步：创建名为"Thread3"的第三个线程
        NumberThread1 thread3 = new NumberThread1("Thread3");

        // Step 11: Start the first thread
        // 第十一步：启动第一个线程
        thread1.start();

        // Step 12: Start the second thread
        thread2.start();

        // Step 13: Start the third thread
        // 第十三步：启动第三个线程
        thread3.start();
    }
}