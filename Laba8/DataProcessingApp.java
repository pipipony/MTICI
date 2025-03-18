import java.io.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private List<String> processedData = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String input) throws IOException {
        data = Files.readAllLines(Paths.get(input));
    }

    // Обрабатывает данные многопоточно
    public void processData() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<List<String>>> tasks = new ArrayList<>();

        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    tasks.add(() -> {
                        try {
                            List<String> result = (List<String>) method.invoke(processor, data);
                            return result;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        }

        // Собираем результаты обработки
        List<Future<List<String>>> futures = executor.invokeAll(tasks);
        processedData = futures.stream()
                .flatMap(future -> {
                    try {
                        return future.get().stream();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
        executor.shutdown();
    }

    public void saveData(String output) throws IOException {
        Files.write(Paths.get(output), processedData);
    }
}

class DataFilter {
    @DataProcessor
    public List<String> filterLongStrings(List<String> data) {
        return data.stream()
                .filter(line -> line.length() > 5)
                .collect(Collectors.toList());
    }
}

class DataTransformer {
    @DataProcessor
    public List<String> toUpperCase(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}

class DataAggregator {
    @DataProcessor
    public List<String> aggregate(List<String> data) {
        String aggregated = data.stream().collect(Collectors.joining(", "));
        return Collections.singletonList(aggregated);
    }
}

// Тестируем приложение
public class DataProcessingApp {
    public static void main(String[] args) {
        try {
            DataManager manager = new DataManager();

            // Регистрируем обработчики
            manager.registerDataProcessor(new DataFilter());
            manager.registerDataProcessor(new DataTransformer());
            manager.registerDataProcessor(new DataAggregator());

            // Загружаем данные
            String input = "input.txt";
            String output = "output.txt";
            manager.loadData(input);

            // Обрабатываем данные
            manager.processData();

            // Сохраняем результат
            manager.saveData(output);

            System.out.println("Результаты сохранены в файл: " + output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}