package Lesson_4;

import java.util.ArrayList;

public class Sequence {
    private final ArrayList<Character> sequence;

    public Sequence() {
        sequence = new ArrayList<>();
    }


    public void addChar(char ch) {
        switch (ch) {
            case 'A':
                addA();
            case 'B':
                addB();
            case 'C':
                addC();
        }
    }

    synchronized public void addA() {
        while (sequence.size() % 3 != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sequence.add('A');
        System.out.print('A');
        notify();
    }

    synchronized public void addB() {
        while (sequence.size() % 3 != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sequence.add('B');
        System.out.print('B');
        notify();
    }

    synchronized public void addC() {
        while (sequence.size() % 3 != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sequence.add('C');
        System.out.print('C');
        notify();
    }

}
