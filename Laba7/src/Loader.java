import java.util.List;

public class Loader {
    private int id;
    public Loader(int id) {
        this.id = id;
    }
    public void carry(List<Product> products) {
        System.out.println("Грузчик " + id + " начинает перенос товаров: " + products +
                " в потоке " + Thread.currentThread().getName());
        System.out.println("Грузчик " + id + " завершил перенос товаров: " + products);
    }
}
