package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.application.DateFinderFactory;

public class DateTaskFactory {

    public IDateTaskService create() {
        DateFinderFactory factory = new DateFinderFactory();

        return new DateTaskService(factory.create());
    }

}
