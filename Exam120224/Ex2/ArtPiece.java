package Exam120224.Ex2;

public class ArtPiece {

    String name;
    Artist artist;
    int year;
    String genre;
    String location;
    String type;
    boolean inRestoration;

    protected ArtPiece(String name, Artist artist, int year, String genre,
                    String location, String type, boolean inRestoration) {

        this.name = name;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.location = location;
        this.type = type;
        this.inRestoration = inRestoration;

    }

    public enum ArtGenres {

        SCULTURA("Scultura"), PITTURA("Pittura"), AUDIO("Audio"),
        TESTO("Testo"), FOTOGRAFIA("Fotografia"), SPARTITO("Fotografia");

        private final String genre;
        ArtGenres(String genre) {this.genre = genre;}

        @Override
        public String toString() {return genre;}
    }

    public String getName() {return name;}
    public Artist getArtist() {return artist;}
    public int getYear() {return year;}
    public String getGenre() {return genre;}
    public String getLocation() {return location;}
    public String getType() {return type;}
    public boolean getInRestoration() {return inRestoration;}

    @Override
    public String toString() {return name + " by " + artist.getName();}

    public static class ArtPieceBuilder {

        String name;
        Artist artist;
        int year;
        String genre;
        String location;
        String type;
        boolean inRestoration;

        public ArtPieceBuilder setName(String name) {this.name = name;
        return this;}
        public ArtPieceBuilder setArtist(Artist artis) {this.artist = artist;
        return this;}
        public ArtPieceBuilder setYear(int year) {this.year = year;
        return this;}
        public ArtPieceBuilder setGenre(String genre) {this.genre = genre;
        return this;}
        public ArtPieceBuilder setLocation(String location) {this.location = location;
        return this;}
        public ArtPieceBuilder setType(String type) {this.type = type;
        return this;}
        public ArtPieceBuilder setInRestoration(boolean inRestoration) {this.inRestoration = inRestoration;
        return this;}

        public ArtPiece build() {return new ArtPiece(name, artist, year, genre, location ,type, inRestoration);}
    }
}
