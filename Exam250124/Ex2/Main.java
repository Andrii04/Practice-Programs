package Exam250124.Ex2;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Videogame> videogames = new ArrayList<>();

        Publisher publisher1 = new Publisher("Publisher1", 1990, "Address1");
        Publisher publisher2 = new Publisher("Publisher2", 2000, "Address2");

        Platform platform1 = new MobilePlatform("Platform1", 2010, "Producer1", Platform.bitFormat.SIXTEEN_BIT);
        Platform platform2 = new ImmobilePlatform("Platform2", 2015, "Producer2", Platform.bitFormat.THIRTYTWO_BIT);

        try {
            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game1")
                    .setPublisher(publisher1)
                    .setYear(2020)
                    .addGenre(Videogame.gameGenre.PLATFORM)
                    .setPlayerCount(1)
                    .setPlatform(platform1)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game1")
                    .setPublisher(publisher1)
                    .setYear(2020)
                    .addGenre(Videogame.gameGenre.SHOOTER)
                    .setPlayerCount(2)
                    .setPlatform(platform2)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game2")
                    .setPublisher(publisher2)
                    .setYear(2018)
                    .addGenre(Videogame.gameGenre.FIGHTING)
                    .setPlayerCount(1)
                    .setPlatform(platform1)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game3")
                    .setPublisher(publisher1)
                    .setYear(2021)
                    .addGenre(Videogame.gameGenre.BEAT_EM_UP)
                    .setPlayerCount(3)
                    .setPlatform(platform2)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game4")
                    .setPublisher(publisher2)
                    .setYear(2019)
                    .addGenre(Videogame.gameGenre.STEALTH)
                    .setPlayerCount(4)
                    .setPlatform(platform1)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game5")
                    .setPublisher(publisher1)
                    .setYear(2020)
                    .addGenre(Videogame.gameGenre.SURVIVAL)
                    .setPlayerCount(2)
                    .setPlatform(platform2)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game6")
                    .setPublisher(publisher2)
                    .setYear(2017)
                    .addGenre(Videogame.gameGenre.RHYTHM)
                    .setPlayerCount(1)
                    .setPlatform(platform1)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game7")
                    .setPublisher(publisher1)
                    .setYear(2021)
                    .addGenre(Videogame.gameGenre.BATTLE_ROYALE)
                    .setPlayerCount(5)
                    .setPlatform(platform2)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game8")
                    .setPublisher(publisher2)
                    .setYear(2020)
                    .addGenre(Videogame.gameGenre.PLATFORM)
                    .setPlayerCount(2)
                    .setPlatform(platform1)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game9")
                    .setPublisher(publisher1)
                    .setYear(2016)
                    .addGenre(Videogame.gameGenre.SHOOTER)
                    .setPlayerCount(4)
                    .setPlatform(platform2)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game10")
                    .setPublisher(publisher2)
                    .setYear(2021)
                    .addGenre(Videogame.gameGenre.FIGHTING)
                    .setPlayerCount(3)
                    .setPlatform(platform1)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game11")
                    .setPublisher(publisher1)
                    .setYear(2020)
                    .addGenre(Videogame.gameGenre.BEAT_EM_UP)
                    .setPlayerCount(1)
                    .setPlatform(platform2)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game12")
                    .setPublisher(publisher2)
                    .setYear(2019)
                    .addGenre(Videogame.gameGenre.STEALTH)
                    .setPlayerCount(2)
                    .setPlatform(platform1)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game13")
                    .setPublisher(publisher1)
                    .setYear(2018)
                    .addGenre(Videogame.gameGenre.SURVIVAL)
                    .setPlayerCount(3)
                    .setPlatform(platform2)
                    .build());

            videogames.add(new Videogame.VideogameBuilder()
                    .setTitle("Game14")
                    .setPublisher(publisher2)
                    .setYear(2021)
                    .addGenre(Videogame.gameGenre.RHYTHM)
                    .setPlayerCount(1)
                    .setPlatform(platform1)
                    .build());
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }

        Ex2_Videogiochi ex2 = Ex2_Videogiochi.getInstance(videogames);

        Iterator<Videogame> ex2Iterator = ex2.iterator();
        System.out.println(ex2Iterator.next());
        System.out.println(ex2Iterator.next());
        System.out.println(ex2Iterator.next());


        System.out.println(ex2.getMappaPiattaformaVideogiochi());
        System.out.println(ex2.getAnnoVideogiochiDiUnaPiattaforma(platform1));
        System.out.println(ex2.getAnnoVideogiochiDiUnaPiattaforma(platform2));
        System.out.println(ex2.getConversioniEPortings("Game1"));
        System.out.println(ex2.getConversioniEPortings("Game6"));

    }
}

