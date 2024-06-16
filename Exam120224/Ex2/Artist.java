package Exam120224.Ex2;

public class Artist {

    private String name;
    int careerStart;
    int careerEnd;

    public Artist(String name, int careerStart, int careerEnd) {
        this.name = name;
        this.careerStart = careerStart;
        this.careerEnd = careerEnd;
    }

    public String getName() {return name;}
    public int getCareerStart() {return careerStart;}
    public int getCareerEnd() {return careerEnd;}

    @Override
    public String toString() {return name;}
}
