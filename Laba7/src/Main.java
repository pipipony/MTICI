public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int mid = arr.length / 2;
        SumCalculator firstHalf = new SumCalculator(arr, 0, mid);
        SumCalculator secondHalf = new SumCalculator(arr, mid, arr.length);
        firstHalf.start();
        secondHalf.start();
        //Thread.currentThread().interrupt();
        try {
            firstHalf.join();
            secondHalf.join();
        } catch (InterruptedException e) {
            System.out.println("Произошла ошибка. Поток был прерван.");
            e.printStackTrace();
        }
        int res = firstHalf.getResult() + secondHalf.getResult();
        System.out.println("Сумма элементов массива: " + res);
    }
}
