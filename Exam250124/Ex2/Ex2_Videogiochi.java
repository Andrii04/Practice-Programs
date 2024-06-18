package Exam250124.Ex2;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex2_Videogiochi {

    private static Ex2_Videogiochi instance;
    private List<Videogame> videogameList;

    private Ex2_Videogiochi(List<Videogame> videogameList) {this.videogameList = videogameList;}

    public static Ex2_Videogiochi getInstance(List<Videogame> videogameList) {

        if (instance == null) instance = new Ex2_Videogiochi(videogameList);
        return instance;
    }

    public Iterator<Videogame> iterator() {return videogameList.iterator();}

    public void add(Videogame videogame) {videogameList.add(videogame);}
    public void remove(Videogame videogame) {videogameList.remove(videogame);}

    public void modify(Videogame videogame1, Videogame videogame2) {
        videogameList.set(videogameList.indexOf(videogame1), videogame2);
    }

    public Map<Platform, List<Videogame>> getMappaPiattaformaVideogiochi() {

        return videogameList
                .stream()
                .collect(Collectors.groupingBy(Videogame::getPlatform));
    }

    public Map<Integer, List<Videogame>> getAnnoVideogiochiDiUnaPiattaforma(Platform platform) {

        return videogameList
                .stream()
                .filter(videogame -> videogame.getPlatform().equals(platform))
                .collect(Collectors.groupingBy(Videogame::getYear));
    }

    public Set<String> getConversioniEPortings(String title) {

        return videogameList
                .stream()
                .filter(videogame -> videogame.getTitle().equals(title))
                .map(videogame -> videogame.getPlatform().getBitFormat().getBits() + "bit")
                .collect(Collectors.toSet());
    }
}
