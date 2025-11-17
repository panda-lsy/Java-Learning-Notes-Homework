package Chapter11;

/**
 * Simple thread class to demonstrate thread name and priority
 * 简单的线程类，演示线程名称和优先级
 */
class MyTask extends Thread {

    /**
     * Constructor to set thread name
     * 构造函数设置线程名称
     * @param name the name of the thread 线程名称
     */
    public MyTask(String name) {
        // Step 1: Call parent Thread constructor to set name
        // 步骤1：调用父类Thread构造函数设置名称
        super(name);
    }

    /**
     * Run method - thread execution code
     * Run方法 - 线程执行代码
     */
    public void run() {
        // Step 2: Print thread information
        // 步骤2：打印线程信息
        System.out.println("Thread Name: " + this.getName());
        System.out.println("Thread Priority: " + this.getPriority());

        // Step 3: Do some work in the thread
        // 步骤3：在线程中执行一些工作
        for (int i = 1; i <= 3; i++) {
            System.out.println(this.getName() + " counting: " + i);
            try {
                // Step 4: Small delay to see the execution order
                // 步骤4：小延迟以观察执行顺序
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " finished\n");
    }
}

/**
 * Demo class to show thread name and priority settings
 * 演示类，展示线程名称和优先级设置
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        // Step 1: Create threads with different names
        // 步骤1：创建具有不同名称的线程
        MyTask thread1 = new MyTask("High-Priority-Thread");
        MyTask thread2 = new MyTask("Normal-Priority-Thread");
        MyTask thread3 = new MyTask("Low-Priority-Thread");

        // Step 2: Set different priorities for threads
        // 步骤2：为线程设置不同的优先级
        thread1.setPriority(Thread.MAX_PRIORITY);    // Priority 10 优先级10
        thread2.setPriority(Thread.NORM_PRIORITY);   // Priority 5  优先级5
        thread3.setPriority(Thread.MIN_PRIORITY);    // Priority 1  优先级1

        // Step 3: Start all threads
        // 步骤3：启动所有线程
        thread1.start();
        thread2.start();
        thread3.start();

        // Step 4: Print main thread information
        // 步骤4：打印主线程信息
        System.out.println("Main Thread Name: " + Thread.currentThread().getName());
        System.out.println("Main Thread Priority: " + Thread.currentThread().getPriority());
    }
}