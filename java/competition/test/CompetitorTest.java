package competition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompetitorTest {

    @Test
    public void testAddpoints(){
        Competitor comp = new Competitor ("diallo", 10);
        comp.addPoints(2);
        assertEquals(12, comp.getPoints());
    }
}