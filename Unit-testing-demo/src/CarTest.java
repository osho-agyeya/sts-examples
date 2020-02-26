import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class CarTest {

    /**
     * Test method for {@link Car#setPrice(float)}.
     */


    @Test
    public void testSetPrice() {

        Car car = new Car(120.0f, "i10", "tesla", FUEL_TYPE.DIESEL);
        car.setPrice(2000.4f);
        System.out.println(car.getPrice());
        assertEquals(2000.4f, car.getPrice(), 0.001);

    }


    /**
     * Test method for {@link Car#setPrice(float)}.
     */
    @Test
    public void testSetPriceNegative() {

        Car car = new Car(120.0f, "i10", "tesla", FUEL_TYPE.DIESEL);
        try {
            car.setPrice(-2000.4f);
        } catch (Exception e) {
            assertTrue(e != null);
        }
        // System.out.println(car.getPrice());
        // assertEquals(2000.4F, car.getPrice(), 0.001);
    }

}
