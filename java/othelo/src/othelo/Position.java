package othelo;
public class Position {
    // Le constructeur
    public Position(int ligne, int colonne){
        this.ligne = ligne;
        this.colonne = colonne;
    }
    // Les attributs
    private int ligne;
    private int colonne;
    // Les methodes
    public int getLigne(){
        return this.ligne;
    }

    public int getColonne(){
        return this.colonne;
    }

    public Position neighbour(Direction direction) {
    return new Position(
        this.ligne + direction.getDeltaLigne(),
        this.colonne + direction.getDeltaColonne()
    );
}

    public Position sud(Position pos){
        return new Position(pos.getLigne()+1,pos.getColonne());
    }

    public Position sudEst(Position pos){
        return new Position(pos.getLigne()+1,pos.getColonne()+1);
    }
    public Position sudOuest(Position pos){
        return new Position(pos.getLigne()+1,pos.getColonne()-1);
    }
    public Position nord(Position pos){
        return new Position(pos.getLigne()-1,pos.getColonne());
    }
    public Position nordEst(Position pos){
        return new Position(pos.getLigne()+1,pos.getColonne()+1);
    }
    public Position nordOuest(Position pos){
        return new Position(pos.getLigne()-1,pos.getColonne()-1);
    }
    public Position est(Position pos){
        return new Position(pos.getLigne(),pos.getColonne()+1);
    }
    public Position ouest(Position pos){
        return new Position(pos.getLigne(),pos.getColonne()-1);
    }
    
    
    
}
