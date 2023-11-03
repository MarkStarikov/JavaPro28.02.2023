import java.util.Arrays;

public class Worker {
    public void rotate(int[] numbers, int k){
        k = k % numbers.length;
        reverse(numbers, 0, numbers.length-1);
        reverse(numbers, 0, k-1);
        reverse(numbers, k, numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }
    public void reverse(int[] numbers, int start, int end){
        while (start < end){
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }
}
