package rental;
import java.util.List;

public class AgencyMain{
public static void main(String[] args) {

    RentalAgency agency = new RentalAgency();

    // Création des véhicules
    Vehicle v1 = new Vehicle("Timoleon", "Leon", 2020, 80);
    Vehicle v2 = new Vehicle("Toyota", "Corolla", 2019, 120);
    Vehicle v3 = new Vehicle("Timoleon", "Timo", 2015, 90);
    Vehicle v4 = new Vehicle("Peugeot", "208", 2022, 70);
    Vehicle v5 = new Vehicle("BMW", "Serie 3", 2021, 150);

    // Ajout des véhicules à l'agence
    agency.addVehicle(v1);
    agency.addVehicle(v2);
    agency.addVehicle(v3);
    agency.addVehicle(v4);
    agency.addVehicle(v5);
    // Affichage de tous les véhicules
    System.out.println("=== Tous les véhicules ===");
    agency.displayAllvehicles();

    // Sélection par prix maximum
    System.out.println("\n=== Véhicules à moins de 100 euros ===");
    List<Vehicle> result = agency.filterBy();
    for (Vehicle v : result) {
        System.out.println(v.toString());
    }
    
    
}
}