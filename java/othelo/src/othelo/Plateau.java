package othelo;
public class Plateau{
    // le constructeur
    public Plateau(int longueur, int largeur){
        this.longueur = longueur;
        this.largeur = largeur;
        this.plateau = new Pion [longueur][largeur];
    }
    // les attributs
    private int longueur;
    private int largeur;
    private Pion[][] plateau;


    // Les methodes
    public void poserPion(Pion p, Position pos) throws InvalidPositionException {
        try {
            this.plateau[pos.getLigne()][pos.getColonne()] = p;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidPositionException();
        }
    }

    public void retirerPion(Position pos){
        try {
            this.plateau[pos.getLigne()][pos.getColonne()] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidPositionException();
        }
    }
    public boolean estVide(Position pos){
        return this.plateau[pos.getLigne()][pos.getColonne()]==null;
    }
    public Pion getPion(Position pos){
        return this.plateau[pos.getLigne()][pos.getColonne()];
    }


}