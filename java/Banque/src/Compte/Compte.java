

public class Compte{
    private String name;
    private int solde;
    public  Compte(String name){
        this.name=name;
        this.solde=0;
    }
    public String getName(){
        return this.name;
    }
    public int getSolde(){
        return this.solde;
    }
    public void addSolde(int montant){
        this.solde=this.solde+montant;
    }
    public void retrait(int montant ) throws InsufficientBalanceException{
        if (this.solde<montant) {
            throw new InsufficientBalanceException("solde Insuffisant");
        }else{
            this.solde=this.solde-montant;
        }
    }
}