package hw1.pt1;

public class TimerWith3Threads {

    public static synchronized void main(String[] args) {

        ThreadTimer timer = new ThreadTimer();
        new Thread(timer).start();

        TimerSpecial timer1 = new TimerSpecial(timer, "1");
        new Thread(timer1).start();

        TimerSpecial timer2 = new TimerSpecial(timer, "2");
        new Thread(timer2).start();

        TimerSpecial timer3 = new TimerSpecial(timer, "3");
        new Thread(timer3).start();

    }
}