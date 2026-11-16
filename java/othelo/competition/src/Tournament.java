
import java.util.Random;

public class Tournament {

    // Le constructeur
    public Tournament(Level niveau, Competitor[] comp){
        this.niveau = niveau;
        this.comp = comp;
    }

    //Les attributs
    private Level niveau;
    private Competitor[] comp;

    //Les methodes
    public Competitor playOneMatch (Competitor comp1, Competitor comp2){
        Random random = new Random();
        return random.nextBoolean() ? comp1 : comp2;

    }
    public Competitor[] playOneRound(Competitor[] comp){
        int j = 0;
        Competitor [] res;
        res = new Competitor [comp.length/2];
        for (int i = 0; i<comp.length; i+=2){
            res[j] = playOneMatch(comp[i], comp[i+1]);
        }
        return res;
    }

    public Competitor play(Competitor[] comp) throws NotPowerOf2Exception {
        
        try{
            if (comp.length == 0
                || (comp.length & (comp.length - 1)) != 0) {
            throw new NotPowerOf2Exception();
        }
            while (comp.length != 1){
                comp = this.playOneRound(comp);
            }return comp[0];
            
        }catch(NotPowerOf2Exception e) {
        throw e;
    }
    }

    
}