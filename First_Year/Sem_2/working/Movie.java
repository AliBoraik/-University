package Working;

public class Movie {
    private String name ;
    private int Release_year;
    private int idDirector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelease_year() {
        return Release_year;
    }

    public void setRelease_year(int release_year) {
        Release_year = release_year;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", Release_year=" + Release_year +
                ", idDirector=" + idDirector +
                '}';
    }
}
