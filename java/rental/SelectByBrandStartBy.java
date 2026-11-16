package rental;

public class SelectByBrandStartBy{
    private char letter;
    public SelectByBrandStartBy(char letter){
        this.letter=letter;
    }
    public boolean filterBy(Vehicle veh){
        return veh.getBrand().charAt(0)==this.letter;
    }
}