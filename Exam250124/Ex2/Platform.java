package Exam250124.Ex2;

public abstract class Platform {

    public enum bitFormat {
        EIGHT_BIT(8), SIXTEEN_BIT(16), THIRTYTWO_BIT(32), SIXTYFOUR_BIT(64);
        private int bits;
        bitFormat(int bits) {this.bits = bits;}
        public int getBits() {return bits;}
    }

    private String name;
    private int releaseDate;
    private String producer;
    private bitFormat bits;
    private boolean mobile;

    public Platform(String name, int releaseDate, String producer, bitFormat bits, boolean mobile) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.producer = producer;
        this.bits = bits;
        this.mobile = mobile;
    }

    public String getName() {return name;}
    public int getReleaseDate() {return releaseDate;}
    public String getProducer() {return producer;}
    public bitFormat getBitFormat() {return bits;}
    public boolean getMobile() {return mobile;}


    @Override
    public String toString() {return producer + " " + name;}
}