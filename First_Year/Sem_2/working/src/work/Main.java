package work;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 /*
     Борейк Али Акиль Али
     Группа : 11-013
 */

public class Main {

    public static void main(String[] args) throws IOException {
        List<AllMovies> list = new ArrayList<>();
        readFromFiles(list);
        first(list);
        second(list);
        third(list);

    }

    private static void first(List<AllMovies> list) {
        String name = "";
        int year = 0000;
        List<ListMovie> movies=readMovie(name, year, list);
        for (int i = 0; i <movies.size() ; i++) {
            System.out.println(movies);
        }
    }

    private static List<ListMovie> readMovie(String name, int year, List<AllMovies> list) {
        List<ListMovie> listMovie = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getActor().getNameActors().equals(name) && list.get(i).getMovie().getRelease_year() == year) {
                listMovie.add(list.get(i).getListMovie());
            }
        }
        return listMovie;
    }

    private static void readFromFiles(List<AllMovies> list) throws IOException {
        String pathActorsFile="";
        String pathMovieFile="";
        String pathMovieDirector="";
        BufferedReader read1=new BufferedReader(new FileReader(pathActorsFile));
        BufferedReader read2=new BufferedReader(new FileReader(pathMovieFile));
        AllMovies movies=new AllMovies();
        Actors actors=new Actors();
        while (read1.ready()){
            String[] line=read1.readLine().split(",");
            actors.setNameActors(line[0]);
            ListMovie listMovie=readList(line[4],pathMovieDirector);
            movies.setActor(actors);
            movies.setListMovie(listMovie);
        }
        while (read2.ready()){
            String[] line=read1.readLine().split(",");
            Movie movie=new Movie();
            movie.setName(line[0]);
            movie.setRelease_year(Integer.parseInt(line[1]));
            movie.setIdDirector(Integer.parseInt(line[2]));
        }
    }

    private static ListMovie readList(String idActor, String pathList) throws IOException {
        ListMovie d=new ListMovie();

        BufferedReader read1=new BufferedReader(new FileReader(pathList));
        while (read1.ready()){
            String[] line=read1.readLine().split(",");
            if (Integer.parseInt(line[3])==Integer.parseInt(idActor)){
                d.setName(line[0]);
                d.setId(Integer.parseInt(line[0]));
                d.setIdActor(Integer.parseInt(line[3]));
            }
        }
        return d;
    }

    private static void second(List<AllMovies> list) {
        String actor="";
        String director="";
        List<Movie> moviesList;
        moviesList=jointFilms(actor,director,list);
        for (int i = 0; i <moviesList.size() ; i++) {
            System.out.println(moviesList);
        }
    }
    private static List<Movie> jointFilms(String actor, String director, List<AllMovies> list) {
        List<Movie> moviesList=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getActor().getNameActors().equals(actor)&&
                    list.get(i).getActor().getDirectorActors().getNameDirector().equals(director)){
                moviesList.add(list.get(i).getMovie());
            }
        }
        return moviesList;
    }

    private static void third(List<AllMovies> list) {
        String director="";
        int afterYear=0000;
        List<Actors> actorsList;
        actorsList=readActorsList(director,afterYear,list);
        for (int i = 0; i <actorsList.size() ; i++) {
            System.out.println(actorsList.get(i));
        }
    }

    private static List<Actors> readActorsList(String director, int afterYear,List<AllMovies> allMovies) {
        List<Actors> actorsList=new ArrayList<>();
        for (int i = 0; i <allMovies.size() ; i++) {
            if (allMovies.get(i).getMovie().getRelease_year()<afterYear){
                if (allMovies.get(i).getActor().getDirectorActors().getNameDirector().equals(director)){
                 actorsList.add(allMovies.get(i).getActor());

                }
            }
        }
        return actorsList;
    }
}
