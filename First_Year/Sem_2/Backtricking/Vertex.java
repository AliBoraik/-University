package Backtricking;
public class Vertex {
    int id;
    String value="";


    public Vertex(String label) {
        this.value = label;
    }

    public Vertex(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
