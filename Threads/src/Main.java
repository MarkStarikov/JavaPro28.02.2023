public class Main {
    public static void main(String[] args) throws InterruptedException {
    int []temperatureSeptember = { 29, 11, 3, 25, 18, 13, 27, 24, 8};
    ThreadExample minimum = new ThreadExample(temperatureSeptember);
    ThreadExample maximum = new ThreadExample(temperatureSeptember);
    maximum.start();
    minimum.start();
    minimum.join();
    minimum.join();
        System.out.println(maximum.getMax());
        System.out.println(minimum.getMin());
    }

}
class ThreadExample extends Thread{
    private int []mass;
    private int max;
    private int min;

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public ThreadExample(int []mass){
        this.mass = mass;
    }

    public void run() {
        int min = mass[0];
        int max = mass[0];
        for (int i = 0; i < mass.length; i++) {
            if (min  > mass[i]) min = mass[i];
            if(max < mass[i]) max = mass[i];
        }
        this.max = max;
        this.min = min;
    }
}