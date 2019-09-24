package Mocker;

import java.util.concurrent.atomic.AtomicInteger;

public class threadDemo {
    static AtomicInteger cnt = new AtomicInteger(0);

    public static void main(String[] args) {

        // thread.start();

//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//                threadMultle(i);
//            }
//        });
//        thread1.start();
        for (int i = 0; i < 10; i++) {
            threadMultle(i);
        }
        System.out.println(cnt + "********************************************************************************************************");
    }

    public static void threadMultle(int i) {
//        new Thread(
//                () -> System.out.println(Thread.currentThread().getName() + ":" + i)
//        ).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (i >= 999) {
                        threadException();
                    } else System.out.println(Thread.currentThread().getName() + ":" + i);
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        cnt.incrementAndGet();
    }

    public static void threadException() {
        try {
            throw new Exception("测试的异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}