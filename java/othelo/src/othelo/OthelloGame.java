package othello;
public class OthelloGame {
    //Les attributs
    private Player joueur1;
    private Player joueur2;
    private Plateau plateau;
    private Player joueurCourant;


    //Le constructeur
    public OthelloGame(){
        this.joueur1 = new Player(Couleur.NOIRE);
        this.joueur2 = new Player(Couleur.BLANCHE);
        this.joueurCourant = joueur1;
        this.plateau = new Plateau(8, 8);

    }
    //Les methodes
    public Plateau getPlateau(){
        return this.plateau;
    }
    public Player getJoueurCourant(){
        return this.joueurCourant;
    }
    public void changeJoueurCourant(){
        if (this.getJoueurCourant() == this.joueur1){
            this.joueurCourant = this.joueur2;
        }
        else{
            this.joueurCourant = this.joueur1;
        }
    }

    public boolean valide(Position p, Player j, direction d){
        
        return false
    }
}