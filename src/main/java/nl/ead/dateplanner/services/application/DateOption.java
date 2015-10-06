package nl.ead.dateplanner.services.application;

import nl.ead.dateplanner.services.application.google.Place;
import nl.ead.dateplanner.services.application.openweather.Forecast;

import java.util.ArrayList;
import java.util.List;

public class DateOption {

    public List<Forecast> forecasts = new ArrayList<>();

    public List<Place> places = new ArrayList<>();

}
