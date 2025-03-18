import java.util.Arrays;
import java.util.List;

public class ThirdTask {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Яблоки", 50),
                new Product("Бананы", 60),
                new Product("Мандарины", 40),
                new Product("Апельсины", 70),
                new Product("Груши", 30),
                new Product("Кокосы", 20),
                new Product("Хлеб", 80),
                new Product("Молоко", 75),
                new Product("Сыр", 52),
                new Product("Кола", 20),
                new Product("Чай чёрный", 3),
                new Product("Мороженое", 85),
                new Product("Йогурт", 38),
                new Product("Печенье", 24),
                new Product("Сок", 125)
        );
        Warehouse warehouse = new Warehouse(products);
        warehouse.startTransfer();
    }
}
