package Lesson_4.MFU;

public class MFU {
    Object lockPrint;
    Object lockScan;
    int countPrint;
    int countScan;

    public MFU() {
        lockPrint = new Object();
        lockScan = new Object();
        countPrint = 0;
        countScan = 0;
    }


    public void print(String user) {
        synchronized (lockPrint) {
            System.out.println(user + " напечатал страницу. Всего отпечатано: " + (++countPrint));
        }
    }


    public void scan(String user) {
        synchronized (lockScan) {
            System.out.println(user + " отсканировал страницу. Всего отпечатано: " + (++countScan));
        }
    }


}
