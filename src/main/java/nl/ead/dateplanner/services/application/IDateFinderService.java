package nl.ead.dateplanner.services.application;

public interface IDateFinderService {

    DateOption getDateOptions(String type, String countryCode, String location, String dayPart);

}
