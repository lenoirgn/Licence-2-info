

public class CompteMain{
    public static void main(String[] args) throws InsufficientBalanceException {
        Compte comp =new Compte("sow");
        comp.addSolde(100);
        try {
            comp.retrait(200);
            System.out.println("le nouveau solde est "+ comp.getSolde());
        } catch (InsufficientBalanceException e) {
            throw  new InsufficientBalanceException("solde insuffisant");
        }


    }
}