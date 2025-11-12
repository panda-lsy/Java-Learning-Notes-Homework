package Chapter11;
/**
 * 奇数线程类 - Odd Number Thread Class
 * 任务：创建一个线程来打印1到20之间的奇数
 * Task: Create a thread to print odd numbers between 1 and 20
 */
class OddNumber extends Thread {
    /**
     * 步骤1：重写run方法，定义线程执行的任务
     * Step 1: Override the run method to define the thread's execution task
     */
    @Override
    public void run() {
        /**
         * 步骤2：使用for循环遍历1到20的奇数
         * Step 2: Use for loop to iterate through odd numbers from 1 to 20
         * i从1开始，每次增加2，生成奇数序列

         */

        /**
         * 步骤3：打印当前奇数
         * Step 3: Print the current odd number
         */
        for(int i=1;i<=20;i+=2){
            System.out.println("Odd number is: " + i);
        }
    }
}

/**
 * 偶数线程类 - Even Number Thread Class
 * 任务：创建一个线程来打印1到20之间的偶数
 * Task: Create a thread to print even numbers between 1 and 20
 */
class EvenNumber extends Thread {
    /**
     * 步骤1：重写run方法，定义线程执行的任务
     * Step 1: Override the run method to define the thread's execution task
     */
    @Override
    public void run() {
        /**
         * 步骤2：使用for循环遍历2到20的偶数
         * Step 2: Use for loop to iterate through even numbers from 2 to 20
         * i从2开始，每次增加2，生成偶数序列
         * i starts from 2 and increments by 2 each time, generating even
         number sequence
         */
        /**
         * 步骤3：打印当前偶数
         * Step 3: Print the current even number
         */
        for (int i=2;i<=20;i+=2){
            System.out.println("Even number is: " + i);
        }
    }
}

/**
 * 多线程演示类 - Multithreading Demo Class
 * 任务：创建并启动奇数线程和偶数线程
 * Task: Create and start odd number thread and even number thread
 */
public class Demo1 {
    /**
     * 主方法 - Main Method
     * 步骤1：创建奇数线程对象
     */
    public static void main(String[] args) {
        // 步骤1：创建奇数线程实例
        // Step 1: Create odd number thread instance
        OddNumber o1 = new OddNumber();
        // 步骤2：创建偶数线程实例
        EvenNumber e1 = new EvenNumber();

        // 步骤3：启动奇数线程（调用start()方法而不是run()方法）
        // Step 3: Start the odd number thread (call start() method instead of run())
        o1.start();

        // 步骤4：启动偶数线程
        // Step 4: Start the even number thread
        e1.start();

        /**
         * 注意：由于线程调度是由操作系统控制的，所以奇数偶数的打印顺序可能每次运行都不同
         * Note: Since thread scheduling is controlled by the operating
         system,
         * the printing order of odd and even numbers may vary each time you
         run the program
         */
    }
}
