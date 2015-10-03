package nl.ead.dateplanner.services.application.google;

import net.sf.sprockets.google.Places;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlacesService implements IPlacesService {

    /**
     * Get the restaurants near a given place
     * @param place Query name of a city or location. For example: "Amsterdam, nl"
     * @return Restaurants near by given city or location.
     */
	public List<net.sf.sprockets.google.Place> getRestaurantsNearPlace(String place) {
        String queryString = "restaurants near " + place;
        try {
            List<net.sf.sprockets.google.Place> places = Places.textSearch(new Places.Params().query(queryString).keyword("restaurant")).getResult();
            return places;
        } catch (IOException e) {
            // handle exception
        }
        return null;
    }

    /**
     * Get places near the given location of given type
     * @param type Place types to be found
     * @param location Location where we will search for any places of given type
     * @return A list of places from given type
     */
    public List<Place> getPlacesNearLocation(String type, String location) {
        ArrayList<Place> places = new ArrayList<>();

        List<net.sf.sprockets.google.Place> placesFound = getPlacesNear(type, location);
        for (net.sf.sprockets.google.Place place : placesFound) {
            Place converted = new Place();

            converted.name = place.getName();
            converted.type = type;
            converted.vicinety = place.getVicinity();
            converted.placeId = place.getPlaceId().getId();

            List<net.sf.sprockets.google.Place.OpeningHours> openinghours = place.getOpeningHours();
            for (net.sf.sprockets.google.Place.OpeningHours anOpeningHour : openinghours) {
                OpeningHour openingHour = new OpeningHour();
                openingHour.closeDay = anOpeningHour.getCloseDay().name();
                openingHour.openDay = anOpeningHour.getOpenDay().name();

                openingHour.openHour = anOpeningHour.getOpenHour();
                openingHour.closeHour = anOpeningHour.getCloseHour();

                openingHour.openMinute = anOpeningHour.getOpenMinute();
                openingHour.closeMinute = anOpeningHour.getCloseMinute();

                converted.openingHours.add(openingHour);
            }

            places.add(converted);
        }

        return places;
    }

    /**
     * Query the google places API through the Sprocket wrapper to find the places
     * @param type Place Type
     * @param location Location where we will search for places
     * @return List with places of given type or null if invalid search
     */
    private List<net.sf.sprockets.google.Place> getPlacesNear(String type, String location) {
        String queryString = type + "s near " + location;
        try {
            List<net.sf.sprockets.google.Place> places = Places.textSearch(new Places.Params().query(queryString)).getResult();
            return places;
        } catch (IOException e) {
            // handle exception
        }
        return null;
    }
}