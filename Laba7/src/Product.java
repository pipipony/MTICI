public class Product {
    private String name;
    private int weight;
    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return name + " (" + weight + " кг)";
    }
}
