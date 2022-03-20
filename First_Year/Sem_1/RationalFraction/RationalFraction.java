package Exercises.RationalFraction;


public class RationalFraction {
    private int numerator;
    private int denominator;

  public RationalFraction (){
      this.numerator=0;
      this.denominator=0;

  }

    public RationalFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public void reduce(){
        for (int i =this.numerator; i >=1 ; i--) {
            if ((this.numerator%i==0)&&(this.denominator%i==0)){
                this.numerator/=i;
                this.denominator/=i;
            }
        }
    }


    public RationalFraction add1(RationalFraction rationalFraction){
        int num1=this.numerator*rationalFraction.denominator;
        int den=this.denominator*rationalFraction.denominator;
        int num2=this.denominator*rationalFraction.numerator;
        return new RationalFraction((num1+num2),den);
    }
    public  void add2(int numerator,int denominator){
        int num=this.numerator*denominator;
        int den=this.denominator*denominator;
        numerator*=this.denominator;
        num+=numerator;
        System.out.println(num+" / "+den);
    }
    public RationalFraction sub1(RationalFraction rationalFraction){
        int num1=this.numerator*rationalFraction.denominator;
        int den=this.denominator*rationalFraction.denominator;
        int num2=this.denominator*rationalFraction.numerator;
        return new RationalFraction((num1-num2),den);
    }
    public  void sub2(int numerator,int denominator){
        int num=this.numerator*denominator;
        int den=this.denominator*denominator;
        numerator*=this.denominator;
        num-=numerator;
        System.out.println(num+" / "+den);
    }
    public RationalFraction multi1(RationalFraction rationalFraction){
        int num=this.numerator*rationalFraction.numerator;
        int den=this.denominator*rationalFraction.denominator;
        return new RationalFraction(num,den);

    }
    public  void multi2(int numerator,int denominator){
        int num=this.numerator*numerator;
        int den=this.denominator*denominator;
        System.out.println(num+" / "+den);
    }
    public RationalFraction vid1(RationalFraction rationalFraction){
        int num=this.numerator*rationalFraction.denominator;
        int den=this.denominator*rationalFraction.numerator;
        return new RationalFraction(num,den);
    }
    public  void vid2(int numerator,int denominator){
        int num=this.numerator*denominator;
        int den=this.denominator*numerator;
        System.out.println(num+" / "+den);
    }
    public double value(){
      double value;
      value= (double)this.numerator/(double)this.denominator;
      return value;
    }
    public boolean equals(int numerator1,int denominator1,int numerator2,int denominator2) {
        for (int i = numerator1; i >= 1; i--) {
            if ((numerator1 % i == 0) && (denominator1 % i == 0)) {
                numerator1 /= i;
                denominator1 /= i;
            }
        }
            for (int i = numerator2; i >= 1; i--) {
                if ((numerator2 % i == 0) && (denominator2 % i == 0)) {
                    numerator2 /= i;
                    denominator2 /= i;
                }
            }
        return numerator1 == numerator2 && denominator1 == denominator2;
    }
    public int numberPart(RationalFraction rationalFraction){
        double value;
        value= (((double)rationalFraction.numerator/(double)rationalFraction.denominator));
        return (int) value;
    }

    @Override
    public String toString() {
        return "RationalFraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}