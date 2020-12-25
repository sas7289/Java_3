package Lesson_4;

import java.io.File;

public class ThreadForFile implements Runnable{
    WritebleFile wf;
    String s;
    public ThreadForFile(WritebleFile wf, String s) {
        this.wf = wf;
        this.s = s;
    }


    @Override
    public void run() {
        wf.writeToFIle(s);
    }
}
