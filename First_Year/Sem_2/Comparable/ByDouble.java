package Comparable;

public class ByDouble implements Comparable<Double>{
    double d;
    public ByDouble(Double d) {
      this.d=d;
    }
    @Override
    public int compareTo(Double o) {
        String toStringForFormat1=String.format("%1.4f",this.d);
        String toStringForFormat2=String.format("%1.4f",o);
        double d1=Double.parseDouble(toStringForFormat1);
        double d2=Double.parseDouble(toStringForFormat2);
        return Double.compare(d1, d2);
    }
}
