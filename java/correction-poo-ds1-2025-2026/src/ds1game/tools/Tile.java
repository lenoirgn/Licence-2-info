package ds1game.tools;

public class Tile {

    private Land land;
    private String animal;

    public static final Tile SEA = new Tile(Land.SEA,"shark");

    public Tile(Land land, String animal) {
        this.land = land;
        this.animal = animal;
    }

    public Land getLand() {
        return this.land;
    }

    public String getAnimal() {
        return this.animal;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof Tile other)) {
            return false;
        }
        return other.land == this.land && other.animal.equals(this.animal);
    }
}
