package nl.ead.dateplanner.services.application.google;

import java.math.BigDecimal;

public class GeoLocation {

    public BigDecimal latitude;

    public BigDecimal longitude;

    /**
     * Create a new Geo Location
     * @param latitude Latitude coordinates
     * @param longitude Longitude coordinates
     */
    public GeoLocation(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
