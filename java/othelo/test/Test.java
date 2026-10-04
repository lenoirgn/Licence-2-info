import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Test{
    @Test
    public void poserPionvalide(){
        Plateau plat= new Plateau(3,3);
        Pion pion= new Pion (Couleur.NOIRE);
        Position pos= new Position (1,1);
        plat.poserPion(pion,pos);
        assertEquals(pion,plat.getPion(pos));

    }
}