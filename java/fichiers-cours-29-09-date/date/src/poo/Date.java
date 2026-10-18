package poo;

import poo.tools.*;

/**
 * Date based on ( day, month, year )
 */
public class Date {
    private int day;
    private Month month;
    private int year;

    /**
     * Build a Date from day, month and year
     * 
     * @param day   the day oth this date
     * @param month the month of this date
     * @param year  the year of this date
     */
    public Date(int day, Month month, int year) {
        // no validity check
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * the day for this date
     * 
     * @return the day for this date
     */
    public int getDay() {
        return day;
    }

    /**
     * the month for this date
     * 
     * @return the month for this date
     */

    public Month getMonth() {
        return month;
    }

    /**
     * the year for this date
     * 
     * @return the year for this date
     */
    public int getYear() {
        return this.year;
    }

    /**
     * two dates are equals iff they have same day, moth and year
     * @param o the object with which to compare
     * @see java.lang.Object#equals(java.lang.Object)
	*/	
    public boolean equals(Object o) {
        if (!(o instanceof Date))
            return false;
        Date other = (Date) o;
        return this.day == other.day
                && this.month.equals(other.month)
                && this.year == other.year;

    }

   /**
    * returns the date corresponding to tomorrow for this date
    * 
    * @return the date corresponding to tomorrow for this date
    */
    public Date tomorrow() {
        if (this.isEndOfYear()) {
            return new Date(1, Month.january, this.year + 1);
        } else if (this.isEndOfMonth()) {
            return new Date(1, this.month.next(), this.year);
        }
        return new Date(this.day + 1, this.month, this.year);
    }

    /**
     * computes the date reached in <code>nbDays</code> after this
     * 
     * @param nbDays the number of days between this and wanted date
     * @return the date reached in <code>nbDays</code> after this
     * @exception IllegalArgumentException if <code>nbDays</code> is negative
     */
    public Date nbDaysAfter(int nbDays) throws IllegalArgumentException {
        if (nbDays < 0)
            throw new IllegalArgumentException("argument should be positive");

        // for sure we could do 'complex' tests and loops depending on fields
        // but it is simplier to iterate over tomorrow...

        Date result = this;
        for (int i = 0; i < nbDays; i++) {
            result = result.tomorrow();
        }
        return result;
    }

    /**
     * <code>true</code> if this date corresponds to the last day of a year
     * 
     * @return <code>true</code> if this date corresponds to the last day of a year
     */
    private boolean isEndOfYear() {
        return (this.day == 31 && this.month == Month.december);
    }

    /**
     * <code>true</code> if this date corresponds to the last day of a month
     * 
     * @return <code>true</code> if this date corresponds to the last day of a month
     */
    private boolean isEndOfMonth() {
        return this.day == this.month.getNbOfDays(this.year);
    }


    /**
     * return true iff given year is a leap year
     * (for french student : leap year is "année bissextile" ;-) )
     * 
     * @param year the year
     * @return true if year is a leap year, else false
     */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public String toString() {
        return this.day + " " + this.month + " " + this.year;
    }

}
