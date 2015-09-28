package nl.ead.dateplanner.services.application.google;

import net.sf.sprockets.google.Place;
import net.sf.sprockets.google.Places;

import java.io.IOException;
import java.util.List;

public class RestaurantService {

    public RestaurantService() { // TODO provide mock object for places API wrapper?

    }

	public static String getRestaurantsNearPlace(String place) {
        String ret = "";
        try {
            List<Place> places = Places.textSearch(new Places.Params().query(place).keyword("restaurant")).getResult();

            return places.get(0).getName();
        } catch (IOException e) {
            // handle exception
        }
        return ret;
    }
}