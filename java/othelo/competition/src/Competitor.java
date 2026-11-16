

public class Competitor{

    // Le constructeur
    public Competitor(String nom){
        this.nom = nom;
        this.nbPoints = 0;
    }

    // Les attributs
    private String nom;
    private int nbPoints;

    //les methodes
    public String getName(){
        return this.nom;
    }

    public int getPoints(){
        return this.nbPoints;
    }

    public boolean Equals(Object o){
        if (!(o instanceof Competitor)){
            return false;
        }
        Competitor other = (Competitor) o;
        return this.nom.equals(other.nom) && this.nbPoints == other.nbPoints;
    }

    public void addpoints(int n){
        this.nbPoints = this.nbPoints + n;
    }

    public String toString(){
        return "Competitor( "+ this.nom + "," + this.nbPoints + " )";
    }
}