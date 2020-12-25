package Lesson_4.MFU;

public class MFU {
    final Object lockPrint;
    final Object lockScan;
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
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void scan(String user) {
        synchronized (lockScan) {
            System.out.println(user + " отсканировал страницу. Всего отпечатано: " + (++countScan));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
