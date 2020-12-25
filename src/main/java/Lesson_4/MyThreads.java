package Lesson_4;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyThreads {
    static File file = new File("text.txt");

    public static void main(String[] args) {

        //Task 1
/*        Sequence sequence = new Sequence();
        new Thread(new ThreadShowCHar(sequence, 'A')).start();
        new Thread(new ThreadShowCHar(sequence, 'B')).start();
        new Thread(new ThreadShowCHar(sequence, 'C')).start();*/

        //Task 2
        writeFile();


    }


    public static void writeFile() {
        Object lock = new Object();
        WritebleFile wf = new WritebleFile();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    wf.writeToFIle("String" + Thread.currentThread().getName());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    wf.writeToFIle("String" + Thread.currentThread().getName());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    wf.writeToFIle("String" + Thread.currentThread().getName());
                }
            }
        }).start();


//        WritebleFile wf = new WritebleFile();
//        ThreadForFile tf1 = new ThreadForFile(wf, "thread_1");
//        ThreadForFile tf2 = new ThreadForFile(wf, "thread_2");
//        ThreadForFile tf3 = new ThreadForFile(wf, "thread_3");

    }


}
