package ClassTest.thread.test;

/**
 * @author hylu.ivan
 * @date 2022/5/4 下午1:56
 * @description
 */
public class ConcurrencyTest {

    /**
     * 更改循环次数测试并行和串行的效率，以下用例对应结果
     * 并行消耗时间 串行消耗时间
     *    1          0
     *    2          2
     *    6          8
     *    10         15
     *    62         114
     */
//    private static final long count = 10001;
//    private static final long count = 100001;
//    private static final long count = 1000001;
//    private static final long count = 10000001;
    private static final long count = 100000001;

    public static void main(String[] args) {
        concurrency();
        serial();
    }

    /**
     * 并发
     */
    public static void concurrency() {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a  = 0;
                for (int i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b  = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }

        long time = System.currentTimeMillis() - start;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("concurrent: " + time + "ms,b = " +b);
    }


    /**
     * 串行
     */
    public static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serival: " + time + "ms , b = "+b+",a = " + a);
    }
}
