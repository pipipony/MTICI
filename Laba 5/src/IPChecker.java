import java.util.regex.*;

public class IPChecker {
    public static void main(String[] args) {
        checkIP("255.255.255.255");
        checkIP("abc.123.456.789");

    }

    public static void checkIP(String ip) {
        try {
            Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
            Matcher matcher = pattern.matcher(ip);

            if (matcher.find()) {
                System.out.println("IP адресс корректный");
            } else {
                System.out.println("Проверьте правильность ввода IP адреса");
            }
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


