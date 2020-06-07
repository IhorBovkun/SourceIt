package hw8_Multithreading;

import java.util.concurrent.TimeUnit;

class ChildThread extends Thread implements Runnable{
    @Override
    public void run() {
        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new ChildThread();
        Thread thread2 = new Thread(new ChildThread());

        thread1.start();
        thread2.start();

        TimeUnit.SECONDS.sleep(5);

        thread1.interrupt();
        thread2.interrupt();
    }
}