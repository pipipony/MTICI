public class SecondTask {
    public static void main(String[] args) {
        int[][] matrix = {
                {13, 27, 3, 48},
                {53, 6, 37, 84},
                {95, 106, 101, 12},
                {13, 148, 105, 16},
                {126, 9883, 759, 20},
                {14, 3, -398, 29}
        };
        int rows = matrix.length;
        MaxFinder[] threads = new MaxFinder[rows];
        for (int i = 0; i < rows; i++) {
            threads[i] = new MaxFinder(matrix[i]);
            threads[i].start();
        }
        for (int i = 0; i < rows; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Произошла ошибка. Поток был прерван.");
                e.printStackTrace();
            }
        }
        int max = -2147483648;
        for (int i = 0; i < rows; i++) {
            if (threads[i].getMax() > max) {
                max = threads[i].getMax();
            }
        }
        System.out.println("Наибольший элемент в матрице: " + max);
    }
}
