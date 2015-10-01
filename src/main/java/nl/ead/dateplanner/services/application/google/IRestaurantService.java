package nl.ead.dateplanner.services.application.google;

import net.sf.sprockets.google.Place;

import java.util.List;

/**
 * Created by Thomas Kooi on 1-10-2015.
 */
public interface IRestaurantService {

    /**
     * Get the restaurants near a given place
     * @param place Query name of a city or location. For example: "Amsterdam, nl"
     * @return Restaurants near by given city or location.
     */
    List<Place> getRestaurantsNearPlace(String place);
}
