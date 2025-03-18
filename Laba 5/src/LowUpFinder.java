import java.util.regex.*;

public class LowUpFinder {
    public static void main(String[] args) {
        lowUpFind("dddDпппПлллL");
        lowUpFind("llllllllllll");
    }

    public static void lowUpFind(String text) {
        StringBuilder temp = new StringBuilder();
        int lastMatchEnd = 0;
        boolean foundMatch = false;
        try {
            Pattern pattern = Pattern.compile("([a-z]|[а-я])([A-Z]|[А-Я])");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                temp.append(text, lastMatchEnd, matcher.start());
                temp.append("!").append(matcher.group()).append("!");
                lastMatchEnd = matcher.end();
                foundMatch = true;
            }

            if (!foundMatch) System.out.println("Совпадений не найдено");

        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Ошибка состояния: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Входные данные не должны быть null.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса: " + e.getMessage());
        }
        System.out.println(temp.toString());
    }
}



