package poo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import poo.tools.Month;

public class DateTest {

  @Test
  public void fieldsAreCorrectAfterCreation() {
      Date d = new Date(30, Month.september,2024);
      assertEquals( 30, d.getDay());
      assertEquals( Month.september, d.getMonth());
      assertEquals( 2024, d.getYear());
  }

  @Test 
  public void testTomorrowWhenLastDayOfYear() {
      Date d2 = new Date(31, Month.december,2024);
      Date otherDate2 = d2.tomorrow();
      assertEquals(new Date(1, Month.january, 2025), otherDate2);
  }

  @Test 
    public void testTomorrowWhenLastDayOfMonth() {
    Date d1 = new Date(31, Month.january, 2024);
    Date d2 = new Date(1, Month.february, 2024);
    assertEquals(d2, d1.tomorrow());
  }

  @Test 
  public void testTomorrowNormalCase() {
    Date d1 = new Date(1, Month.april, 2017);
    Date d2 = new Date(2, Month.october, 2024);
    assertEquals(new Date(2, Month.april, 2017), d1.tomorrow());
    assertEquals(new Date(3, Month.october, 2024), d2.tomorrow());
  }

  @Test
	public void testTomorrowForLastDayOfFebruary() {
		// 28th of february and leap yer
		Date d1 = new Date(28, Month.february, 2020);
		// last of february and leap year
		Date d2 = new Date(29, Month.february, 2020);
		// last of februay and not leap year
		Date d3 = new Date(28, Month.february, 2021);
		//
		assertEquals(new Date(29, Month.february, 2020), d1.tomorrow());
		assertEquals(new Date(1, Month.march, 2020), d2.tomorrow());
		assertEquals(new Date(1, Month.march, 2021), d3.tomorrow());
	}

	@Test
	public void testNbDaysAfterWhenNbDaysPositive() {
		Date d1 = new Date(1, Month.april, 2017);
		assertEquals(new Date(1, Month.april, 2017), d1.nbDaysAfter(0));
		assertEquals(new Date(1, Month.may, 2017), d1.nbDaysAfter(30));
		assertEquals(new Date(1, Month.april, 2018), d1.nbDaysAfter(365));
	}

	@Test
	public void testNbDaysAfterThrowsExceptionWhenNbDayIsNegative() {
		Date d = new Date(14, Month.july, 1789);
		d.nbDaysAfter(+2);
		assertThrows(IllegalArgumentException.class, () -> d.nbDaysAfter(-2));
	}

  @Test
  public void testEquals() {
    Date d1 = new Date(14, Month.july, 1789);
    Date d2 = new Date(14, Month.july, 1789);
    Date noteSameDay = new Date(15, Month.july, 1789);
    Date noteSameMonth = new Date(14, Month.may, 1789);
    Date noteSameYear = new Date(14, Month.july, 1889);
    assertTrue( d1.equals(d2) );
    assertFalse( d1.equals(noteSameDay) );
    assertFalse( d1.equals(noteSameMonth) );
    assertFalse( d1.equals(noteSameYear) );
  }

  @Test
  public void testIsLeapYear() {
    assertFalse(Date.isLeapYear(2014));
    assertFalse(Date.isLeapYear(2015));
    assertFalse(Date.isLeapYear(2100));
    
    assertTrue(Date.isLeapYear(2024));
    assertTrue(Date.isLeapYear(2000));      
  }
}
