package Graph;

public class Edge<T>{
    public T top1;
    public T top2;

    public Edge(T top1, T top2) {
        this.top1 = top1;
        this.top2 = top2;
    }

    public T getTop1() {
        return top1;
    }

    public void setTop1(T top1) {
        this.top1 = top1;
    }

    public T getTop2() {
        return top2;
    }

    public void setTop2(T top2) {
        this.top2 = top2;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "top1=" + top1 +
                ", top2=" + top2 +
                '}';
    }
}
