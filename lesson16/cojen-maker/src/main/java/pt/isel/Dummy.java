package pt.isel;

public class Dummy {
    final private int nr;

    public Dummy(int nr) {
        super();
        this.nr = nr;
    }

    public int mul(int other) {
        return this.nr * other;
    }
}
