import java.util.regex.*;;

public class PasswordChecker {
    public static void main(String[] args) {
        check("dfdf23JdsfmA");
        check("12345!");
    }

    public static void check(String password) {
        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                System.out.println("Пароль введен корректно");
            } else {
                System.out.println("Пароль некорректен. Убедитесь, что он:");
                System.out.println("- Содержит от 8 до 16 символов.");
                System.out.println("- Содержит хотя бы одну заглавную букву.");
                System.out.println("- Содержит хотя бы одну цифру.");
                System.out.println("- Состоит только из латинских букв и цифр.");
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



