public enum Direction {
    N(-1, 0),
    NE(-1, 1),
    E(0, 1),
    SE(1, 1),
    S(1, 0),
    SW(1, -1),
    W(0, -1),
    NW(-1, -1);

    private final int deltaLigne;
    private final int deltaColonne;

    Direction(int deltaLigne, int deltaColonne) {
        this.deltaLigne = deltaLigne;
        this.deltaColonne = deltaColonne;
    }

    public int getDeltaLigne() {
        return this.deltaLigne;
    }

    public int getDeltaColonne() {
        return this.deltaColonne;
    }
}