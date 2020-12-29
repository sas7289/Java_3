package Lesson_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Race {
    private boolean winnerFlag;
    private final CyclicBarrier cyclicBarrier;
    private final CountDownLatch countDownLatchBegin;
    private final CountDownLatch countDownLatchEnd;
    private final Semaphore showWinnerSemaphore;
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(int carsCount, Stage... stages) {
        this.winnerFlag = false;
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.cyclicBarrier = new CyclicBarrier(carsCount);
        this.countDownLatchBegin = new CountDownLatch(carsCount);
        this.countDownLatchEnd = new CountDownLatch(carsCount);
        this.showWinnerSemaphore = new Semaphore(1);
    }

    public CountDownLatch getCountDownLatchBegin() {
        return countDownLatchBegin;
    }

    public CountDownLatch getCountDownLatchEnd() {
        return countDownLatchEnd;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    synchronized public boolean isWinnerFlag() {
        return winnerFlag;
    }

    synchronized public void setWinnerFlag(boolean winnerFlag) {
        this.winnerFlag = winnerFlag;
    }
}
