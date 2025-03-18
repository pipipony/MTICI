import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Sonya\\IdeaProjects\\Laba6\\text.txt";
        File file = new File(filePath);
        Map<String, Integer> Words = new HashMap<>();
        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "и", "в", "на", "с", "по", "не", "за", "к", "о", "от", "до", "у", "то", "это", "а", "так", "как", "же", "что", "для", "во", "из", "но"
        ));

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zа-я]", "");
                if (!word.isEmpty() && !stopWords.contains(word)) {
                    Words.put(word, Words.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
            return;
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(Words.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println("Топ-10 самых часто встречающихся слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }
    }
}