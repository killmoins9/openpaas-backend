package org.linagora.webservice;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.linagora.webservice.RentCar;

public class RentCarTest {
    @Test
    public void shouldRentACar() {
        int initialNumberOfCars = 43;

        RentCar rentCar = new RentCar();
        rentCar.createCars(initialNumberOfCars);

        rentCar.rentCar();

        int oneRentedCar = 1;
        Integer expected = initialNumberOfCars - oneRentedCar;

        String actualString = (String) rentCar.getAvailableCars().getEntity();

        Integer actual = Integer.parseInt(actualString);

        assertThat(actual, is(expected));
    }
}
