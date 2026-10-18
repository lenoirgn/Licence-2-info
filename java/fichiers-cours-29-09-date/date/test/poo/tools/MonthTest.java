package poo.tools;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class MonthTest {
    @Test
    public void testNext() {
        assertEquals( Month.february, Month.january.next());
        assertEquals( Month.january, Month.december.next());
    }

    @Test
    public void testNbOfDaysNotFebruary() {
        assertEquals( 31, Month.january.getNbOfDays(2024));
        assertEquals( 30, Month.june.getNbOfDays(2024));
    }

    @Test
    public void testNbOfDaysForFebruary() {
        assertEquals( 29, Month.february.getNbOfDays(2024));
        assertEquals( 28, Month.february.getNbOfDays(2025));
    }
}
