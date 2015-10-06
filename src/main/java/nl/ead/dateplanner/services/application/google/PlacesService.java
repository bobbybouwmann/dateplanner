package nl.ead.dateplanner.services.application.google;

import net.sf.sprockets.google.Places;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PlacesService implements IPlacesService {

    /**
     * Get the places near a given location of given type
     *
     * @param latitude Location latitude
     * @param longitude Location longitude
     * @param type The type of place to be searched for
     * @param radius The radius for the location (in meters)
     * @return Places near by given city or location of given type.
     */
    public List<Place> getPlacesNearLocation(BigDecimal latitude, BigDecimal longitude, String type, BigDecimal radius) {
        List<Place> places = new ArrayList<>();

        List<net.sf.sprockets.google.Place> placesFound = getPlacesNear(type, latitude.doubleValue(), longitude.doubleValue(), radius.intValue());
        for (net.sf.sprockets.google.Place place : placesFound) {
            Place converted = new Place();

            converted.name = place.getName();
            converted.type = type;
            converted.vicinety = place.getVicinity();
            converted.placeId = place.getPlaceId().getId();

            List<net.sf.sprockets.google.Place.OpeningHours> openinghours = place.getOpeningHours();
            if (openinghours != null) {
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
            }
            places.add(converted);
        }

        return places;
    }

    /**
     * Query the google places API through the Sprocket wrapper to find the places
     *
     * @param type Place Type
     * @param latitude Location latitude
     * @param longitude Location longitude
     * @return List with places of given type or null if invalid search
     */
    private List<net.sf.sprockets.google.Place> getPlacesNear(String type, Double latitude, Double longitude, Integer radius) {
        try {

            List<net.sf.sprockets.google.Place> places = Places.nearbySearch(new Places.Params()
                .location(longitude, latitude)
                .types(type)
                .radius(radius)
                .maxResults(20), Places.Field.NAME, Places.Field.VICINITY, Places.Field.TYPES, Places.Field.OPENING_HOURS
            ).getResult();

            // check if we found places.
            if (places != null) {
                return places;
            }
        } catch (IOException e) {
            // todo
        }
        return new ArrayList<net.sf.sprockets.google.Place>();
    }
}