public class Primes {
    public static void main(String[] args) {
        for (int i = 3; i < 101; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isPrime(int n) {
        int counter = 0;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                counter+= 2;
                break;
            }
        }
        if ((int)Math.sqrt(n) * (int)Math.sqrt(n) == n){
            counter++;
        }
        if (counter == 0) {
            return true;
        }
        return false;
    }
}
