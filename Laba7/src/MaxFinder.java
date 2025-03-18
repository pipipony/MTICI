public class MaxFinder extends Thread {
    private int[] row;
    private int max;
    public MaxFinder(int[] row) {
        this.row = row;
    }
    @Override
    public void run() {
        max = row[0];
        System.out.println("Поток " + Thread.currentThread().getName() + " начал выполнение");
        for (int num : row) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " завершил выполнение");
    }
    public int getMax() {
        return max;
    }
}
