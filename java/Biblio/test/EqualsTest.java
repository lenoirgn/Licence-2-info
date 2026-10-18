import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EqualsTest{
    @Test
    public void areEquals(){
        Book b1=new Book("toto","la paix");
        Book b2=new Book("toto","la paix");
        assertTrue(b1.equals(b2));
    }

    @Test
    public void areNotEquals(){
        Book b1=new Book("toto","la paix");
        Book b2=new Book("toto2","la paix2");
        assertFalse(b1.equals(b2));

    }

}