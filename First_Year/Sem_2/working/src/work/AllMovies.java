package work;

public class AllMovies {
    private Actors Actor;
    private Movie movie;
    private ListMovie listMovie;

    public Actors getActor() {
        return Actor;
    }

    public void setActor(Actors actor) {
        Actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ListMovie getListMovie() {
        return listMovie;
    }

    public void setListMovie(ListMovie listMovie) {
        this.listMovie = listMovie;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "Actor=" + Actor +
                ", movie=" + movie +
                ", listMovie=" + listMovie +
                '}';
    }
}