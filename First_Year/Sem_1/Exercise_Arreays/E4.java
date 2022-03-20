package Exercise_Arreays;

public class E4 {
    public static void main(String[] args) {
        int[] Arya={1,3,1,7,0,9};
        int min=Arya[0];
        int max=Arya[0];
        for (int i=1;i< Arya.length;i++){
            max= Math.max(max, Arya[i]);
            min= Math.min(min, Arya[i]);
        }
        System.out.println("min "+min+" mix ="+ max);
//        int max=0;
//        int min=0;
//        for (int i = 0,j=1; i < Arya.length ; i++,j++) {
//            if (j < Arya.length) {
//                if (Arya[i] >= Arya[j]) {
//                    max = Arya[i];
//                    min = Arya[j];
//                } else {
//                    max = Arya[j];
//                    min = Arya[i];
//                }
//            }
//        }
//        System.out.println("max = "+max +" and min = "+ min);
    }
}
