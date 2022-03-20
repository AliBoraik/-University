package Exercise_Arreays;

import java.util.Arrays;

public class E5 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5, 7, 9, -2, 3};
        int[] newNumbers =new int[numbers.length];
        for (int i = 0,j=0,k= numbers.length-1; i < numbers.length; i++) {
            if (numbers[i]%2!=0){
                newNumbers[j]=numbers[i];
                j++;
            }else {
                newNumbers[k] = numbers[i];
                k--;
            }
        }
        System.out.println(Arrays.toString(newNumbers));
    }
}
