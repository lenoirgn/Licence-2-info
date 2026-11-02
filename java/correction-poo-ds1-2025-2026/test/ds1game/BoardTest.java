package ds1game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import ds1game.tools.*;

public class BoardTest {

    private Board board;
    private Position centerPosition;

    @BeforeEach
    public void initBoard() {
        this.board = new Board(7, 9, "bear");
        this.centerPosition = new Position(this.board.nbColumns() / 2, this.board.nbRows() / 2);
    }

    @Test
    public void initializationIsOk() {
        assertEquals(9, this.board.nbColumns());
        assertEquals(11, this.board.nbRows());
        assertEquals(Tile.SEA, this.board.getTile(new Position(0, 0)));
        assertEquals("bear", this.board.getTile(new Position(4, 5)).getAnimal());
    }

    @Test
    public void oneCompatibleNeighbourReturnsFalseWhenNoValidNeighbours() {
        Tile t = new Tile(Land.SEA, "fox");
        assertFalse(this.board.oneCompatibleNeighbour(this.centerPosition.onLeft(), t));
    }

    @Test
    public void oneCompatibleNeighbourReturnsTrueWhenSameLandOrSameAnimal() {
        Tile center = this.board.getTile(this.centerPosition);
        Tile sameLand = new Tile(center.getLand(), "fox");
        Tile sameAnimal = new Tile(Land.SEA, center.getAnimal());
        assertTrue(this.board.oneCompatibleNeighbour(this.centerPosition.onLeft(), sameLand));
        assertTrue(this.board.oneCompatibleNeighbour(this.centerPosition.onLeft(), sameAnimal));
    }

    @Test
    public void playTileThrowsExceptionWhenPositionNotValid() {
        Tile tile = new Tile(Land.FOREST, "fox");
        assertThrows(InvalidPositionException.class, () -> this.board.playTile(tile, new Position(0, 5)));
        assertThrows(InvalidPositionException.class, () -> this.board.playTile(tile, new Position(5, 0)));
        assertThrows(InvalidPositionException.class, () -> this.board.playTile(tile, new Position(15, 5)));
        assertThrows(InvalidPositionException.class, () -> this.board.playTile(tile, new Position(5, 15)));
    }

    @Test
    public void playTileThrowsExceptionWhenPositionNotEmpty() {
        Tile tile = new Tile(Land.FOREST, "fox");
        assertThrows(InvalidPositionException.class, () -> this.board.playTile(tile, this.centerPosition));
    }

    @Test
    public void playTileThrowsExceptionWhenNoCompatibleNeighbour() {
        Tile tile = new Tile(Land.SEA, "fox");
        assertThrows(NoCompatibleNeighboursException.class, () -> this.board.playTile(tile, new Position(2, 2)));
        assertThrows(NoCompatibleNeighboursException.class, () -> this.board.playTile(tile, this.centerPosition.onLeft()));
    }

    @Test
    public void playTileOkWhenSameAnimal() throws Exception {
        Tile tile = new Tile(Land.FOREST, "bear");
        Position position = this.centerPosition.onLeft();
        this.board.playTile(tile, position);
        assertSame(tile, this.board.getTile(position));
    }

    @Test
    public void playTileOkWhenSameLand() throws Exception {
        Tile tile = new Tile(this.board.getTile(this.centerPosition).getLand(), "deer");
        Position position = this.centerPosition.onLeft();
        this.board.playTile(tile, position);
        assertSame(tile, this.board.getTile(position));
    }

}
