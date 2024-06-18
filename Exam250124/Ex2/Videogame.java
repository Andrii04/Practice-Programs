package Exam250124.Ex2;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Videogame {

    public enum gameGenre {

        PLATFORM("Platform"), SHOOTER("Shooter"), FIGHTING("Fighting"),
        BEAT_EM_UP("Beat'em up"), STEALTH("Stealth"), SURVIVAL("Survival"),
        RHYTHM("Rythm"), BATTLE_ROYALE("Battle Royale");

        private String genre;

        gameGenre(String genre) {this.genre = genre;}
    }

    private String title;
    private Publisher publisher;
    private int year;
    private Set<gameGenre> genres;
    private int playerCount;
    private Platform platform;

    private Videogame(String title, Publisher publisher, int year,
                     Set<gameGenre> genres, int playerCount, Platform platform) {

        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.genres =  genres;
        this.playerCount = playerCount;
        this.platform = platform;
    }

    public String getTitle() {return title;}
    public Publisher getPublisher() {return publisher;}
    public int getYear() {return year;}
    public Set<gameGenre> getGenres() {return genres;}
    public int getPlayerCount() {return playerCount;}
    public Platform getPlatform() {return platform;}

    @Override
    public String toString() {return title;}

    public static class VideogameBuilder {

        private String title;
        private Publisher publisher;
        private int year;
        private Set<gameGenre> genres;
        private int playerCount;
        private Platform platform;

        public VideogameBuilder() {genres = new HashSet<>();}

        public VideogameBuilder setTitle(String title) {this.title = title;
        return this;}
        public VideogameBuilder setPublisher(Publisher publisher) {this.publisher = publisher;
        return this;}
        public VideogameBuilder setYear(int year) {this.year = year;
        return this;}
        public VideogameBuilder addGenre(gameGenre genre) {genres.add(genre);
        return this;}
        public VideogameBuilder removeGenre(gameGenre genre) {genres.remove(genre);
        return this;}
        public VideogameBuilder setPlayerCount(int playerCount) {this.playerCount = playerCount;
        return this;}
        public VideogameBuilder setPlatform(Platform platform) {this.platform = platform;
        return this;}

        public Videogame build() throws InvalidParameterException {

            if (genres.size() == 0) throw new InvalidParameterException("Videogames must have at least 1 genre!");

            List<Object> nullParameters = Arrays.asList(title, publisher, year, playerCount, platform)
                    .stream()
                    .filter(parameter -> parameter.equals(null))
                    .collect(Collectors.toList());

            if (nullParameters.size() == 0) return new Videogame(title, publisher, year,
                                                                genres, playerCount, platform);

            throw new InvalidParameterException("1 or more Parameters missing!" +
                                                "\nMissing Parameters: " + nullParameters.toString());
        }
    }
}
