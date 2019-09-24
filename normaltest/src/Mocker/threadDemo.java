package Mocker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class threadDemo {
    static AtomicInteger cnt = new AtomicInteger(0);
    static ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        // thread.start();

//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//                threadMultle(i);
//            }
//        });
//        thread1.start();
        for (int i = 0; i < 100; i++) {
            threadMultle(i);
            threadOne();
            threadTwo();
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
                    if (i >= 95) {
                        String message = threadException();
                        hashMap.put("exception", message);
                    } else System.out.println(Thread.currentThread().getName() + ":" + i);
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        cnt.incrementAndGet();
    }

    public static void threadOne() {
        String combine = "this is";
        for (int i = 0; i < 15; i++) {
            String plan = ":" + i;
            combine += plan;
        }
        String finalCombine = combine;
        new Thread(() -> System.out.println(hashMap.put("no", finalCombine) + Thread.currentThread().getName())).start();
        cnt.incrementAndGet();
    }

    public static void threadTwo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Thread(() -> System.out.println("inner thread" + Thread.currentThread().getName())).start();
            }
        }).start();
        cnt.incrementAndGet();
    }

    public static String threadException() {
        String message = "";
        try {
            throw new Exception(message = "测试的异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}