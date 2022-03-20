package Exercise_Arreays;

public class E2 {
    public static void main(String[] args) {
        int[] array=new int[]{1,2,-3,5,7};
        int sum=0;
        int product=1;
        for (int j : array) {
            sum += j;
            product *= j;
        }
        double average=(double)sum/5;
        System.out.println("The sum of elements = "+sum+" and product = "+product+" and average = "+average);
    }
}
