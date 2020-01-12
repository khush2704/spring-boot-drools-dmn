package org.chanwr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TaxiRide {

    private Boolean isNightSurcharge;
    private Long distanceInMile;

}
