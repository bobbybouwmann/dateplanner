package nl.ead.dateplanner.services.application.google;

import java.util.ArrayList;

public class Place {

    public String type;

    public String placeId;

    public String name;

    public String vicinity;

    public Double latitude;

    public Double longitude;

    public ArrayList<OpeningHour> openingHours = new ArrayList<>();

}
