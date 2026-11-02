package ds1game;

import ds1game.tools.*;

public class GameMain {

    public static void main(String[] args) {
        Board board = new Board(7,9,"turtle");
        Tile tile = new Tile( Land.FOREST, "turtle");
        Position randomPosition = board.randomPosition();
        try {
            board.playTile(tile, randomPosition );
            System.out.println(board.nbPoints());
        }
        catch(NoCompatibleNeighboursException e) {
            System.out.println("pose impossible, pas de voisin valide");
        }
        catch(InvalidPositionException e) {
            System.out.println("pose impossible, emplacement non vide"); // position nécessairement valide
        }

    }
}
