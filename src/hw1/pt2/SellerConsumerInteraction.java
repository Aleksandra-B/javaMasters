package hw1.pt2;

public class SellerConsumerInteraction {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
        Thread producer = new Thread(new Producer(warehouse));
        Thread customer = new Thread(new Customer(warehouse));

        producer.start();
        customer.start();
    }
}

