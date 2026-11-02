package ds1game;

import ds1game.tools.Land;
import ds1game.tools.Position;
import ds1game.tools.Tile;

import java.util.Random;

public class Board {

    private static final int NB_POINTS_SAME_TILE = 3;
    private static final int NB_NEIGHBOURS = 4;
    
    private Tile[][] tiles;

    /**
     * construct a board : a board is surrounding with sea tiles.
     * It is assumed that nb columns and nb rows are odd (no check).
     * A first tile is put at the center of the board, with starting animal and
     * random Land.
     * 
     * @param nbColumns      nb of columns of the board (sea tiles excluded)
     * @param nbRows         nb of rows of the board (sea tiles excluded)
     * @param startingAnimal the animal on the starting center tile
     */
    public Board(int nbColumns, int nbRows, String startingAnimal) {
        this.tiles = new Tile[nbColumns + 2][nbRows + 2];
        this.tiles[this.nbColumns() / 2][this.nbRows() / 2] = new Tile(Land.random(), startingAnimal);
        this.initBorder();
    }

    public int nbColumns() {
        return this.tiles.length;
    }

    public int nbRows() {
        return this.tiles[0].length;
    }

    private void initBorder() {
        for (int column = 0; column < this.nbColumns(); column++) {
            this.tiles[column][0] = Tile.SEA;
            this.tiles[column][this.nbRows() - 1] = Tile.SEA;
        }
        for (int row = 0; row < this.nbRows(); row++) {
            this.tiles[0][row] = Tile.SEA;
            this.tiles[this.nbColumns() - 1][row] = Tile.SEA;
        }
    }

    public Tile getTile(Position p) {
        return this.tiles[p.getX()][p.getY()];
    }

    public void putTile(Position p, Tile tile) {
        this.tiles[p.getX()][p.getY()] = tile;
    }

    public boolean noTileAt(Position p) {
        return this.getTile(p) == null;
    }

    public Tile[] neighbourTiles(Position p) {
        Tile[] neighbours = new Tile[NB_NEIGHBOURS];
        neighbours[0] = this.getTile(p.above());
        neighbours[1] = this.getTile(p.below());
        neighbours[2] = this.getTile(p.onLeft());
        neighbours[3] = this.getTile(p.onRight());
        return neighbours;
    }

    public boolean positionIsValid(Position p) {
        return p.getX() > 0 && p.getX() < this.nbColumns() - 1
                && p.getY() > 0 && p.getY() < this.nbRows() - 1;
    }

    public int nbPoints() {
        int nbPoints = 0;
        for (int column = 1; column < this.nbColumns() - 1; column++) {
            for (int row = 1; row < this.nbRows() - 1; row++) {
                nbPoints = nbPoints + this.nbPoints(new Position(column, row));
            }
        }
        return nbPoints;
    }

    private int nbNeighboursWithSameLand(Position p) {
        if (this.noTileAt(p))
            return 0; // no Tile
        Tile currentTile = this.getTile(p);
        Tile[] neighbours = this.neighbourTiles(p);
        int nbNeighbours = 0;
        for (int i = 0; i < neighbours.length; i++) {
            if (neighbours[i].getLand() == currentTile.getLand()) {
                nbNeighbours = nbNeighbours + 1;
            }
        }
        return nbNeighbours;
    }

    private int nbNeighboursWithSameAnimal(Position p) {
        if (this.noTileAt(p))
            return 0; // no Tile
        Tile currentTile = this.getTile(p);
        Tile[] neighbours = this.neighbourTiles(p);
        int nbNeighbours = 0;
        for (int i = 0; i < neighbours.length; i++) {
            if (neighbours[i] != null && neighbours[i].getAnimal().equals(currentTile.getAnimal())) {
                nbNeighbours = nbNeighbours + 1;
            }
        }
        return nbNeighbours;
    }


    private int nbPoints(Position p) {
	if (this.noTileAt(p))
            return 0; // no Tile no point
        Tile currentTile = this.getTile(p);
        Tile[] neighbours = this.neighbourTiles(p);
        int nbPoints = Math.min(this.nbNeighboursWithSameAnimal(p), this.nbNeighboursWithSameLand(p));
        for (int i = 0; i < neighbours.length; i++) {
            if (neighbours[i] != null && neighbours[i].equals(currentTile)) {
                nbPoints = nbPoints + NB_POINTS_SAME_TILE;
            }
        }
        return nbPoints;
    }

    /**
     * returns true if there is a compatible tile for <code>tile</code> at position p.
     * A tile is compatible if it has same land or same animal.
     * @param p the position
     * @param tile the tile
     * @return true if there is a compatible tile.
     */
    public boolean oneCompatibleNeighbour(Position p, Tile tile) {
        Tile[] neighbours = this.neighbourTiles(p);
        for (int i = 0; i < neighbours.length; i++) {
            if (neighbours[i] != null && (neighbours[i].getLand() == tile.getLand()
                    || neighbours[i].getAnimal().equals(tile.getAnimal()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * play a tile at give position, there must at least one compatible neighbour at
     * the position, ie. one neighbour with same color or animal
     * 
     * @param tile the plaid tile
     * @param p    the plaid position
     * @throws InvalidPositionException   if p is not a valid position for the board
     *                                    or p "is not empty"
     * @throws NoCompatibleNeighboursException if there is no compatible neighbour at
     *                                    position
     */
    public void playTile(Tile tile, Position p) throws InvalidPositionException, NoCompatibleNeighboursException {
        if (!this.positionIsValid(p) || !this.noTileAt(p))
            throw new InvalidPositionException(p + " is not valid");
        if (!this.oneCompatibleNeighbour(p, tile))
            throw new NoCompatibleNeighboursException("no valid neighbour for " + tile + " at " + p);
        this.putTile(p,tile);
    }

    private static Random alea = new Random();

    /**
     * returns a randomly chosen valid position
     * 
     * @return a randomly chosen valid position
     */
    public Position randomPosition() {
        int randomValidColumn = 1 + alea.nextInt(this.nbColumns() - 2);
        int randomValidRow = 1 + alea.nextInt(this.nbRows() - 2);
        return new Position(randomValidColumn, randomValidRow);
    }

}
