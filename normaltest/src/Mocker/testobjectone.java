package Mocker;

public class testobjectone {
    public static void main(String[] args) throws InterruptedException {
        Thread[] ths = new Thread[3];
        for (int i = 0; i < 3; i++) {
            ths[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    //TODO Auto-generated method stub
                    for (int j = 0; j < 5; j++) {
                        System.out.println(j + ":"+ Thread.currentThread().getName());
                    }
                    System.out.print(" ");
                }
            });
        }
        for (Thread thread : ths) {
            thread.start();
        }
        Thread.sleep(20000);
    }
}
