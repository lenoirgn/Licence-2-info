
import java.util.ArrayList;
import java.util.List;
import rental.Vehicle;

public class RentalAgency{
   private List<Vehicle> allVehicles;

   public RentalAgency(){
    this.allVehicles=new ArrayList<>();
   }
   public void displayAllvehicles(){
        for(Vehicle veh: this.allVehicles){
            System.out.println(veh.toString());
        }
   }

   public void removeVehicle(Vehicle veh) throws UnknownVehicleException{
        if (this.allVehicles.contains(veh)){
            this.allVehicles.remove(veh);
        }else{
            throw new UnknownVehicleException();
        }
   }
   public List<Vehicle> selectByMaxPrice100(){
        List<Vehicle> res= new ArrayList<>();
        for (Vehicle veh: this.allVehicles ){
            if(veh.getDailyRentalPrice()<100){
                res.add(veh);
            }
        }
        return res;
   }
   public List<Vehicle> selectByBrandTimoleon(){
        List<Vehicle> res= new ArrayList<>();
        for (Vehicle veh: this.allVehicles ){
            if(veh.getBrand().equals("Timoleon")){
                res.add(veh);
            }
        }
        return res;
   }


} 