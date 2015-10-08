package nl.ead.dateplanner.services.application.google;

import java.util.ArrayList;
import java.util.List;

public class TestPlacesService implements IPlacesService {

    private List<Place> returnValue = new ArrayList<>();

    @Override
    public List<Place> getPlacesNearLocation(Double latitude, Double longitude, String type, Double radius) {
        return returnValue;
    }

    public void SetReturnValue(List<Place> places) {
        returnValue = places;
    }
}
