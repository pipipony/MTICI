import java.util.*;

public class Sales {
    private TreeSet<Product> soldProducts;

    public Sales() {
        soldProducts = new TreeSet<>();
    }

    public void addSale(Product product) {
        Iterator<Product> iterator = soldProducts.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.equals(product)) {
                p.incrementSales();
                found = true;
                break;
            }
        }
        if (!found) {
            product.incrementSales();
            soldProducts.add(product);
        }
    }

    public void printSoldProducts() {
        System.out.println("Проданные товары:");
        Iterator<Product> iterator = soldProducts.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public double getTotalSalesAmount() {
        double total = 0;
        Iterator<Product> iterator = soldProducts.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            total += product.getPrice() * product.getSalesCount();
        }
        return total;
    }

    public void printMostPopularProduct() {
        Product mostPopular = null;
        int maxSales = 0;

        Iterator<Product> iterator = soldProducts.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getSalesCount() > maxSales) {
                mostPopular = product;
                maxSales = product.getSalesCount();
            }
        }

        if (mostPopular != null) {
            System.out.println("Самый популярный товар: " + mostPopular.getName() +
                    ", " + mostPopular.getPrice() + " руб., продано: " + mostPopular.getSalesCount());
        } else {
            System.out.println("Проданных товаров нет:(");
        }
    }
}