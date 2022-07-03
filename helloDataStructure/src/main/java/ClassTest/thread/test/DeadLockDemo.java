package ClassTest.thread.test;

/**
 * @author hylu.ivan
 * @date 2022/5/4 下午2:59
 * @description
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(B) {
                    synchronized(A) {
                        System.out.println("2");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
