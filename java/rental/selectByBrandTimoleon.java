
import rental.Filter;
import rental.Vehicle;

public class selectByBrandTimoleon implements Filter{
    private String  byBrand;

    public selectByBrandTimoleon(String brand){
        this.byBrand=brand;
    }
    public boolean filterBy(Vehicle veh){
        return veh.getBrand().equals(this.byBrand);
    }

}