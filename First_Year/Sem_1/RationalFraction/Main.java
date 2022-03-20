package Exercises.RationalFraction;

public class Main {
    public static void main(String[] args) {
        RationalFraction re =new RationalFraction(15,25);
        RationalFraction test=new RationalFraction(3,7);
        re.reduce();
        RationalFraction add=re.add1(test);
        System.out.println(add);
        re.add2(3,7);
        RationalFraction sub=re.sub1(test);
        System.out.println(sub);
        re.sub2(3,7);
        RationalFraction multi=re.multi1(test);
        System.out.println(multi);
        re.multi2(3,7);
        RationalFraction vid=re.vid1(test);
        System.out.println(vid);
        re.vid2(3,7);
        System.out.println(re.value());
        System.out.println(re.equals(15, 25, 3, 4));
        System.out.println("целая часть дроби = "+re.numberPart(test));
    }
}
