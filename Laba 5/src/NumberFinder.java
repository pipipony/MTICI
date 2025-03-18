import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        findNumber("это какая-то строка e46 с цифрами 345 и 71.1 и -45.111");
        findNumber("это какая-то строка без цифр");

    }

    public static void findNumber(String text) {
        boolean foundMatch = false;
        try {
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d*)?");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
                foundMatch = true;
            }
            if (!foundMatch) System.out.println("Числа не обнаружены");

        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Ошибка состояния: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Входные данные не должны быть null.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса: " + e.getMessage());
        }
    }
}


