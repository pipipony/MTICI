import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
    private final ConcurrentLinkedQueue<Product> products = new ConcurrentLinkedQueue<>();
    private final List<Loader> loaders = new ArrayList<>();
    public int maxWeight = 150;
    public Warehouse(List<Product> allProducts) {
        products.addAll(allProducts);
        for (int i = 1; i < 4; i++) {
            loaders.add(new Loader(i));
        }
    }
    public void startTransfer() {
        AtomicInteger workerIndex = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        while (!products.isEmpty()) {
            List<Product> batch = collectBatch();
            Loader loader = loaders.get(workerIndex.getAndIncrement() % loaders.size());
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> loader.carry(batch), executor);
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();
        System.out.println("Все партии доставлены.");
    }
    private List<Product> collectBatch() {
        List<Product> batch = new ArrayList<>();
        int currentWeight = 0;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (currentWeight + product.getWeight() <= maxWeight) {
                batch.add(product);
                currentWeight += product.getWeight();
                iterator.remove();
            }
            if (currentWeight >= maxWeight) break;
        }
        return batch;
    }
}
