package hw1.pt1;

import java.util.concurrent.TimeUnit;

class ThreadTimer implements Runnable {
    private int time = 0;
    private boolean parameter = false;

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setTime(time + 1);
        }
    }

    synchronized int getTime() {
        while (parameter) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return time;
    }

    synchronized void setTime(int t) {
        parameter = true;
        this.time = t;
        parameter = false;
        notifyAll();
    }
}


