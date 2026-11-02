package ds1game.tools;
import java.util.Random;

public enum Land {
    MOUNTAIN, FOREST, FIELD, SWAMP, SEA;
    
    /** returns a random land, bbut not SEA
     * @return a random land (but not SEA)
     */
    public static Land random() {
        return Land.values()[new Random().nextInt(Land.values().length - 1 )];
    }
}
