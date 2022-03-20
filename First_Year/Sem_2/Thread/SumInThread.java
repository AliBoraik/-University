package Thread;

public class SumInThread extends Thread{
   private int[] arrey;
   private int left;
   private int right;
   private int sum;
   public SumInThread(int[] array,int left,int right){
      this.arrey=array;
      this.left=left;
      this.right=right;
   }

   @Override
   public void run() {
      sum = 0;
      for (int i = left; i <= right; i++) {
         sum += arrey[i];
      }
   }
   public int getSum(){
      return sum;
   }
}
