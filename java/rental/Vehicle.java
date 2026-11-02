package rental;

public class Vehicle {

    private String brand;
    private String model;
    private int productionYear;
    private double dailyRentalPrice;

    public Vehicle(String brand, String model, int productionYear, double dailyRentalPrice) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle v = (Vehicle) o;

        return brand.equals(v.brand)
            && model.equals(v.model)
            && productionYear == v.productionYear
            && dailyRentalPrice == v.dailyRentalPrice;
    }

    
    public String toString() {
        return "Brand: " + brand
            + ", Model: " + model
            + ", Production year: " + productionYear
            + ", Daily rental price: " + dailyRentalPrice;
    }
}