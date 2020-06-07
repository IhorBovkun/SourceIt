package hw8_Multithreading;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Spam extends Thread {
    private int[] intervals;
    private String[] messages;

    public Spam(int[] intervals, String[] messages){
        if(intervals.length != messages.length){
            throw new IllegalArgumentException("Lengths of arguments is unequal");
        }
        this.intervals = intervals;
        this.messages = messages;
    }

    public void run(){
        try {
            for (int i = 0; i < intervals.length; i++) {
                TimeUnit.MILLISECONDS.sleep(intervals[i]);
                System.out.println(messages[i]);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted by user");
        }
    }

    static class Runner extends Thread {
        Spam spam;
        public Runner(Spam spam) {
            this.spam = spam;
            setDaemon(true);
        }

        public void run() {
            try (InputStreamReader input = new InputStreamReader(System.in)){
                while (!spam.isInterrupted()) {
                    if (input.read() == '\n') {
                        spam.interrupt();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String[] messages = ("Создать класс Spam, который получает массив интервалов времени в миллисекундах").split(" ");
        int[] intervals = new int[messages.length];

        Random rand = new Random(47);
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = rand.nextInt(1_000);
        }

        Spam spam = new Spam(intervals,messages);
        Runner runner = new Runner(spam);

        spam.start();
        runner.start();
    }
}