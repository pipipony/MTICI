public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int salesCnt;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.salesCnt = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getSalesCount() {
        return salesCnt;
    }

    public void incrementSales() {
        this.salesCnt++;
    }

    @Override
    public int compareTo(Product other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return name + " - " + price + " руб, продано: " + salesCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && price == product.price;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Double.hashCode(price);
    }
}