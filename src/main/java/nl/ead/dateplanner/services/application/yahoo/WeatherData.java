package nl.ead.dateplanner.services.application.yahoo;

import java.util.List;

public class WeatherData {

    private List<Forecast> forecasts;

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

}
