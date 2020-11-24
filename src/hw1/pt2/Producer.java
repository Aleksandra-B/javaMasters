package hw1.pt2;

class Producer implements Runnable {

    private Warehouse warehouse;

    Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            warehouse.delivery();
        }
    }
}