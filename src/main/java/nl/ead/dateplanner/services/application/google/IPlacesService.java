package nl.ead.dateplanner.services.application.google;

import java.util.List;
import nl.ead.dateplanner.services.application.google.Place;

/**
 * Created by Thomas Kooi on 1-10-2015.
 */
public interface IPlacesService {

    /**
     * Get the places near a given location of given type
     * @param countryCode code of the country e.g. "NL"
     * @param city Query name of a city or location. For example: "Amsterdam"
     * @param type The type of place to be searched for
     * @return Places near by given city or location of given type.
     */
    public List<Place> getPlacesNearLocation(String countryCode, String city, String type);
}
