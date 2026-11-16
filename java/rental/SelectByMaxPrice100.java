package rental;
public class SelectByMaxPrice100 implements Filter{
    private int price;
    public  SelectByMaxPrice100(int price ){
        this.price=price;
    }
    public boolean filterBy(Vehicle veh){
        return veh.getDailyRentalPrice()<this.price;
    }

}