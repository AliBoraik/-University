package work;

public class Actors {
    private String nameActors ;
    private Director DirectorActors;

    public String getNameActors() {
        return nameActors;
    }

    public void setNameActors(String nameActors) {
        this.nameActors = nameActors;
    }


    public Director getDirectorActors() {
        return DirectorActors;
    }

    public void setDirectorActors(Director directorActors) {
        DirectorActors = directorActors;
    }

    @Override
    public String toString() {
        return "Actors{" +
                "nameActors='" + nameActors + '\'' +
                ", idDirectorActors=" + DirectorActors +
                '}';
    }
}
