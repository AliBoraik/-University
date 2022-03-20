import java.io.*;

public class Radix_2_Algorithms_test {
    private static int numberOfLoops = 0;

    public static void main(String[] args) throws IOException {




        // getRandomNumber( from , to )

        // get number of matrices ( Random )
        int numberTheMatrices = getRandomNumber(50, 100);

        for (int i = 0; i < numberTheMatrices; i++) {
            // get number of size for each matrix
            int sizeOfMatrix = getRandomNumber(100, 10000);
            // read from file
            int[] arr = readTheMatrix(sizeOfMatrix);
            // get time for start
            long startTime = System.nanoTime();
            // Function Call for sort
            radixSort(arr, sizeOfMatrix);
            // get the difference between time
            long estimatedTime = System.nanoTime() - startTime;
            // print all info
            System.out.println("размер матрицы " + (i + 1) + " = " + sizeOfMatrix);
            System.out.println("наносекунды для матрица номер " + (i + 1) + " = " + estimatedTime);
            System.out.println("считающую итерации самого вложенного цикла номер" + (i + 1) + " = " + numberOfLoops + "\n");

            numberOfLoops = 0;

        }
    }

    private static int getRandomNumber(int from, int to) {
        int randomNum = (int) (Math.random() * to);
        while (randomNum < from || randomNum > to) {
            randomNum = (int) (Math.random() * to);
        }
        return randomNum;

    }

    // Radix Sort
    static void radixSort(int[] arr, int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number

        for (int exp = 1; m / exp > 0; exp *= 10) {
            numberOfLoops++;
            countSort(arr, n, exp);
        }

    }

    // A utility function to get maximum value in arr[]
    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            numberOfLoops++;
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            numberOfLoops++;
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            numberOfLoops++;
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++) {
            numberOfLoops++;
            arr[i] = output[i];
        }
    }

    public static int[] readTheMatrix(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            int randomNum = (int) (Math.random() * 100);
            numbers[i] = randomNum;
        }
        return numbers;
    }
}
