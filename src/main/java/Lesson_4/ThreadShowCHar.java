package Lesson_4;


public class ThreadShowCHar implements Runnable {
    private Sequence sequence;
    private char ch;

    public ThreadShowCHar() {

    }

    public ThreadShowCHar(Sequence seq, char ch) {
        sequence = seq;
        this.ch = ch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sequence.addChar(ch);
        }
    }
}
