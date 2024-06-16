package Exam120224.Ex2;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Ex2_OggettiDiArte {

    private static Ex2_OggettiDiArte instance;
    private List<ArtPiece> artCollection;
    private int index;

    public final BiFunction<ArtPiece, ArtPiece, String>

    SUBSTITUTE = (artpiece1, artpiece2) -> {
        artCollection.set(artCollection.indexOf(artpiece1), artpiece2);
        return artpiece1 + " substituted with " + artpiece2;
    },

    SWAP = (artpiece1, artpiece2) -> {
        ArtPiece ap1 = artpiece1;
        int ap2Idx = artCollection.indexOf(artpiece2);
        artCollection.set(artCollection.indexOf(artpiece1), artpiece2);
        artCollection.set(ap2Idx, artpiece1);
        return artpiece1 + " Swapped with " + artpiece2 + "\n" +
                artpiece1 + "'s new Index: " + artCollection.indexOf(artpiece1) +
                "\n" + artpiece2 + "'s new Index: " + artCollection.indexOf(artpiece2);
    };

    private Ex2_OggettiDiArte() {}

    public Ex2_OggettiDiArte getInstance() {
        if (instance == null) instance = new Ex2_OggettiDiArte();
        return instance;
    }

    public void setArtCollection(List<ArtPiece> artCollection) {
        this.artCollection = artCollection;
        index = 0;
    }

    public ArtPiece next() {

        int artCollectionMaxIndex = artCollection.size()-1;

        if (index+1 >= artCollection.size()) System.out.println(
                "next element is Out of Bounds\nList maxIndex: " + artCollectionMaxIndex +
                        "\ncurrent index: " + index+1);

        return artCollection.get(index++);
    }

    public ArtPiece prev() throws IndexOutOfBoundsException {

        if (index-1 < 0) System.out.println(
                "next prev element is Out of Bounds\ncurrent index: " + Integer.toString(index-1));

        return artCollection.get(index--);
    }

    public void insert(ArtPiece artpiece) {artCollection.add(artpiece);}
    public void remove(ArtPiece artpiece) {artCollection.remove(artpiece);}

    public String modify(ArtPiece artpiece1, ArtPiece artpiece2, BiFunction<ArtPiece,
                                                                ArtPiece, String> function) {
        return function.apply(artpiece1, artpiece2);
    }

    public Map<String, List<ArtPiece>> getMappaGenereOggettiDiArte() {

        return artCollection.stream()
                .collect(Collectors.groupingBy(ArtPiece::getGenre));
    }

    public Map<Artist, List<ArtPiece>> getMappaArtistaOggettiDiArteNelPeriodo(int annoInizio, int annoFine) {

        return artCollection.stream()
                .filter(artpiece -> artpiece.getYear() >= annoInizio
                        && artpiece.getYear() <= annoFine)
                .collect(Collectors.groupingBy(ArtPiece::getArtist));
    }

    public List<ArtPiece> getArtCollection() {return artCollection;}
    public int getCurrentIndex() {return index;}
}
