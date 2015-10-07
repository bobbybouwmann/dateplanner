package nl.ead.dateplanner.services.application.google;

import java.util.ArrayList;

/**
 * Created by thoma on 3-10-2015.
 */
public class Place {

    public String type;
    public String placeId;
    public String name;
    public String vicinety;
    public Double latitude;
    public Double longitude;

    public ArrayList<OpeningHour> openingHours = new ArrayList<>();

    public Place() {

    }
}
