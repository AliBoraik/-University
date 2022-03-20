package Working;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
 /*
     Борейк Али Акиль Али
     Группа : 11-013
 */

public class Main {

    public static void main(String[] args) throws IOException {
        List<AllMovies> list = new ArrayList<>();
        readFromFiles(list);
        // first
        String name="-----";
        int year=2021;
        first(list,name,year);
        // second
        String actor="----";
        String director="-----";
        second(list,actor,director);
        // third
        String directorName="-----";
        int afterYear=2021;
        third(list,directorName,afterYear);

    }

    private static void first(List<AllMovies> list,String name,int year) {
        // using the loops
        List<ListMovie> movies1=readMovie(name, year, list);
        // using the stream
        List<ListMovie> movies2=new ArrayList<>();
        list.stream().filter(AllMovies->AllMovies.getActor().getNameActors().equals(name)
                &&AllMovies.getMovie().getRelease_year()==year).forEach(AllMovies->movies2.add(AllMovies.getListMovie()));

        movies1.forEach(System.out::println);
        movies2.forEach(System.out::println);
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
        String pathListMovie="";
        String pathMovieFile="";
        BufferedReader read1=new BufferedReader(new FileReader(pathActorsFile));
        BufferedReader read2=new BufferedReader(new FileReader(pathMovieFile));
        // for all movies
        AllMovies movies=new AllMovies();
        Actors actors=new Actors();
        read1.readLine();
        while (read1.ready()){
            String[] line=read1.readLine().split(",");
            actors.setNameActors(line[0]);
            ListMovie listMovie=readList(line[4],pathListMovie);
            movies.setActor(actors);
            movies.setListMovie(listMovie);
        }
        read2.readLine();
        while (read2.ready()){
            String[] line=read1.readLine().split(",");
            Movie movie=new Movie();
            movie.setName(line[0]);
            movie.setRelease_year(Integer.parseInt(line[1]));
            movie.setIdDirector(Integer.parseInt(line[2]));
            movies.setMovie(movie);
        }
        read1.close();
        read2.close();
    }

    private static ListMovie readList(String idActor, String pathList) throws IOException {
        ListMovie d=new ListMovie();
        BufferedReader read1=new BufferedReader(new FileReader(pathList));
        while (read1.ready()){
            String[] line=read1.readLine().split(",");
            if (line[3].equals(idActor)){
                d.setName(line[0]);
                d.setId(Integer.parseInt(line[0]));
                d.setIdActor(Integer.parseInt(idActor));
            }
        }
        return d;
    }

    private static void second(List<AllMovies> list,String actor,String director) {
        // using loops
        List<Movie> moviesList1;
        moviesList1=jointFilms(actor,director,list);
        // using stream
        List<Movie> moviesList2=new ArrayList<>();
        list.stream().filter(AllMovies->AllMovies.getActor().getNameActors().equals(actor)
                &&AllMovies.getActor().getDirectorActors().getNameDirector().equals(director)).
                forEach(AllMovies->moviesList2.add(AllMovies.getMovie()));

        moviesList1.forEach(System.out::println);
        moviesList2.forEach(System.out::println);
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

    private static void third(List<AllMovies> list,String director,int afterYear) {
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
