package nl.ead.dateplanner.services.application.google;

import java.math.BigDecimal;

public class GeoLocation {

    public BigDecimal latitude;
    public BigDecimal longitude;

    public GeoLocation(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
