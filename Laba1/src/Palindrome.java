public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " Palindrome");
            }
            else {
                System.out.println(s + " Not Palindrome");
            }
        }
    }
    public static String reverseString(String s) {
        String revS = "";
        for (int i = s.length() -1; i >= 0; i--) {
            revS = revS + s.charAt(i);
        }
        return revS;
    }
    public static boolean isPalindrome(String s) {
        String s1 = "";
        s1 = reverseString(s);
        if (s.equals(s1)) {
            return true;
        }
        return false;
    }
}
