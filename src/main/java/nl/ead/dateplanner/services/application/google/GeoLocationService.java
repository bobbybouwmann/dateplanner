package nl.ead.dateplanner.services.application.google;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

import java.io.IOException;
import java.math.BigDecimal;

public class GeoLocationService implements IGeoLocationService {

    private final Geocoder geocoder = new Geocoder();

    @Override
    public GeoLocation getLocation(String locationName) {
        try {
            // build and sent the request
            GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(locationName).getGeocoderRequest();

            // get the response
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);

            // Get the geo location
            BigDecimal latitude = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat();
            BigDecimal longitude = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng();

            return new GeoLocation(latitude, longitude);
        } catch (IOException e) {
            // TODO log and handle exception
        }
        return null;
    }
}
