package ds1game.tools;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (! (o instanceof Position other)) {
            return false;
        }
        return other.x == this.x && other.y == this.y;
    }

    public Position above() {
        return new Position(this.x, this.y - 1);
    }
    public Position below() {
        return new Position(this.x, this.y + 1);
    }
    public Position onLeft() {
        return new Position(this.x - 1, this.y);
    }
    public Position onRight() {
        return new Position(this.x + 1, this.y);
    }

}
