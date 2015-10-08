package nl.ead.dateplanner.services.application.google;

import java.util.List;

public interface IPlacesService {

    /**
     * Get the places near a given location of given type
     *
     * @param latitude Location latitude
     * @param longitude Location longitude
     * @param type The type of place to be searched for
     * @return Places near by given city or location of given type.
     */
    List<Place> getPlacesNearLocation(Double latitude, Double longitude, String type, Double radius);

}
