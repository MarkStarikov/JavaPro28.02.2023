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