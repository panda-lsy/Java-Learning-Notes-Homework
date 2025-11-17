package Chapter11;
/**
 * Inter-thread Communication Example - Even/Odd Number Checker 
 * 线程间通信示例 - 奇偶数检查器 
 *
 * This program demonstrates producer-consumer pattern where: 
 * - Producer creates numbers 
 * - Consumer checks whether number is EVEN or ODD 
 *
 * 该程序演示了生产者-消费者模式，其中： 
 * - 生产者生成数字 
 * - 消费者检查数字是偶数还是奇数 
 */

class SharedBox {
    int number;                    // The shared data between threads 线程间共享的数据
    boolean hasValue = false;      // Flag: True means box already has anumber 标志：true表示盒子中已有数字

    /**
     * Producer method - puts a number in the shared box 
     * 生产者方法 - 将数字放入共享盒子 
     *
     * @param value The number to be produced 要生产的数字 
     */
    synchronized void produce(int value) {
        // STEP 1: Check if box already has a value (consumer hasn't consumed yet)
        // 步骤 1: 检查盒子是否已有值（消费者尚未消费） 
        while (hasValue) {
            try {
                System.out.println("Producer waiting - box is full");
                // STEP 2: Wait for consumer to consume 
                // 步骤 2: 等待消费者消费 
                wait(); // Release lock and wait for consumer to consume 释放锁并等待消费者消费
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // STEP 3: Produce the number and put in box 
        // 步骤 3: 生产数字并放入盒子 
        number = value;
        hasValue = true;
        System.out.println("Produced: " + number);

        // STEP 4: Notify consumer that number is ready 
        // 步骤 4: 通知消费者数字已准备好 
        notify();
        System.out.println("Producer notified consumer");
    }

    /**
     * Consumer method - takes number from box and checks even/odd 
     * 消费者方法 - 从盒子中取出数字并检查奇偶性 
     */
    synchronized void consume() {
        // STEP 1: Check if box is empty (producer hasn't produced yet) 
        // 步骤 1: 检查盒子是否为空（生产者尚未生产） 
        while (!hasValue) {
            try {
                System.out.println("Consumer waiting - box is empty");
                // STEP 2: Wait for producer to produce 
                // 步骤 2: 等待生产者生产 
                wait(); // Release lock and wait for producer to produce 释放锁并等待生产者生产
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // STEP 3: Consume the number and perform logical operation 
        // 步骤 3: 消费数字并执行逻辑操作 
        if (number % 2 == 0)
            System.out.println("Consumed: " + number + " → Even Number");
        else
            System.out.println("Consumed: " + number + " → Odd Number");

        // STEP 4: Mark box as empty and notify producer 
        // 步骤 4: 标记盒子为空并通知生产者 
        hasValue = false;
        notify();
        System.out.println("Consumer notified producer");
    }
}

/**
 * Producer Thread Class 
 * 生产者线程类 
 *
 * Responsible for generating numbers and putting them in the shared box 
 * 负责生成数字并将其放入共享盒子 
 */
class Producer extends Thread {
    SharedBox box;  // Reference to shared box 对共享盒子的引用 

    // Constructor to initialize with shared box 
    // 构造函数，使用共享盒子初始化 
    Producer(SharedBox b) {
        box = b;
    }

    /**
     * Thread execution method - produces 5 numbers 
     * 线程执行方法 - 生产5个数字 
     */
    public void run() {
        // STEP 1: Loop to produce numbers 1 to 5 
        // 步骤 1: 循环生产数字1到5 
        for (int i = 1; i <= 5; i++) {
            // STEP 2: Call produce method with current number 
            // 步骤 2: 使用当前数字调用生产方法 
            box.produce(i);
            try {
                // STEP 3: Simulate production time 
                // 步骤 3: 模拟生产时间 
                Thread.sleep(400);
            }
            catch (InterruptedException e) {}
        }
        System.out.println("Producer finished producing all numbers");
    }
}

/**
 * Consumer Thread Class 
 * 消费者线程类 
 *
 * Responsible for taking numbers from box and checking even/odd 
 * 负责从盒子中取出数字并检查奇偶性 
 */
class Consumer extends Thread {
    SharedBox box;  // Reference to shared box 对共享盒子的引用 

    // Constructor to initialize with shared box 
    // 构造函数，使用共享盒子初始化 
    Consumer(SharedBox b) {
        box = b;
    }

    /**
     * Thread execution method - consumes 5 numbers 
     * 线程执行方法 - 消费5个数字 
     */
    public void run() {
        // STEP 1: Loop to consume 5 numbers 
        // 步骤 1: 循环消费5个数字 
        for (int i = 1; i <= 5; i++) {
            // STEP 2: Call consume method 
            // 步骤 2: 调用消费方法 
            box.consume();
            try {
                // STEP 3: Simulate consumption time 
                // 步骤 3: 模拟消费时间 
                Thread.sleep(400);
            }
            catch (InterruptedException e) {}
        }
        System.out.println("Consumer finished consuming all numbers");
    }
}

/**
 * Main Class - Program Entry Point 
 * 主类 - 程序入口点 
 */
public class EvenOddInterThread {

    /**
     * Main method - starts producer and consumer threads
     * 主方法 - 启动生产者和消费者线程
     */
    public static void main(String[] args) {
        // STEP 1: Create shared box object (shared resource) 
        // 步骤 1: 创建共享盒子对象（共享资源） 
        SharedBox box = new SharedBox();

        // STEP 2: Create producer thread with shared box reference 
        // 步骤 2: 使用共享盒子引用创建生产者线程 
        Producer p = new Producer(box);

        // STEP 3: Create consumer thread with shared box reference 
    // 步骤 3: 使用共享盒子引用创建消费者线程
        Consumer c = new Consumer(box);
    // STEP 4: Start producer thread
    // 步骤 4: 启动生产者线程
        p.start();
    // STEP 5: Start consumer thread
    // 步骤 5: 启动消费者线程
        c.start();
        System.out.println("Both producer and consumer threads started");
    }
}