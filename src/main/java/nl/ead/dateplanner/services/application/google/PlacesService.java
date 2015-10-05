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
     * Get the places near a given location of given type
     * @param countryCode code of the country e.g. "NL"
     * @param city Query name of a city or location. For example: "Amsterdam"
     * @param type The type of place to be searched for
     * @return Places near by given city or location of given type.
     */
    public List<Place> getPlacesNearLocation(String countryCode, String city, String type) {
        ArrayList<Place> places = new ArrayList<>();

        List<net.sf.sprockets.google.Place> placesFound = getPlacesNear(type, city + "," + countryCode);
        for (net.sf.sprockets.google.Place place : placesFound) {
            Place converted = new Place();

            converted.name = place.getName();
            converted.type = type;
            converted.vicinety = place.getVicinity();
            converted.placeId = place.getPlaceId().getId();

            List<net.sf.sprockets.google.Place.OpeningHours> openinghours = place.getOpeningHours();
            if (openinghours == null) {
                places.add(converted);
                return places;
            }

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