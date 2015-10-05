package nl.ead.dateplanner.services.application.google;

import java.math.BigDecimal;

public class GeoLocation {

    public BigDecimal longitude;
    public BigDecimal latitude;

    public GeoLocation(BigDecimal longitude, BigDecimal latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
