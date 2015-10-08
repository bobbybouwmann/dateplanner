package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;

import java.util.ArrayList;
import java.util.List;

public class DateOption {

    public Place place;

    public List<Forecast> forecast = new ArrayList<>();

}
