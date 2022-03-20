package ExerciesFromAcmp;

public class Ex_1_DP {
    //В единственной строке входного файла INPUT.TXT записаны два натуральных числа K и N (1 ≤ K ≤ N ≤ 300).
    // К - максимальное количество ступенек,
    // которое может преодолеть заяц одним прыжком, N – общее число ступенек лестницы.
    public static void main(String[] args) {
        int k=2;
        int n=7;
        System.out.println(Bunny(k,n));

    }

    private static int Bunny(int k, int n) {
        int o=0;
        for (int i = 1; i <=k ; i++) {
            o+= helper(k,n);
        }
        return o;
    }

    private static int helper(int k, int n) {
        if (k==1)
            return 1;
        if (k==2)
            return 2;
        if (k==3)
            return 3;
        int l=(Bunny(k-1,n)+Bunny(k-2,n));
        return l;
    }
}
