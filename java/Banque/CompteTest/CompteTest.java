import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CompteTest{
    @Test
    public void ajoutSoldeTest(){
        Compte comp=new Compte("sow");
        comp.addSolde(20);
   assertEquals(20,comp.getSolde());
    }
     @Test
    public void retraitSoldeTest(){
        Compte comp=new Compte("sow");
        comp.addSolde(20);
        assertThrows(InsufficientBalanceException.class, ()->{
            comp.retrait(120);
        });
    }
    @Test
public void retraitSoldeTestok() throws InsufficientBalanceException {
    Compte comp = new Compte("Sow");
    comp.addSolde(200);

    comp.retrait(50);

    assertEquals(150, comp.getSolde());
}
}