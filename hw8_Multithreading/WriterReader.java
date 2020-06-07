package hw8_Multithreading;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WriterReader extends Thread {
    public static void main(String[] args) {

        File file = new File("text.txt");
        if(!file.exists()) {
            System.out.println("File doesn't exist");
            System.exit(1);
        }

        ExecutorService exec = Executors.newCachedThreadPool();
        Buffer buffer = new Buffer();

        Writer writer = new Writer(file, buffer, exec);

        exec.execute(writer);
        exec.execute(new Reader(buffer));
        exec.execute(new Reader(buffer));
        exec.execute(new Reader(buffer));

    }
}

class Buffer {
    private String text;
    private boolean Reading = false;
    private boolean Writing = true;
    private int readersCount = 0;

    public synchronized void waitReaders() throws InterruptedException {
        while (Reading == true) {
            wait();
        }
    }

    public synchronized void waitWriter() throws InterruptedException {
        while (Writing == true) {
            wait();
        }
    }

    public synchronized void write(String text) {
        this.text = text;

        Writing = false;
        Reading = true;
        notifyAll();
    }

    public synchronized String read() {
        readersCount++;
        if (readersCount == 3) {
            readersCount = 0;
            Writing = true;
            Reading = false;
            notifyAll();
        }

        return text;
    }
}

class Reader implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static int total = 1;
    private int id;
    private String text;
    private Buffer buffer;

    Reader(Buffer buffer) {
        this.buffer = buffer;
        id = total++;
    }

    void read() {
        this.text = buffer.read();
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                buffer.waitWriter();
                read();
//                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(ANSI_GREEN + "Reader " + id + " reads: " + text + ANSI_RESET);

            }
        } catch (InterruptedException e) {
        }
        System.out.println("Reader " + id + " finished");
    }
}

class Writer implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    private Scanner scan;
    private String text;
    private Buffer buffer;
    private ExecutorService executor;

    Writer(File file, Buffer buffer, ExecutorService executor) {
        try {
            scan = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.buffer = buffer;
        this.executor = executor;
    }

    void write() {
        buffer.write(scan.nextLine());
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                if(scan.hasNext()) {
                    buffer.waitReaders();
                    write();
//                    TimeUnit.MILLISECONDS.sleep(200);
                    System.out.println(ANSI_RED + "Writer makes entry" + ANSI_RESET);
                }
                else {
                    buffer.waitReaders();
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
        }
        System.out.println("Writer finished");
        executor.shutdownNow();
    }
}