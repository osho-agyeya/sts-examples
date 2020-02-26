

enum FUEL_TYPE {
    PETROL, DIESEL
}


/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class Car {

    private float price;
    private String model;
    private final String company;
    private float mileage;
    private Wheel[] wheels;
    private FUEL_TYPE fuelType;

    public float getPrice() {
        return this.price;
    }

    /**
     * @return the fuelType
     */
    public FUEL_TYPE getFuelType() {
        return this.fuelType;
    }

    public void setPrice(final float price) {
        if (price <= 0) {
            throw new IllegalArgumentException("price is illegal, price =" + price);
        }
        this.price = price;

    }


    public float getMileage() {
        return this.mileage;
    }

    public void setMileage(final float mileage) {
        this.mileage = mileage;
    }


    public String getModel() {
        return this.model;
    }

    public String getCompany() {
        return this.company;
    }

    public Car(final float price, final String model, final String company, final FUEL_TYPE fuel_TYPE) {
        super();
        this.fuelType = fuel_TYPE;
        setPrice(price);
        this.model = model;
        this.company = company;
        // this.mileage = this.mileage;
        // this.wheels = this.wheels;
    }


}