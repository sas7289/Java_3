package Lesson_4;

import java.util.ArrayList;

public class MyThreads {

    public static void main(String[] args) {

        Sequence sequence = new Sequence();
        new Thread(new ThreadShowCHar(sequence, 'A')).start();
        new Thread(new ThreadShowCHar(sequence, 'B')).start();
        new Thread(new ThreadShowCHar(sequence, 'C')).start();


    }




}
