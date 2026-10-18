package poo.tools;

import poo.Date;

/** the 12 months in a year, with their number of days */
public enum Month {

    january(31),
    february(28),
    march(31),
    april(30), may(31),
    june(30), july(31), august(31), september(30), october(31),
    november(30), december(31);

    private final int nbOfDays;

    /**
     * @param nbDays number of days for this month (28 for february)
     */
    private Month(int nbOfDays) {
        this.nbOfDays = nbOfDays;
    }


    /**
     * returns the number of days of this month for given year
     * @param year the considered year
     * @return the number of days of this month for given year
     */
    public int getNbOfDays(int year) {
        /* VERSION ECRITE EN COURS
        if (this != Month.february) {
            return this.nbDays;
        }
        else { // february
            if (Date.isLeapYear(year)) {
                return this.nbDays + 1;                
            }
            else {
                return this.nbDays;
            }
        }
        */  
        // plus facile à lire 
        if (this == Month.february && Date.isLeapYear(year))
            return Month.february.nbOfDays + 1;        
        return this.nbOfDays;
    }

    /**
     * returns the month following this one
     * @return returns the month following this one
     */
    public Month next() {
        return Month.values()[(this.ordinal() + 1) % Month.values().length];
    }

}
