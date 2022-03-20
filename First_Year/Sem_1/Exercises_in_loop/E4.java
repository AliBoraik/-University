package Exercises_in_loop;

public class E4 {
    public static void main(String[] args) {
        //(2*N)*(2*N)


        int N=9;
        int sum=0;
        for (int i = 0; i <=N ;i++) {
            sum+=(N+i)*(N+i);
        }
        System.out.println(sum);
        System.out.println();


        //1.1*1.2*1.3
        int N2=9;
        double sum2=1.1;
        for (double i = 1; i <N2 ; i++) {
            sum2*=1+(i/10);
        }
        System.out.println(sum2);
    }
}
