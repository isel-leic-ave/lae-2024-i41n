package pt.isel;

public class ArtistLastFMJava {
    private String name;
    private String origin;

    public ArtistLastFMJava(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

//    public ArtistLastFMJava(String name) {
//        this(name, "Portugal");
//    }
//
//    public ArtistLastFMJava() {
//        this("", "Portugal");
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void xpto() {
        xpto("SLB", 10);
    }

    public void xpto(String a) {
        xpto(a, 10);
    }

    public void xpto(String a, int x) {

    }
}
