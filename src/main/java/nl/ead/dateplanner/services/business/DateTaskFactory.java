package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.application.DateFinderFactory;

import java.io.FileNotFoundException;

public class DateTaskFactory {

    public IDateTaskService create() throws FileNotFoundException {
        DateFinderFactory factory = new DateFinderFactory();

        return new DateTaskService(factory.create());
    }

}
