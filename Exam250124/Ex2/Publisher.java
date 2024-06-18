package Exam250124.Ex2;

public class Publisher {

    private String name;
    private int startDate;
    private String societyAddress;

    public Publisher(String name, int startDate, String societyAddress) {

        this.name = name;
        this.startDate = startDate;
        this.societyAddress = societyAddress;
    }

    @Override
    public String toString() {return name;}
}
