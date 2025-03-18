public class SumCalculator extends Thread{
    private int[] arr;
    private int start;
    private int end;
    private int res;
    public SumCalculator(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        res = 0;
        for (int i = start; i < end; i++) {
            res += arr[i];
        }
    }
    public int getResult() {
        return res;
    }
}
