public class Main {
    public static void main(String[] args) throws InterruptedException {
        int []temperatureSeptember = { 29, 11, 3, 25, 18, 13, 27, 24, 8};
        ThreadExample minimum = new ThreadExample(temperatureSeptember);
        ThreadExample maximum = new ThreadExample(temperatureSeptember);
        minimum.start();
        maximum.start();
        minimum.join();
        minimum.join();
        System.out.println(maximum.getMax());
        System.out.println(minimum.getMin());
    }

}
