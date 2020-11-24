package hw1.pt1;

class TimerSpecial implements Runnable {

    private String name;

    ThreadTimer timer;

    public TimerSpecial(ThreadTimer timer, String name) {
        this.timer = timer;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (timer) {
            while (true) {
                try {
                    timer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (timer.getTime() % 5 == 0) {
                    System.out.println("Thread name = " + name + " Прошло 5 секунд: время:" + timer.getTime());
                }
                System.out.println("Thread name = " + name + " Прошла 1 секунда: время:" + timer.getTime());

            }
        }
    }
}
