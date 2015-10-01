package nl.ead.dateplanner.services.application.google;

import net.sf.sprockets.google.Place;
import net.sf.sprockets.google.Places;

import java.io.IOException;
import java.util.List;

public class RestaurantService implements IRestaurantService {

	public List<Place> getRestaurantsNearPlace(String place) {
        String queryString = "restaurants near " + place;
        try {
            List<Place> places = Places.textSearch(new Places.Params().query(queryString).keyword("restaurant")).getResult();
            return places;
        } catch (IOException e) {
            // handle exception
        }
        return null;
    }
}