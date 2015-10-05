package nl.ead.dateplanner.services.application.google;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

import java.io.IOException;
import java.math.BigDecimal;

public class GeoLocation {

    final Geocoder geocoder = new Geocoder();

    public BigDecimal longitude;
    public BigDecimal latitude;

    public GeoLocation(String $location) throws IOException {
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress($location).getGeocoderRequest();
        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);

        this.latitude = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat();
        this.longitude = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng();
    }
}
