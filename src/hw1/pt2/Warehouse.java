package hw1.pt2;

class Warehouse {
    private int product = 0;

    synchronized void delivery() {
        while (product >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Поставка одного товара, товаров на складе: " + product);
        notify();
    }

    synchronized void shipment() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Отгрузка одного товара, товаров на складе: " + product);
        notify();
    }
}