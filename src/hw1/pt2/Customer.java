package hw1.pt2;

class Customer implements Runnable {


    private Warehouse warehouse;

    Customer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            warehouse.shipment();
        }
    }
}