package org.chanwr.service;

import org.chanwr.config.TaxiFareConfiguration;
import org.chanwr.model.Fare;
import org.chanwr.model.TaxiRide;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TaxiFareConfiguration.class)
public class TaxiFareCalculatorServiceIntegrationTest {

    @Autowired
    private TaxiFareCalculatorService taxiFareCalculatorService;

    @Test
    public void whenNightSurchargeFalseAndDistanceLessThan10ThenFixFareWithoutNightSurcharge() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(false);
        taxiRide.setDistanceInMile(9L);
        Fare rideFare = new Fare();
        Long totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFare);

        assertNotNull(totalCharge);
        assertEquals(Long.valueOf(70L), totalCharge);
    }

}
