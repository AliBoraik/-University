package Working;

public class Director {
    private String nameDirector ;

    public String getNameDirector() {
        return nameDirector;
    }

    public void setNameDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }



    @Override
    public String toString() {
        return "Director{" +
                "nameDirector='" + nameDirector + '\'' +
                '}';
    }
}
