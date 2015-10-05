package nl.ead.dateplanner.services.application;

import java.io.IOException;
import java.math.BigDecimal;

public interface IDateFinderService {

    DateOption getDateOptions(String type, String location, String dayPart, BigDecimal radius) throws IOException;

}
