package nl.ead.dateplanner.services.application.google;

import net.sf.sprockets.google.Place;

import java.util.List;

/**
 * Created by Thomas Kooi on 1-10-2015.
 */
public interface IRestaurantService {

    List<Place> getRestaurantsNearPlace(String place);
}
