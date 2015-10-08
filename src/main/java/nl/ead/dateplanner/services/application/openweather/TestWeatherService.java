package nl.ead.dateplanner.services.application.openweather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestWeatherService implements IWeatherService {

    private List<Forecast> returnValue = new ArrayList<>();

    @Override
    public List<Forecast> retrieveWeather(Float latitude, Float longitude, String dayPart) throws IOException {
        return returnValue;
    }


    public void SetReturnValue(List<Forecast> forecasts) {
        returnValue = forecasts;
    }
}
