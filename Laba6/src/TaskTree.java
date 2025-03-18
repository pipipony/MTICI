public class TaskTree {
    public static void main(String[] args) {
        Sales tracker = new Sales();
        Product apple = new Product("Яблоко", 50);
        Product apple1 = new Product("Яблоко", 70);
        Product banana = new Product("Банан", 30);
        Product orange = new Product("Апельсин", 40);
        tracker.addSale(apple);
        tracker.addSale(banana);
        tracker.addSale(apple);
        tracker.addSale(orange);
        tracker.addSale(apple);
        tracker.addSale(apple1);
        tracker.printSoldProducts();
        System.out.println("Общая сумма продаж: " + tracker.getTotalSalesAmount() + " руб");
        tracker.printMostPopularProduct();

        Sales sales = new Sales();
        sales.addSale(new Product("Хлеб", 50));
        sales.addSale(new Product("Молоко", 70));
        sales.addSale(new Product("Хлеб", 50));
        sales.addSale(new Product("Яблоки", 100));
        sales.addSale(new Product("Молоко", 70));
        sales.printSoldProducts();
        System.out.println("Общая сумма продаж: " + sales.getTotalSalesAmount() + " руб.");
        sales.printMostPopularProduct();
    }
}