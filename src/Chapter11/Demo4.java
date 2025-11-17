package Chapter11;

class OddNumber1 extends Thread {

    @Override
    public void run() {

        for(int i = 1; i <= 20; i += 2) {

            System.out.println("Odd number is: " + i);
        }
    }
}

class EvenNumber1 extends Thread {

    @Override
    public void run() {

        for(int i = 2; i <= 20; i += 2) {

            System.out.println("Even number is: " + i);
        }
    }
}

/**
 * 多线程演示类 - Multithreading Demo Class
 * 任务：使用join()方法确保先打印奇数后打印偶数
 * Task: Use join() method to ensure odd numbers print first, then even
 numbers
 */
public class Demo4 {

    public static void main(String[] args) {
        // 步骤1：创建奇数线程实例
        // Step 1: Create odd number thread instance
        OddNumber1 odd = new OddNumber1();

        // 步骤2：创建偶数线程实例
        // Step 2: Create even number thread instance
        EvenNumber1 even = new EvenNumber1();

        System.out.println("Before starting threads:");
        System.out.println("Odd thread alive: " + odd.isAlive());
        System.out.println("Even thread alive: " + even.isAlive());


        odd.start();

        // 步骤5：检查奇数线程启动后的状态
        // Step 5: Check odd thread status after starting
        System.out.println("After starting odd thread:");
        System.out.println("Odd thread alive: " + odd.isAlive());

        // 步骤6：使用join()等待奇数线程完成
        // Step 6: Use join() to wait for odd thread to finish
        try {
            System.out.println("Waiting for odd thread to finish...");
            odd.join(); // 等待奇数线程完成 wait for odd thread to complete
            System.out.println("Odd thread has finished!");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        // 步骤7：检查奇数线程完成后的状态
        // Step 7: Check odd thread status after completion
        System.out.println("After odd thread finished:");
        System.out.println("Odd thread alive: " + odd.isAlive());

        // 步骤8：启动偶数线程（此时奇数线程已经完成）
        // Step 8: Start even thread (now odd thread has finished)
        even.start();

        // 步骤9：检查偶数线程启动后的状态
        // Step 9: Check even thread status after starting
        System.out.println("After starting even thread:");
        System.out.println("Even thread alive: " + even.isAlive());

        // 步骤10：使用join()等待偶数线程完成
        // Step 10: Use join() to wait for even thread to finish
        try {
            System.out.println("Waiting for even thread to finish...");
            even.join(); // 等待偶数线程完成 wait for even thread to complete
            System.out.println("Even thread has finished!");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        // 步骤11：检查两个线程的最终状态
        // Step 11: Check final status of both threads
        System.out.println("Final status:");
        System.out.println("Odd thread alive: " + odd.isAlive());
        System.out.println("Even thread alive: " + even.isAlive());

        System.out.println("All threads completed!");
    }
}